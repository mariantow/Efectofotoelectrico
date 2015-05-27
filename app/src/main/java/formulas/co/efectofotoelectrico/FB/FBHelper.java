package formulas.co.efectofotoelectrico.FB;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import formulas.co.efectofotoelectrico.BuildConfig;


/**
 * Created by ${Mike} on 3/25/15.
 */
public class FBHelper {
    public static String TAG = FBHelper.class.getSimpleName();

    public void getDataFB(AccessToken token, final OnFacebookResponse listener) {
        Bundle params = new Bundle();
        //params.putString("fields", "id, name, picture, email, bio, gender, age_range");
        params.putString("fields", "email,age_range,gender,first_name,last_name,id");

        new GraphRequest(token, "/me", params, HttpMethod.GET, new GraphRequest.Callback() {
            @Override
            public void onCompleted(GraphResponse graphResponse) {
                if (BuildConfig.DEBUG) {
                    Log.e(TAG, "onCompleted");
                    Log.e(TAG, graphResponse.getJSONObject().toString());

                }

                Map<String, String> params = null;

                try {

                    if (graphResponse.getJSONObject().getString("email") != null) {
                        String email = graphResponse.getJSONObject().getString("email");
                        String name = graphResponse.getJSONObject().getString("first_name") + " " +
                                graphResponse.getJSONObject().getString("last_name");
                        String id = graphResponse.getJSONObject().getString("id");
                        String photo_url = getFbPhtoProfileUrl(graphResponse.getJSONObject().getString("id"));

                        params = getParamsFacebook(email, name, photo_url, id);
                    }


                } catch (JSONException e) {

                    String name = null;
                    try {
                        name = graphResponse.getJSONObject().getString("first_name") + " " +
                                graphResponse.getJSONObject().getString("last_name");
                        String id = graphResponse.getJSONObject().getString("id");
                        String photo_url = getFbPhtoProfileUrl(id);
                        params = getParamsFacebook(null, name, photo_url, id);
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }

                    // e.printStackTrace();
                }
                listener.dataProfile(params);

            }

        }).executeAsync();

    }

    public static Map<String, String> getParamsFacebook(String email, @NonNull String name, @NonNull String photoUrl, @NonNull String facebook_id) {
        Map<String, String> param = new HashMap<>();
        if (email != null) {
            param.put("email", email);
        }

        param.put("name", name);
        param.put("social_photo_url", photoUrl);
        param.put("social_id", facebook_id);
        param.put("password", "");
        param.put("provider", "facebook");

        return param;
    }

    private String getFbPhtoProfileUrl(String fb_id) {
        final String base = "https://graph.facebook.com/";
        String photo = base + fb_id + "/picture?type=large";
        return photo;
    }


}
