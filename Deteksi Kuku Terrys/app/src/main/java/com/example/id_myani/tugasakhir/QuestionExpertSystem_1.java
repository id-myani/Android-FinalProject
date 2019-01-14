package com.example.id_myani.tugasakhir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class QuestionExpertSystem_1 extends AppCompatActivity {

    TextView information;
    Button answareYES, answareNO;

    ClassifierResult classifierResult;
    NaiveBayes naiveBayes = new NaiveBayes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_expert_system_1);
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
        Log.d("Tag","Terrys = "+classifierResult.getMaxResultId()+" "+String.valueOf(classifierResult.getMaxResultConfidence()));
        information.setText("Kuku anda terdeteksi memiliki kelaianan Terrys Nail, hal tersebut dapat menjadi tanda bahwa anda memiliki penyakit sistemik. Jawab pertanyaan dibawah ini untuk deteksi lebih lanjut");
    }

    private void nextActivity(int x){
        naiveBayes.setQ1(x);
        Intent intent = new Intent(QuestionExpertSystem_1.this, QuestionExpertSystem_2.class);
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


}
