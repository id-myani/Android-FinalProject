package com.example.id_myani.tugasakhir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalResult extends AppCompatActivity {

    Button backToCapture;
    TextView information, hasilPakar;

    ClassifierResult classifierResult;
    NaiveBayes naiveBayes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);
        backToCapture = findViewById(R.id.backToCapture);
        information = findViewById(R.id.result);
        hasilPakar = findViewById(R.id.hasilPakar);

        Intent intent = getIntent();
        classifierResult = (ClassifierResult) intent.getSerializableExtra("classifierResult");

        getInformation();

        Log.d("Tag","Terrys = "+classifierResult.getMaxResultId()+" "+String.valueOf(classifierResult.getMaxResultConfidence()));
        ///*information.setText("Kuku anda terindikasi memiliki kelainan Terrys nail dan dan berdasarakan gejala yang anda rasakan maka anda terindikasi menderita penyakit cirrrhosis hati ["+classifierResult.getMaxResultId()+"] "+String.valueOf(classifierResult.getMaxResultConfidence()));*/

        if (classifierResult.getMaxResultId().equals("1") && (naiveBayes.getResultYes()>naiveBayes.getReslutNo()) ){
            information.setText("Kuku anda terindikasi memiliki kelainan Terrys Nail dan berdasarakan gejala yang anda rasakan maka anda terindikasi menderita penyakit sirosis hati, Segera periksa ke dokter untuk diagnosa lebih lanjut"
                    /*"Terrys = "+String.valueOf(classifierResult.getMaxResultConfidence())+", Pakar Yes "+naiveBayes.getResultYes()+", Pakar No "+naiveBayes.getReslutNo()+" Maka Sakit"*/);
        }else if (classifierResult.getMaxResultId().equals("1") && (naiveBayes.getResultYes()<naiveBayes.getReslutNo()) ){
            information.setText("Kuku anda terindikasi memiliki kelainan Terrys Nail dan berdasarakan gejala yang anda rasakan maka hati anda sehat, Periksa ke dokter untuk diagnosa lebih lanjut"
                    /*"Terrys = "+String.valueOf(classifierResult.getMaxResultConfidence())+", Pakar Yes "+naiveBayes.getResultYes()+", Pakar No "+naiveBayes.getReslutNo()+" Maka Sehat"*/);
        }else{
            //comment
        }

        backToCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinalResult.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private  void getInformation(){
        Intent intent = getIntent();
        classifierResult = (ClassifierResult) intent.getSerializableExtra("classifierResult");
        naiveBayes = (NaiveBayes) intent.getSerializableExtra("naivebayes");
        /*if (classifierResult.getMaxResultId().equals("1")){
            Log.d("Tag","Terrys = "+classifierResult.getMaxResultId()+" "+String.valueOf(classifierResult.getMaxResultConfidence()*100));
            information.setText("Kuku anda terindikasi memiliki kelainan Terrys Nail dan berdasarakan gejala yang anda rasakan maka anda terindikasi menderita penyakit sirosis hati. Segera periksa ke dokter untuk diagnosa lebih lanjut");
        }else {
            Log.d("Tag","Sehat = "+classifierResult.getMaxResultId()+" "+String.valueOf(classifierResult.getMaxResultConfidence()*100));
            information.setText("Kuku anda terindikasi memiliki kelainan Terrys Nail dan berdasarakan gejala yang anda rasakan maka hati anda sehat, Segera periksa ke dokter untuk diagnosa lebih lanjut");
        }*/
        Log.d("Tag", "naive bayes Yes = "+naiveBayes.getResultYes());
        Log.d("Tag", "naive bayes No  = "+naiveBayes.getReslutNo());
        if (naiveBayes.getResultYes()>naiveBayes.getReslutNo()){
            hasilPakar.setText("Hasil Pakar (+)");
        }else  {
            hasilPakar.setText("Hasil Pakar (-)");
        }
    }
}
