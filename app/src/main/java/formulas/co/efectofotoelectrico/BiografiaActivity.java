package formulas.co.efectofotoelectrico;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class BiografiaActivity extends ActionBarActivity implements View.OnClickListener {
    TextView txtClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biografia);
        txtClick = (TextView) findViewById(R.id.textView4);

        txtClick.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_biografia, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goLink(String url){
        Intent url_ = new Intent(Intent.ACTION_VIEW);
        url_.setData(Uri.parse(url));
        this.startActivity(url_);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textView4:
                goLink("http://es.wikipedia.org/wiki/Albert_Einstein");
                break;
        }
    }
}
