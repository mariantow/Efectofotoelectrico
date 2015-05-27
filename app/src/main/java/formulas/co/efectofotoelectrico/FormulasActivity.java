package formulas.co.efectofotoelectrico;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import formulas.co.efectofotoelectrico.drawable.FormulacuatroActivity;
import formulas.co.efectofotoelectrico.drawable.FormulaseisActivity;


public class FormulasActivity extends ActionBarActivity implements View.OnClickListener {
    ImageButton button1,button2, button3, button4, button5, button6 ,button7, button8, button9, button10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulas);
        button1 = (ImageButton) findViewById(R.id.imageButton);
        button2 = (ImageButton) findViewById(R.id.imageButton2);
        button3 = (ImageButton) findViewById(R.id.imageButton3);
        button4 = (ImageButton) findViewById(R.id.imageButton4);
        button5 = (ImageButton) findViewById(R.id.imageButton5);
        button6 = (ImageButton) findViewById(R.id.imageButton6);
        button7 = (ImageButton) findViewById(R.id.imageButton7);
        button8 = (ImageButton) findViewById(R.id.imageButton8);
        button9 = (ImageButton) findViewById(R.id.imageButton9);
        button10 = (ImageButton) findViewById(R.id.imageButton10);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formulas, menu);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageButton:
                startActivity(new Intent(this, FormulaunoActivity.class));
                break;
            case R.id.imageButton2:
                startActivity(new Intent(this, FormuladosActivity.class));
                break;
            case R.id.imageButton3:
                startActivity(new Intent(this, FormulatresActivity.class));
                break;
            case R.id.imageButton4:
                startActivity(new Intent(this, FormulacuatroActivity.class));
                break;
            case R.id.imageButton5:
                startActivity(new Intent(this, FormulacincoActivity.class));
                break;
            case R.id.imageButton6:
                startActivity(new Intent(this, FormulaseisActivity.class));
                break;
            case R.id.imageButton7:
                startActivity(new Intent(this, FormulasieteActivity.class));
                break;
            case R.id.imageButton8:
                startActivity(new Intent(this, FormulaochoActivity.class));
                break;
            case R.id.imageButton9:
                startActivity(new Intent(this, FormulanueveActivity.class));
                break;
            case R.id.imageButton10:
                startActivity(new Intent(this, FormuladiezActivity.class));
                break;

        }
    }
}
