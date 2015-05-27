package formulas.co.efectofotoelectrico;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FormulaunoActivity extends ActionBarActivity implements View.OnClickListener {
    EditText editText_Kmax;
    EditText editText_V;
    TextView textView_resultado;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulauno);
        editText_Kmax = (EditText) findViewById(R.id.editText);
        editText_V = (EditText) findViewById(R.id.editText4);
        textView_resultado = (TextView) findViewById(R.id.textView73);
        btnCalcular = (Button) findViewById(R.id.button15);

        btnCalcular.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formulauno, menu);
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

    public void energiaCinetica_1 (View view)
    {
        String Kmax = editText_Kmax.getText().toString();
        String V = editText_V.getText().toString();
        double potencia = Math.pow(10,-19);
        double e = 1.6 * potencia;
        //textView_variables.setText("Kmax: energia cinetica maxima"+"\n"+"e: carga del electron"+"\n"+"V: diferencia de potencial o potencial de frenado");
        double Vdif, K;
        if(Kmax=="")
        {

            Vdif=Double.valueOf(V).doubleValue();
            K=Vdif*e;
            textView_resultado.setText("el valor de Kmax = "+K+"Julios");
            if(V=="")
            {
                textView_resultado.setText("error, ingrese de nuevo las variables");
            }
        }
        else
        {
            K=Double.valueOf(Kmax).doubleValue();
            Vdif= K/e;
            textView_resultado.setText("el valor de V = "+Vdif+ "Voltios");
        }
    }

    @Override
    public void onClick(View v) {
        energiaCinetica_1(v);
    }
}
