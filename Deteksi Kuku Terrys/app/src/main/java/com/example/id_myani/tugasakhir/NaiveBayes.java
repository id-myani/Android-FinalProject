package com.example.id_myani.tugasakhir;

import android.util.Log;

import java.io.Serializable;

public class NaiveBayes implements Serializable {

    int q1, q2, q3, q4, q5, q6, q7, q8, q9, q10;
    int sumOfYes=0, sumOfNo=0;
    int classMuntahDarahYes=0, classMuntahDarahNo=0;
    int classKulitMataKuningYes=0, classKulitMataKuningNo=0;
    int classPembengkakanYes=0, classPembengkakanNo=0;
    int classBBTurunYes=0, classBBTurunNo=0;
    int classKembungYes=0, classKembungNo=0;
    int classTidakNafsuMakanYes=0, classTidakNafsuMakanNo=0;
    int classPerutMembesarYes=0, classPerutMembesarNo=0;
    int classMualMuntahYes=0, classMualMuntahNo=0;
    int classPucatYes=0, classPucatNo=0;
    int classLelahYes=0, classLelahNo=0;

    double probabilityClassYes, probabilityClassNo;

    float probabilityYes=0, probabilityNo=0;
    float resultYes=0, reslutNo=0;

/*
    int datasetQ1[] = {};
    int datasetQ2[] = {};
    int datasetQ3[] = {};
    int datasetQ4[] = {};
    int datasetQ5[] = {};
    int datasetQ6[] = {};
    int datasetQ7[] = {};
    int datasetQ8[] = {};
    int datasetQ9[] = {};
    int datasetQ10[] = {};
    int datasetResult[] = {};*/


