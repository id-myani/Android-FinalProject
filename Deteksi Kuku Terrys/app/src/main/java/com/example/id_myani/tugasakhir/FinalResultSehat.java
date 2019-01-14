package com.example.id_myani.tugasakhir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalResultSehat extends AppCompatActivity {

    ClassifierResult classifierResult;
    TextView information;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result_sehat);
        information = findViewById(R.id.information);
        button = findViewById(R.id.backToCapture);
        getInformation();
    }

    private  void getInformation(){
        Intent intent = getIntent();
        classifierResult = (ClassifierResult) intent.getSerializableExtra("classifierResult");
        Log.d("Tag","Sehat = "+classifierResult.getMaxResultId()+" "+String.valueOf(classifierResult.getMaxResultConfidence()));
        information.setText("Kuku anda sehat dan tidak terdeteksi memiliki kelainan terrys nail "/*+String.valueOf(classifierResult.getMaxResultConfidence()*100)*/);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinalResultSehat.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
