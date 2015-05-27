package formulas.co.efectofotoelectrico;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FormulacincoActivity extends ActionBarActivity implements View.OnClickListener {
    EditText  editText_ene, editText_frec;
    TextView textView_resultado;
    Button BtnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulacinco);
        editText_ene = (EditText)findViewById(R.id.editText_ene);
        editText_frec = (EditText)findViewById(R.id.editText_frec);
        BtnCalcular = (Button)findViewById(R.id.BtnCalcular);
        textView_resultado = (TextView) findViewById(R.id.textView_Resultado);

        BtnCalcular.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formulacinco, menu);
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
    public void formulaenergia5 (View view)
    {
        double potenciah = Math.pow(10,-34);
        double h=6.63*potenciah;
        String E = editText_ene.getText().toString();
        String frec= editText_frec.getText().toString();
        double ene, v;
        if (E.equals(""))
        {
            if (frec.equals(""))
            {
                textView_resultado.setText("error, ingrese de nuevo las variables");
            }
            else
            {
                v=Double.valueOf(frec).doubleValue();
                ene=h*v;
                textView_resultado.setText("el valor de E = "+ene+" Julios");
            }
        }
        else
        {
            if (!frec.equals(""))
            {
                textView_resultado.setText("error, deje una variable libre para despejar");
            }
            else {
                ene=Double.valueOf(E).doubleValue();
                v=ene/h;
                textView_resultado.setText("el valor de v=" +v+" Hz");
            }
        }
    }

    @Override
    public void onClick(View v) {
        formulaenergia5(v);
    }
}
