package plkhealth.it.app.patientbook;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class DoctorVisitActivity extends AppCompatActivity {

    ImageView img_test ;


    private void bind_widget(){

        img_test = (ImageView)findViewById(R.id.img_test);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_visit);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("ลงบันทึกการเยี่ยม");

        bind_widget();

        Glide.with(this)
                .load("https://cdn2.iconfinder.com/data/icons/medical-services-2/256/Hospitalization-512.png")
                .into(img_test);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_doctor_visit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        if (menuItem.getItemId() == R.id.mnu_doctor_visit_save) {

            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}