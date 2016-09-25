package com.example.nickhuang1.matrix;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddingSecondElements extends AppCompatActivity {
    private int[] temp;
    private Button button;
    private int[] Matrix1Dim;
    private double[] Matrix1Dat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_second_elements);
        addListenerOnButton();




        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            temp = bundle.getIntArray("2ndData");
            Matrix1Dim = bundle.getIntArray("Matrix1Dm");
            Matrix1Dat = bundle.getDoubleArray("Matrix1Data");
        }

        TextView textView = (TextView) findViewById(R.id.textView9);
        textView.setText("Please enter in the numbers for a " + temp[0] + " by " + temp[1] + " array: ");
    }

    public void addListenerOnButton () {
        final Context context = this;

        button = (Button) findViewById(R.id.button7);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(context, OverallMatrix2.class);
                Bundle bundle2 = new Bundle();
                Bundle bundle3 = new Bundle();
                Bundle bundle4 = new Bundle();
                Bundle bundle5 = new Bundle();


                // get string, cut out the commas, and pass it as an array for the next activity
                EditText holder = (EditText) findViewById(R.id.editText6);
                String str = holder.getText().toString();

                String[] arr = str.split(",");

                double[] simple = new double[arr.length];

                for(int x = 0; x < simple.length; x++) {
                    simple[x] = Double.parseDouble(arr[x]);
                }

                Bundle d = getIntent().getExtras();
                int[] times= d.getIntArray("2ndData");

                bundle2.putDoubleArray("2ndMatrixDat", simple);
                bundle3.putIntArray("2ndRowsAndCols", times);
                bundle4.putDoubleArray("1stMatrixDat", Matrix1Dat);
                bundle5.putIntArray("1stRowsAndCols", Matrix1Dim);
                intent2.putExtras(bundle2);
                intent2.putExtras(bundle3);
                intent2.putExtras(bundle4);
                intent2.putExtras(bundle5);

                if (intent2.getExtras() == null) {
                    startActivity(intent2);
                } else {
                    startActivity(intent2);
                }
            }
        });
    }
}
