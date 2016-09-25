package com.example.nickhuang1.matrix;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MakingSecondMatrix extends AppCompatActivity {
    private Button button;
    private int[] Matrix1Dm;
    private double[] Matrix1Data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_making_second_matrix);
        addListenerOnButton();

        Bundle b = getIntent().getExtras();
        if (b != null) {
            Matrix1Dm = b.getIntArray("Dimensions");
            Matrix1Data = b.getDoubleArray("Inside");
        }
    }

    public void addListenerOnButton () {
        final Context context = this;

        button = (Button) findViewById(R.id.button4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddingSecondElements.class);
                Bundle bundle = new Bundle();
                Bundle bundle2 = new Bundle();
                Bundle bundle3 = new Bundle();
                EditText editRow = (EditText) findViewById(R.id.editText4);
                EditText editColumn = (EditText) findViewById(R.id.editText5);

                String RowNum = editRow.getText().toString();
                String RowCol = editColumn.getText().toString();

                int RowNumber = Integer.parseInt(RowNum);
                int RowColumn = Integer.parseInt(RowCol);
                int[] ints = new int[2];
                ints[0] = RowNumber;
                ints[1] = RowColumn;

                bundle.putIntArray("2ndData", ints);
                bundle2.putIntArray("Matrix1Dm", Matrix1Dm);
                bundle3.putDoubleArray("Matrix1Data", Matrix1Data);
                intent.putExtras(bundle);
                intent.putExtras(bundle2);
                intent.putExtras(bundle3);

                if (intent.getExtras() == null) {
                    startActivity(intent);
                } else {
                    startActivity(intent);
                }

            }
        });
    }
}
