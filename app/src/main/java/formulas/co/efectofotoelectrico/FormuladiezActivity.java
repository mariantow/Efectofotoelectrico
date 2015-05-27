package formulas.co.efectofotoelectrico;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FormuladiezActivity extends ActionBarActivity implements View.OnClickListener {
    EditText editText_cin, editText_masa, editText_vel;
    TextView textView_resultado;
    Button BtnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formuladiez);
        BtnCalcular = (Button)findViewById(R.id.BtnCalcular);
        textView_resultado = (TextView)findViewById(R.id.textView_resultado);
        editText_cin = (EditText)findViewById(R.id.editText_cin);
        editText_masa = (EditText)findViewById(R.id.editText_masa);
        editText_vel = (EditText)findViewById(R.id.editText_vel);

        BtnCalcular.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formuladiez, menu);
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
    public void energiacinetica2 (View view)
    {
        String K = editText_cin.getText().toString();
        String m= editText_masa.getText().toString();
        String V= editText_vel.getText().toString();
        double ene, masa, vel;
        if (K.equals("")){
            if (m.equals("")){
                textView_resultado.setText("error, ingrese de nuevo las variables");
            }
            else {
                if (V.equals("")){
                    textView_resultado.setText("error, ingrese de nuevo las variables");
                }
                else {
                    masa=Double.valueOf(m).doubleValue();
                    vel=Double.valueOf(V).doubleValue();
                    ene=0.5*masa*vel*vel;
                    textView_resultado.setText("El valor de Kmax es "+ene+ "Julios");
                }
            }
        }
        else {
            if (m.equals("")) {
                if (V.equals("")){
                    textView_resultado.setText("error, ingrese de nuevo las variables");
                }
                else {
                    vel=Double.valueOf(V).doubleValue();
                    ene=Double.valueOf(K).doubleValue();
                    double multi1, multi2;
                    multi1=2*ene;
                    multi2=vel*vel;
                    masa=multi1/multi2;
                    textView_resultado.setText("El valor de m es "+masa+ "Kg");
                }
            }
            else {
                if(V.equals("")){
                    double multi1, multi2;
                    ene=Double.valueOf(K).doubleValue();
                    masa=Double.valueOf(m).doubleValue();
                    multi1=2*ene;
                    multi2=multi1/masa;
                    vel=Math.sqrt(multi2);
                    textView_resultado.setText("El valor de V es "+vel+ "m/s");
                }
                else {
                    textView_resultado.setText("error, ingrese de nuevo las variables");
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        energiacinetica2(v);
    }
}
