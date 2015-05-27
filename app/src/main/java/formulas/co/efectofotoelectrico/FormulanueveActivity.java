
package formulas.co.efectofotoelectrico;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FormulanueveActivity extends ActionBarActivity implements View.OnClickListener {
    EditText editText_frec, editText_landa;
    TextView textView_resultado;
    Button BtnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulanueve);
        BtnCalcular = (Button)findViewById(R.id.BtnCalcular);
        editText_frec = (EditText)findViewById(R.id.editText_frec);
        editText_landa = (EditText)findViewById(R.id.editText_landa);
        textView_resultado = (TextView)findViewById(R.id.textView_Resultado);

        BtnCalcular.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formulanueve, menu);
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
    public void frecuencia_nueve (View view)
    {
        String v = editText_frec.getText().toString();
        String landa= editText_landa.getText().toString();
        double potenciac = Math.pow(10, 8);
        double c = 3*potenciac;
        double frec, l;
        if (v.equals(""))
        {
            if(landa.equals("")){
                textView_resultado.setText("error, ingrese de nuevo las variables");
            }
            else {
                l=Double.valueOf(landa).doubleValue();
                frec=c/l;
                textView_resultado.setText("el valor de v "+frec+" Hz");
            }
        }
        else
        {
            frec=Double.valueOf(v).doubleValue();
            l=c/frec;
            textView_resultado.setText("el valor de ? "+l+" m");
        }
    }

    @Override
    public void onClick(View v) {
        frecuencia_nueve(v);
    }
}
