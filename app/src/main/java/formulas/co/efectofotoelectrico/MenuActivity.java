package formulas.co.efectofotoelectrico;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import formulas.co.efectofotoelectrico.drawable.FuncionesTrabajoActivity;


public class MenuActivity extends ActionBarActivity implements View.OnClickListener {
    Button btnAcerca,btnBiografia, btnFormula, btnAplicaciones, btnTrabajo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnAcerca = (Button) findViewById(R.id.button2);
        btnBiografia = (Button) findViewById(R.id.button3);
        btnFormula = (Button) findViewById(R.id.button4);
        btnAplicaciones = (Button) findViewById(R.id.button5);
        btnTrabajo = (Button) findViewById(R.id.button6);

        btnAcerca.setOnClickListener(this);
        btnBiografia.setOnClickListener(this);
        btnFormula.setOnClickListener(this);
        btnAplicaciones.setOnClickListener(this);
        btnTrabajo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button2:
                startActivity(new Intent(this, HistoriaActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this, BiografiaActivity.class));
                break;
            case R.id.button4:
                startActivity(new Intent(this, FormulasActivity.class));
                break;
            case R.id.button5:
                startActivity(new Intent(this, AplicacionesActivity.class));
                break;
            case R.id.button6:
                startActivity(new Intent(this, FuncionesTrabajoActivity.class));
                break;
        }
    }
}
