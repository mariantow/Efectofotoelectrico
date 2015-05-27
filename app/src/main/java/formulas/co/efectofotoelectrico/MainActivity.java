package formulas.co.efectofotoelectrico;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, FacebookCallback<LoginResult> {
    TextView txtOmitir;
    CallbackManager callbackManager;
    LoginResult loginResult;
    LoginButton authButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtOmitir = (TextView) findViewById(R.id.textView);
        txtOmitir.setOnClickListener(this);
        getKeyHash();
        authButton = (LoginButton) findViewById(R.id.authButton);
        callbackManager = CallbackManager.Factory.create();
        authButton.setReadPermissions(Arrays.asList("public_profile", "email", "user_friends"));
        authButton.registerCallback(callbackManager, this);


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void getKeyHash() {
        try {
            PackageInfo info = this.getPackageManager().getPackageInfo(
                    "formulas.co.efectofotoelectrico",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                // textEmail.setText(Base64.encodeToString(md.digest(), Base64.DEFAULT));
                Log.e("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }


    @Override
    public void onClick(View v) {
        if (v.equals(txtOmitir))
            startActivity(new Intent(this, MenuActivity.class));
    }

    @Override
    public void onSuccess(LoginResult loginResult) {
        startActivity(new Intent(this, MenuActivity.class));
    }

    @Override
    public void onCancel() {
        Toast.makeText(this, "Un error al entrar por Facebook", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(FacebookException e) {
        Toast.makeText(this, "Un error al entrar por Facebook", Toast.LENGTH_LONG).show();
    }
}
