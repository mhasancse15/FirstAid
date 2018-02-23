package com.mhasancse.firstaid.netCheck;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mhasancse.firstaid.MainActivity;
import com.mhasancse.firstaid.R;


public class NoNetworkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_network);


        getSupportActionBar().setTitle("No Connection");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btn = (Button) findViewById(R.id.btnRetry);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (NetworkUtils.isNetworkAvailable(NoNetworkActivity.this)) {
                    Intent login = new Intent(NoNetworkActivity.this, MainActivity.class);
                    NoNetworkActivity.this.finish();
                    startActivity(login);
                } else {
                    Toast.makeText(NoNetworkActivity.this, "No network connected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
