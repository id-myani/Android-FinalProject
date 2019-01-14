package com.example.id_myani.tugasakhir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestionExpertSystem_10 extends AppCompatActivity {

    TextView information;
    Button answareYES, answareNO;

    ClassifierResult classifierResult;

    NaiveBayes naiveBayes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_expert_system_10);
        information = findViewById(R.id.information);
        answareNO = findViewById(R.id.answareNO);
        answareYES = findViewById(R.id.answareYES);
        getInformation();
        buttonAnsware(answareYES, 1);
        buttonAnsware(answareNO, 0);
    }

    private  void getInformation(){
        Intent intent = getIntent();
        classifierResult = (ClassifierResult) intent.getSerializableExtra("classifierResult");
        naiveBayes = (NaiveBayes) intent.getSerializableExtra("naivebayes");
        Log.d("Tag","Terrys = "+classifierResult.getMaxResultId()+" "+String.valueOf(classifierResult.getMaxResultConfidence()));
        information.setText("Kuku anda terdeteksi memiliki kelaianan Terrys Nail, hal tersebut dapat menjadi tanda bahwa anda memiliki penyakit sistemik. Jawab pertanyaan dibawah ini untuk deteksi lebih lanjut");
        logInfo();
    }

    private void nextActivity(int x){
        naiveBayes.setQ10(x);
        naiveBayes.naiveBayesInference();
        Intent intent = new Intent(QuestionExpertSystem_10.this, FinalResult.class);
        intent.putExtra("naivebayes", naiveBayes);
        intent.putExtra("classifierResult",classifierResult);
        startActivity(intent);
    }

    private void buttonAnsware(Button button, final int x){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity(x);
            }
        });
    }

    private void logInfo(){
        Log.d("Tag","Q-1 = "+naiveBayes.getQ1());
        Log.d("Tag","Q-2 = "+naiveBayes.getQ2());
        Log.d("Tag","Q-3 = "+naiveBayes.getQ3());
        Log.d("Tag","Q-4 = "+naiveBayes.getQ4());
        Log.d("Tag","Q-5 = "+naiveBayes.getQ5());
        Log.d("Tag","Q-6 = "+naiveBayes.getQ6());
        Log.d("Tag","Q-7 = "+naiveBayes.getQ7());
        Log.d("Tag","Q-8 = "+naiveBayes.getQ8());
        Log.d("Tag","Q-9 = "+naiveBayes.getQ9());
        Log.d("Tag","Q-10 = "+naiveBayes.getQ10());
    }
}
