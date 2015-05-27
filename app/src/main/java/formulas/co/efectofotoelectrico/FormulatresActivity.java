package formulas.co.efectofotoelectrico;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FormulatresActivity extends ActionBarActivity implements View.OnClickListener {

    EditText editText_Vc, editText_tra;
    TextView textView_resultado;
    Button btnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulatres);
        editText_Vc= (EditText) findViewById(R.id.editText_Vc);
        editText_tra= (EditText)findViewById(R.id.editText_tra);
        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        textView_resultado = (TextView)findViewById(R.id.textView_Calcular);

        btnCalcular.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formulatres, menu);
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
    public void frecuencia_de_corte(View view)
    {
        double potenciah = Math.pow(10,-34);
        double h=6.63*potenciah;
        String Vc = editText_Vc.getText().toString();
        String tra = editText_tra.getText().toString();
        double fi, frec;

        if (Vc.equals("")){
            if (tra.equals("")){
                textView_resultado.setText("error, ingrese de nuevo las variables");
            }
            else {
                fi=Double.valueOf(tra).doubleValue();
                frec=fi/h;
                textView_resultado.setText("Vc = "+frec+" Hz");
            }
        }
        else {
            if (tra.equals("")) {
                frec = Double.valueOf(Vc).doubleValue();
                fi = frec * h;
                textView_resultado.setText("? = " + fi + " Julios");
            }
            else {
                textView_resultado.setText("deje vacia una variable");
            }
        }


    }

    @Override
    public void onClick(View v) {
        frecuencia_de_corte(v);
    }
}
