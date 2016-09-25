package com.example.nickhuang1.matrix;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MatrixEntry1 extends AppCompatActivity {
    private int[] temp;
    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix_entry1);
        addListenerOnButton();
        addListenerOnButton3();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            temp = bundle.getIntArray("Data");
        }

        TextView textView = (TextView) findViewById(R.id.textView5);
        textView.setText("Please enter in the numbers for a " + temp[0] + " by " + temp[1] + " array: ");

    }

    public void addListenerOnButton () {
        final Context context = this;

        button = (Button) findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(context, OverallMatrix.class);
                Bundle bundle2 = new Bundle();
                Bundle bundle3 = new Bundle();

                // get string, cut out the commas, and pass it as an array for the next activity
                EditText holder = (EditText) findViewById(R.id.editText3);
                String str = holder.getText().toString();

                String[] arr = str.split(",");

                double[] simple = new double[arr.length];

                for(int x = 0; x < simple.length; x++) {
                    simple[x] = Double.parseDouble(arr[x]);
                }

                Bundle d = getIntent().getExtras();
                int[] times= d.getIntArray("Data");

                bundle2.putDoubleArray("MatrixInfo", simple);
                bundle3.putIntArray("RowsAndCols", times);
                intent2.putExtras(bundle2);
                intent2.putExtras(bundle3);

                if (intent2.getExtras() == null) {
                    startActivity(intent2);
                } else {
                    startActivity(intent2);
                }
            }
        });
    }

    public void addListenerOnButton3 () {
        final Context context = this;

        button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
