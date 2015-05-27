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

public class FormulacuatroActivity extends ActionBarActivity implements View.OnClickListener {
    EditText editText_ene,editText_landa;
    TextView textView_resultado;
    Button BtnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulacuatro);
        editText_ene =(EditText) findViewById(R.id.editText_ene);
        editText_landa = (EditText) findViewById(R.id.editText_landa);
        textView_resultado = (TextView)findViewById(R.id.BtnCalcular);
        BtnCalcular = (Button)findViewById(R.id.BtnCalcular);

        BtnCalcular.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formulacuatro, menu);
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
    public void Energia_funcion4 (View view)
    {
        double potenciac = Math.pow(10,8);
        double c = 3*potenciac;
        double potenciah = Math.pow(10,-34);
        double h=6.63*potenciah;
        String E = editText_ene.getText().toString();
        String landa = editText_landa.getText().toString();
        double l, multi,ener;
        if (E.equals(""))
        {
            if (landa.equals(""))
            {
                textView_resultado.setText("error, ingrese de nuevo las variables");
            }
            else
            {
                l=Double.valueOf(landa).doubleValue();
                multi=h*c;
                ener=multi/l;
                textView_resultado.setText("el valor de E = "+ener+" Julios");
            }
        }
        else {
            if (!landa.equals(""))
            {
                textView_resultado.setText("error, deje una variable libre para despejar");
            }
            else {
                ener=Double.valueOf(E).doubleValue();
                multi=h*c;
                l=multi/ener;
                textView_resultado.setText("el valor de  ? = "+l+" metros");
            }
        }
    }

    @Override
    public void onClick(View v) {
        Energia_funcion4(v);
    }
}
