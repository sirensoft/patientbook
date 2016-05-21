package plkhealth.it.app.patientbook;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class PersonalInfoActivity extends AppCompatActivity {


    MyGlobals myGlobal;
    WebView webView ;


    private void bindWebView(){
        webView = (WebView) findViewById(R.id.wb_personal_info);
        webView.setWebViewClient(new MyWebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);

    }
    private void loadData(String url){
        // Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Result handling
                        //System.out.println(response.substring(0,100));
                        webView.loadData(response, "text/html; charset=utf-8", "UTF-8");

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Error handling
                System.out.println("Something went wrong!");
                error.printStackTrace();

            }
        });

// Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        bindWebView();
        final String url = "https://www.gotoknow.org/posts/170091";
        loadData(url);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_personal_info);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadData(null,null,null);
                loadData(url);

            }
        });


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("ข้อมูลส่วนตัว");
        myGlobal = new MyGlobals(getApplicationContext());

        //pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        //String patient_cid = pref.getString("patient_cid", "");
        String patient_cid =myGlobal.getPatientCid();
        //Toast.makeText(getApplicationContext(),patient_cid,Toast.LENGTH_SHORT).show();



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }




}
