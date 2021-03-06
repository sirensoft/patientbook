package plkhealth.it.app.patientbook;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class HospitalActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("โรงพยาบาล");

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(menuItem);
    }


    public void btn_lab_click(View view){
        Intent intent = new Intent(this,LabActivity.class);
        startActivity(intent);
    }
    public void btn_contact_click(View view){
        Intent intent = new Intent(this,ContactActivity.class);
        startActivity(intent);
    }
    public void btn_drug_click(View view){
        Intent intent = new Intent(this,DrugActivity.class);
        startActivity(intent);
    }

}
