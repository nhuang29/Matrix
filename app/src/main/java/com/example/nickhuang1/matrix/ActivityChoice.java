package com.example.nickhuang1.matrix;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActivityChoice extends AppCompatActivity {
    private int[] _1stMatrixRandC;
    private int[] _2ndMatrixRandC;
    private double[] _1stMatrixData;
    private double[] _2ndMatrixData;

    private Button Add;
    private Button Multiply;
    private Button Subtract;
    private Button RowEchelon;
    private Button LU;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        addListenerOnButton1();
        addListenerOnButton2();
        addListenerOnButton3();
        addListenerOnButton4();
        addListenerOnButton5();

        Bundle b = getIntent().getExtras();
        if(b != null) {
            _1stMatrixData = b.getDoubleArray("1stD");
            _1stMatrixRandC = b.getIntArray("1stRAndC");
            _2ndMatrixData = b.getDoubleArray("2ndD");
            _2ndMatrixRandC = b.getIntArray("2ndRAndC");
        }
    }

    public void addListenerOnButton1 () {
        final Context context = this;

        Add = (Button) findViewById(R.id.button9);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FinalPage.class);
                double[] result = new double[_2ndMatrixData.length];
                for(int x = 0; x < _2ndMatrixData.length; x++) {
                    result[x] = _1stMatrixData[x] + _2ndMatrixData[x];
                }

                Bundle b = new Bundle();
                Bundle a = new Bundle();
                a.putIntArray("CandR", _1stMatrixRandC);
                b.putDoubleArray("Result", result);
                intent.putExtras(b);
                intent.putExtras(a);

                if (intent.getExtras() == null) {
                    startActivity(intent);
                } else {
                    startActivity(intent);
                }

            }

        });
    }

    public void addListenerOnButton3 () {
        final Context context = this;

        Subtract = (Button) findViewById(R.id.button10);

        Subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FinalPage.class);
                double[] result = new double[_2ndMatrixData.length];
                for(int x = 0; x < _2ndMatrixData.length; x++) {
                    result[x] = _1stMatrixData[x] - _2ndMatrixData[x];
                }

                Bundle b = new Bundle();
                Bundle a = new Bundle();
                a.putIntArray("CandR", _1stMatrixRandC);
                b.putDoubleArray("Result", result);
                intent.putExtras(b);
                intent.putExtras(a);

                if (intent.getExtras() == null) {
                    startActivity(intent);
                } else {
                    startActivity(intent);
                }
            }
        });
    }


    public void addListenerOnButton2 () {
        final Context context = this;

        Multiply = (Button) findViewById(R.id.button11);

        Multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FinalPage.class);

                // calculate the multiplication thing
                int ab = 0;
                double[] result = new double[_2ndMatrixRandC[1] * _1stMatrixRandC[0]];
                for(int x = 0; x < (_2ndMatrixData.length/_2ndMatrixRandC[1]); x++) {
                    for(int i = 0; i < (_1stMatrixData.length /  _1stMatrixRandC[0]); i++) {
                        result[ab] = (_1stMatrixData[i] * _2ndMatrixData[x]) +
                           (_1stMatrixData[i + 1] * _2ndMatrixData[x + _2ndMatrixRandC[1]]) +
                           (_1stMatrixData[i + 2] * _2ndMatrixData[x +  (2 * _2ndMatrixRandC[1])]);
                        ab += 1;
                    }
                }

                Bundle b = new Bundle();
                Bundle a = new Bundle();
                b.putDoubleArray("Result", result);
                a.putIntArray("CandR", _2ndMatrixRandC);
                intent.putExtras(b);
                intent.putExtras(a);
                if (intent.getExtras() == null) {
                    startActivity(intent);
                } else {
                    startActivity(intent);
                }
            }
        });
    }


    public void addListenerOnButton4 () {
        final Context context = this;

        RowEchelon = (Button) findViewById(R.id.button12);

        RowEchelon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FinalPage.class);
                double[] result = new double[_1stMatrixData.length];
                for (int x = 0; x < result.length; x++) {
                    if () {

                    }
                }

                Bundle b = new Bundle();
                Bundle a = new Bundle();
                b.putDoubleArray("Result", result);
                a.putIntArray("CandR", _1stMatrixRandC);
                intent.putExtras(b);
                intent.putExtras(a);
                if (intent.getExtras() == null) {
                    startActivity(intent);
                } else {
                    startActivity(intent);
                }
            }
        });
    }

    public void addListenerOnButton5 () {
        final Context context = this;

        LU = (Button) findViewById(R.id.button13);

        LU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FinalPage.class);
                double[] result = new double[_1stMatrixData.length];


                Bundle b = new Bundle();
                Bundle a = new Bundle();
                b.putDoubleArray("Result", result);
                a.putIntArray("CandR", _2ndMatrixRandC);
                intent.putExtras(b);
                intent.putExtras(a);
                if (intent.getExtras() == null) {
                    startActivity(intent);
                } else {
                    startActivity(intent);
                }
            }
        });
    }
}
