package formulas.co.efectofotoelectrico.drawable;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import formulas.co.efectofotoelectrico.R;

public class FormulaseisActivity extends ActionBarActivity implements View.OnClickListener {
    EditText editText_lc, editText_tra;
    TextView textView_resultado;
    Button BtnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaseis);
        BtnCalcular = (Button)findViewById(R.id.BtnCalcular);
        editText_lc = (EditText)findViewById(R.id.editText_lc);
        editText_tra = (EditText)findViewById(R.id.editText_tra);
        textView_resultado= (TextView)findViewById(R.id.BtnCalcular);

        BtnCalcular.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formulaseis, menu);
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
    public void umbral_de_corte(View view)
    {
        double potenciae = Math.pow(10,-19);
        double e = 1.6 * potenciae;
        double potenciah = Math.pow(10,-34);
        double h=6.63*potenciah;
        double potenciac = Math.pow(10,8);
        double c = 3*potenciac;
        String landac = editText_lc.getText().toString();
        String tra = editText_tra.getText().toString();
        double fi, lc, multi, fiJ;
        //textView_variables.setText("?c: umbral de corte "+"\n"+"h: constante de planck"+"\n"+"?: funcion de trabajo"+"\n"+"c: velocidad de la luz");
        if (landac.equals(""))
        {
            if (tra.equals(""))
            {
                textView_resultado.setText("error, ingrese de nuevo las variables");
            }
            else
            {

                fi=Double.valueOf(tra).doubleValue();
                if (fi<=0)
                {
                    textView_resultado.setText("error, ingrese de nuevo las variables");
                }
                fiJ=fi*e;
                multi= h*c;
                lc=multi/fiJ;
                textView_resultado.setText("el valor de ?c = "+lc+ " metros");
            }
        }
        else
        {
            if (!tra.equals(""))
            {
                textView_resultado.setText("Deje una variable libre para calcular");
            }
            else
            {
                lc = Double.valueOf(landac).doubleValue();

                if (lc == 0) {
                    textView_resultado.setText("error, longitud de onda de corte no puede ser cero");
                }
                multi = h * c;
                fi = multi / lc;
                textView_resultado.setText("el valor de ? = " + fi + " Julios");
            }
        }
    }

    @Override
    public void onClick(View v) {
        umbral_de_corte(v);
    }
}
