package formulas.co.efectofotoelectrico;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FormulasieteActivity extends ActionBarActivity implements View.OnClickListener {
    EditText editText_V, editText_v, editText_tra;
    TextView textView_resultado;
    Button BtnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulasiete);
        textView_resultado = (TextView)findViewById(R.id.textView_resultado);
        BtnCalcular = (Button)findViewById(R.id.BtnCalcular);
        editText_V = (EditText)findViewById(R.id.editText_V);
        editText_v = (EditText)findViewById(R.id.editText_v);
        editText_tra = (EditText)findViewById(R.id.editText_tra);

        BtnCalcular.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formulasiete, menu);
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
    public void igualdad (View view)
    {
        double potenciah = Math.pow(10,-34);
        double h=6.63*potenciah;
        double potenciae = Math.pow(10,-19);
        double e = 1.6 * potenciae;
        String V=editText_V.getText().toString();
        String v=editText_v.getText().toString();
        String fi=editText_tra.getText().toString();
        double multi1, multi2, vol, frec, tra;
        if (V.equals(""))
        {
            if (v.equals("") )
            {
                textView_resultado.setText("error, ingrese de nuevo las variables");
            }
            else
            {
                if (fi.equals(""))
                {
                    textView_resultado.setText("error, ingrese de nuevo las variables");
                }
                else {
                    frec=Double.valueOf(v).doubleValue();
                    tra=Double.valueOf(fi).doubleValue();
                    multi1=h*frec;
                    multi2=multi1-tra;
                    vol=multi2/e;
                    textView_resultado.setText("el valor de V ="+vol+" Voltios");

                }
            }
        }
        else
        {
            if (v.equals(""))
            {
                if (fi.equals(""))
                {
                    textView_resultado.setText("error, ingrese de nuevo las variables");
                }
                else
                {
                    vol=Double.valueOf(V).doubleValue();
                    tra=Double.valueOf(fi).doubleValue();
                    multi1=e*vol;
                    multi2=multi1+tra;
                    frec=multi2/h;
                    textView_resultado.setText("el valor de v ="+frec+" Hz");
                }
            }
            else {
                vol=Double.valueOf(V).doubleValue();
                frec=Double.valueOf(v).doubleValue();
                multi1=h*frec;
                multi2=e*vol;
                tra=multi1-multi2;
                textView_resultado.setText("el valor de ? ="+tra+" J");
            }
        }
    }

    @Override
    public void onClick(View v) {
        igualdad(v);
    }
}
