package formulas.co.efectofotoelectrico;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FormuladosActivity extends ActionBarActivity implements View.OnClickListener {
    EditText editText_Kmax, editText_v, editText_tra;
    TextView textView_resultado;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulados);
        editText_Kmax = (EditText) findViewById(R.id.editText_Kmax);
        editText_v = (EditText) findViewById(R.id.editText_v);
        editText_tra = (EditText) findViewById(R.id.editText_tra);
        textView_resultado = (TextView) findViewById(R.id.BtnCalcular);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formulados, menu);
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

    public void energiaCinetica_2(View view) {
        double potenciae = Math.pow(10, -19);
        double e = 1.6 * potenciae;
        double potenciah = Math.pow(10, -34);
        double h = 6.63 * potenciah;
        String Kmax = editText_Kmax.getText().toString();
        String v = editText_v.getText().toString();
        String tra = editText_tra.getText().toString();

        double K, vf, fi, multi, fJ;

        if (Kmax == "") {
            if (v == "" || tra == "") {
                textView_resultado.setText("error, ingrese de nuevo las variables");
            } else {
                vf = Double.valueOf(v).doubleValue();
                multi = vf * h;
                fi = Double.valueOf(tra).doubleValue();
                fJ = fi * e;
                K = multi - fJ;
                textView_resultado.setText("el valor de Kmax = " + K + " Julios");
            }
        } else {
            if (v == "") {
                if (tra == "") {
                    textView_resultado.setText("error, ingrese de nuevo las variables");
                } else {
                    fi = Double.valueOf(tra).doubleValue();
                    K = Double.valueOf(Kmax).doubleValue();
                    multi = K + fi;
                    vf = multi / h;
                    textView_resultado.setText("el valor de v = " + vf + " Hz");
                }
            } else {
                K = Double.valueOf(Kmax).doubleValue();
                vf = Double.valueOf(v).doubleValue();
                multi = h * vf;
                fi = multi - K;
                textView_resultado.setText("el valor de ? = " + fi + " Julios");
            }

        }

    }

    @Override
    public void onClick(View v) {
        energiaCinetica_2(v);
    }
}
