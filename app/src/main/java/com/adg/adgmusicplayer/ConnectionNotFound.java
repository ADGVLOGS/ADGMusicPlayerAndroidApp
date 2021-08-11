package com.adg.adgmusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConnectionNotFound extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_not_found);
        Button btnRetry = (Button) findViewById(R.id.btn_Shap);
        btnRetry.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(ConnectionNotFound.this, MainActivity.class);
                finish();
                ConnectionNotFound.this.startActivity(i);
            }
        });
    }


}