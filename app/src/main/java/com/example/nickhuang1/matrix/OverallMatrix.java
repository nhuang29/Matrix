package com.example.nickhuang1.matrix;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class OverallMatrix extends AppCompatActivity {
    double[] finalMatrix;
    int[] ints;
    final Context context = this;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overall_matrix);
        addListenerOnButton();



        Bundle bundling = getIntent().getExtras();
        if (bundling != null) {
            finalMatrix = bundling.getDoubleArray("MatrixInfo");
            ints = bundling.getIntArray("RowsAndCols");
        }

        TextView textView = (TextView) findViewById(R.id.textView6);
        textView.setText("Here is your " + ints[0] + " by " + ints[1] + " array: ");

        String[] holdString = new String[finalMatrix.length];
        for(int x = 0; x < finalMatrix.length; x++) {
            holdString[x] = Double.toString(finalMatrix[x]);
        }
        ArrayAdapter<String> ad = new ArrayAdapter<String>(OverallMatrix.this, android.R.layout.simple_list_item_1, holdString);
        GridView gridView = (GridView)findViewById(R.id.grid1);
        gridView.setNumColumns(ints[1]);

        gridView.setAdapter(ad);
    }

    public void addListenerOnButton () {
        final Context context = this;

        button = (Button) findViewById(R.id.button5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MakingSecondMatrix.class);
//                Bundle bundle = new Bundle();
//                EditText editRow = (EditText) findViewById(R.id.editText);
//                EditText editColumn = (EditText) findViewById(R.id.editText2);
//
//                String RowNum = editRow.getText().toString();
//                String RowCol = editColumn.getText().toString();
//
//                int RowNumber = Integer.parseInt(RowNum);
//                int RowColumn = Integer.parseInt(RowCol);
//                int[] ints = new int[2];
//                ints[0] = RowNumber;
//                ints[1] = RowColumn;
//
//                bundle.putIntArray("Data", ints);
//                intent.putExtras(bundle);
                // transfers over the data of dimensions and what's inside the matrix
                Bundle bundle = new Bundle();
                Bundle bundle2 = new Bundle();

                bundle.putIntArray("Dimensions", ints);
                bundle2.putDoubleArray("Inside", finalMatrix);
                intent.putExtras(bundle);
                intent.putExtras(bundle2);

                if (intent.getExtras() == null) {
                    startActivity(intent);
                } else {
                    startActivity(intent);
                }
            }
        });
    }
}