    int datasetQ1[] = {1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    int datasetQ2[] = {1,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    int datasetQ3[] = {1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    int datasetQ4[] = {1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    int datasetQ5[] = {1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    int datasetQ6[] = {1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,1,1,1,0,0,0,0,0,0,1,0,0,0,0,1,1,1,1,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,1,1,1,0,0,0,0,0,0,1,0,0,0,0,1,1,1,1,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1};
    int datasetQ7[] = {1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,1,1,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,1,1,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,1,1,1,0,0,0,0,1,0,0,0,1,0,0,0,1,1,1,0,0,0,1,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,1,1,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,1,1,1,0,0,0,0,1,0,0,0,1,0,0,0,1,1,1,0,0,0,1,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,1,1};
    int datasetQ8[] = {1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,0,1,1,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,0,1,1,0,0,0,1,0,0,0,1,0,0,1,0,0,1,1,0,0,1,0,0,1,0,0,1,1,0,1,0,0,1,1,0,1,1,0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,0,1,1,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,0,1,1,0,0,0,1,0,0,0,1,0,0,1,0,0,1,1,0,0,1,0,0,1,0,0,1,1,0,1,0,0,1,1,0,1,1};
    int datasetQ9[] = {1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,1,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,1,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,1,0,1,0,0,0,1,0,0,0,1,0,0,1,0,1,0,1,0,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,1,0,1,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,1,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,1,0,1,0,0,0,1,0,0,0,1,0,0,1,0,1,0,1,0,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,1,0};
    int datasetQ10[] = {1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,1,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,1,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,1,1,0,0,0,0,1,0,0,0,1,0,0,1,0,1,1,0,0,0,1,0,0,1,0,1,1,0,0,1,0,1,1,0,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,1,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,1,1,0,0,0,0,1,0,0,0,1,0,0,1,0,1,1,0,0,0,1,0,0,1,0,1,1,0,0,1,0,1,1,0,1};
    int datasetResult[] = {1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,0,0,0,1,0,0,0,1,0,0,0,1,1,0,0,0,0,1,1,1,1,0,0,0,1,0,0,0,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

    public NaiveBayes() {


    }

    public void naiveBayesInference(){

        for(int i=0; i<datasetResult.length; i++){
            if (datasetResult[i]==1){
                sumOfYes += 1;
            }else {
                sumOfNo += 1;
            }

        }

        for (int i=0; i<datasetQ1.length; i++){
            if ((datasetQ1[i]==q1) && (datasetResult[i]==1)){
                classMuntahDarahYes += 1;
            }
            if ((datasetQ1[i]==q1) && (datasetResult[i]==0)){
                classMuntahDarahNo += 1;
            }
        }
        for (int i=0; i<datasetQ2.length; i++){
            if ((datasetQ2[i]==q2) && (datasetResult[i]==1)){
                classKulitMataKuningYes += 1;
            }
            if ((datasetQ2[i]==q2) && (datasetResult[i]==0)){
                classKulitMataKuningNo += 1;
            }
        }
        for (int i=0; i<datasetQ3.length; i++){
            if ((datasetQ3[i]==q3) && (datasetResult[i]==1)){
                classPembengkakanYes += 1;
            }
            if ((datasetQ3[i]==q3) && (datasetResult[i]==0)){
                classPembengkakanNo += 1;
            }
        }
        for (int i=0; i<datasetQ4.length; i++){
            if ((datasetQ4[i]==q4) && (datasetResult[i]==1)){
                classBBTurunYes += 1;
            }
            if ((datasetQ4[i]==q4) && (datasetResult[i]==0)){
                classBBTurunNo += 1;
            }
        }
        for (int i=0; i<datasetQ5.length; i++){
            if ((datasetQ5[i]==q5) && (datasetResult[i]==1)){
                classKembungYes += 1;
            }
            if ((datasetQ5[i]==q5) && (datasetResult[i]==0)){
                classKembungNo += 1;
            }
        }
        for (int i=0; i<datasetQ6.length; i++){
            if ((datasetQ6[i]==q6) && (datasetResult[i]==1)){
                classTidakNafsuMakanYes += 1;
            }
            if ((datasetQ6[i]==q6) && (datasetResult[i]==0)){
                classTidakNafsuMakanNo += 1;
            }
        }
        for (int i=0; i<datasetQ7.length; i++){
            if ((datasetQ7[i]==q7) && (datasetResult[i]==1)){
                classPerutMembesarYes += 1;
            }
            if ((datasetQ7[i]==q7) && (datasetResult[i]==0)){
                classPerutMembesarNo += 1;
            }
        }
        for (int i=0; i<datasetQ8.length; i++){
            if ((datasetQ8[i]==q8) && (datasetResult[i]==1)){
                classMualMuntahYes += 1;
            }
            if ((datasetQ8[i]==q8) && (datasetResult[i]==0)){
                classMualMuntahNo += 1;
            }
        }
        for (int i=0; i<datasetQ9.length; i++){
            if ((datasetQ9[i]==q9) && (datasetResult[i]==1)){
                classPucatYes += 1;
            }
            if ((datasetQ9[i]==q9) && (datasetResult[i]==0)){
                classPucatNo += 1;
            }
        }
        for (int i=0; i<datasetQ10.length; i++){
            if ((datasetQ10[i]==q10) && (datasetResult[i]==1)){
                classLelahYes += 1;
            }
            if ((datasetQ10[i]==q10) && (datasetResult[i]==0)){
                classLelahNo += 1;
            }
        }


        probabilityYes = (float)sumOfYes/datasetResult.length;
        probabilityNo = (float)sumOfNo/datasetResult.length;

        probabilityClassYes = (double) classMuntahDarahYes/sumOfYes*
                classKulitMataKuningYes/sumOfYes*classPembengkakanYes/sumOfYes*classBBTurunYes/sumOfYes*
                classKembungYes/sumOfYes*classTidakNafsuMakanYes/sumOfYes*classPerutMembesarYes/sumOfYes*classMualMuntahYes/sumOfYes*
                classPucatYes/sumOfYes*classLelahYes/sumOfYes;
        probabilityClassNo = (double) classMuntahDarahNo/sumOfNo*classKulitMataKuningNo/sumOfNo*
                classPembengkakanNo/sumOfNo*classBBTurunNo/sumOfNo*classKembungNo/sumOfNo*classTidakNafsuMakanNo/sumOfNo*
                classPerutMembesarNo/sumOfNo*classMualMuntahNo/sumOfNo*classPucatNo/sumOfNo*classLelahNo/sumOfNo;
        if (probabilityClassYes > Long.MAX_VALUE) {
            Log.d("d","Overflow");
        }
        resultYes =  (float) probabilityClassYes*probabilityYes;
        reslutNo = (float)  probabilityClassNo*probabilityNo;


        Log.d("d","menghitung Result");
        Log.d("d","datasetResult-Length = "+datasetResult.length);
        Log.d("d","Yes = "+sumOfYes);
        Log.d("d","No  = "+sumOfNo);

        Log.d("d","classMuntahDarahYes  = "+classMuntahDarahYes);
        Log.d("d","classMuntahDarahNo  = "+classMuntahDarahNo);
        Log.d("d","classKulitMataKuningYes  = "+classKulitMataKuningYes);
        Log.d("d","classKulitMataKuningNo  = "+classKulitMataKuningNo);
        Log.d("d","classPembengkakanYes = "+classPembengkakanYes);
        Log.d("d","classPembengkakanNo  = "+classPembengkakanNo);
        Log.d("d","classBBTurunYes = "+classBBTurunYes);
        Log.d("d","classBBTurunNo  = "+classBBTurunNo);

        Log.d("d","classKembungYes = "+classKembungYes);
        Log.d("d","classKembungNo  = "+classKembungNo);

        Log.d("d","classTidakNafsuMakanYes = "+classTidakNafsuMakanYes);
        Log.d("d","classTidakNafsuMakanNo  = "+classTidakNafsuMakanNo);

        Log.d("d","classPerutMembesarYes = "+classPerutMembesarYes);
        Log.d("d","classPerutMembesarNo  = "+classPerutMembesarNo);

        Log.d("d","classMualMuntahYes = "+classMualMuntahYes);
        Log.d("d","classMualMuntahNo  = "+classMualMuntahNo);

        Log.d("d","classPucatYes = "+classPucatYes);
        Log.d("d","classPucatNo  = "+classPucatNo);

        Log.d("d","classLelahYes = "+classLelahYes);
        Log.d("d","classLelahNo  = "+classLelahNo);

        Log.d("d","probabilityYes  = "+probabilityYes);
        Log.d("d","probabilityNo = "+probabilityNo);

        Log.d("d","probabilityClassYes  = "+probabilityClassYes);
        Log.d("d","probabilityClassNo  = "+probabilityClassNo);
    }


    public int getQ1() {
        return q1;
    }

    public void setQ1(int q1) {
        this.q1 = q1;
    }

    public int getQ2() {
        return q2;
    }

    public void setQ2(int q2) {
        this.q2 = q2;
    }

    public int getQ3() {
        return q3;
    }

    public void setQ3(int q3) {
        this.q3 = q3;
    }

    public int getQ4() {
        return q4;
    }

    public void setQ4(int q4) {
        this.q4 = q4;
    }

    public int getQ5() {
        return q5;
    }

    public void setQ5(int q5) {
        this.q5 = q5;
    }

    public int getQ6() {
        return q6;
    }

    public void setQ6(int q6) {
        this.q6 = q6;
    }

    public int getQ7() {
        return q7;
    }

    public void setQ7(int q7) {
        this.q7 = q7;
    }

    public int getQ8() {
        return q8;
    }

    public void setQ8(int q8) {
        this.q8 = q8;
    }

    public int getQ9() {
        return q9;
    }

    public void setQ9(int q9) {
        this.q9 = q9;
    }

    public int getQ10() {
        return q10;
    }
    public void setQ10(int q10) {
        this.q10 = q10;
    }

    public int getSumOfYes() {
        return sumOfYes;
    }

    public int getSumOfNo() {
        return sumOfNo;
    }
/*
    public int getClassMuntahDarahYes() {
        return classMuntahDarahYes;
    }

    public int getClassMuntahDarahNo() {
        return classMuntahDarahNo;
    }

    public int getClassKulitMataKuningYes() {
        return classKulitMataKuningYes;
    }

    public int getClassKulitMataKuningNo() {
        return classKulitMataKuningNo;
    }

    public int getClassPembengkakanYes() {
        return classPembengkakanYes;
    }

    public int getClassPembengkakanNo() {
        return classPembengkakanNo;
    }

    public int getClassBBTurunYes() {
        return classBBTurunYes;
    }

    public int getClassBBTurunNo() {
        return classBBTurunNo;
    }

    public int getClassKembungYes() {
        return classKembungYes;
    }

    public int getClassKembungNo() {
        return classKembungNo;
    }

    public int getClassTidakNafsuMakanYes() {
        return classTidakNafsuMakanYes;
    }

    public int getClassTidakNafsuMakanNo() {
        return classTidakNafsuMakanNo;
    }

    public int getClassPerutMembesarYes() {
        return classPerutMembesarYes;
    }

    public int getClassPerutMembesarNo() {
        return classPerutMembesarNo;
    }

    public int getClassMualMuntahYes() {
        return classMualMuntahYes;
    }

    public int getClassMualMuntahNo() {
        return classMualMuntahNo;
    }

    public int getClassPucatYes() {
        return classPucatYes;
    }

    public int getClassPucatNo() {
        return classPucatNo;
    }

    public int getClassLelahYes() {
        return classLelahYes;
    }

    public int getClassLelahNo() {
        return classLelahNo;
    } */

    public float getProbabilityYes() {
        return probabilityYes;
    }

    public float getProbabilityNo() {
        return probabilityNo;
    }

    public double getProbabilityClassYes() {
        return probabilityClassYes;
    }

    public double getProbabilityClassNo() {
        return probabilityClassNo;
    }

    public float getResultYes() {
        return resultYes;
    }

    public float getReslutNo() {
        return reslutNo;
    }
}
