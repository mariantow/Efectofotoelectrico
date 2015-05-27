package formulas.co.efectofotoelectrico;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FormulaochoActivity extends ActionBarActivity implements View.OnClickListener {
    EditText editText_ene, editText_tra;
    TextView textView_resultado;
    Button BtnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaocho);
        textView_resultado =(TextView)findViewById(R.id.textView_resultado);
        editText_ene = (EditText)findViewById(R.id.editText_ene);
        editText_tra = (EditText)findViewById(R.id.editText_tra);
        BtnCalcular = (Button)findViewById(R.id.BtnCalcular);

        BtnCalcular.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formulaocho, menu);
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
    public void desigualdad(View view)
    {
        String E = editText_ene.getText().toString();
        String fi= editText_tra.getText().toString();
        if (E.equals("") || fi.equals("")) {
            textView_resultado.setText("Ingrese de nuevo las variable");
        }
        else
        {
            double ene = Double.valueOf(E).doubleValue();
            double tra = Double.valueOf(fi).doubleValue();
            if (ene >= tra) {
                textView_resultado.setText("Cumple la propiedad");
            } else {
                textView_resultado.setText("NO cumple la propiedad");
            }
        }
    }

    @Override
    public void onClick(View v) {
        desigualdad(v);
    }
}
