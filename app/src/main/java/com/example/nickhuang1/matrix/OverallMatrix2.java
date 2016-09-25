package com.example.nickhuang1.matrix;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class OverallMatrix2 extends AppCompatActivity {
    double[] SecondFinalMatrix;
    int[] SecondInts;
    final Context context = this;
    int[] Matrix1stDimensions;
    double[] Matrix1stData;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overall_matrix2);
        addListenerOnButton();

        Bundle bundling = getIntent().getExtras();
        if (bundling != null) {
            SecondFinalMatrix = bundling.getDoubleArray("2ndMatrixDat");
            SecondInts = bundling.getIntArray("2ndRowsAndCols");
            Matrix1stData = bundling.getDoubleArray("1stMatrixDat");
            Matrix1stDimensions = bundling.getIntArray("1stRowsAndCols");
        }

        TextView textView = (TextView) findViewById(R.id.textView10);
        textView.setText("Here is your " + SecondInts[0] + " by " + SecondInts[1] + " array: ");

        String[] holdString = new String[SecondFinalMatrix.length];
        for(int x = 0; x < SecondFinalMatrix.length; x++) {
            holdString[x] = Double.toString(SecondFinalMatrix[x]);
        }
        ArrayAdapter<String> ad = new ArrayAdapter<String>(OverallMatrix2.this, android.R.layout.simple_list_item_1, holdString);
        GridView gridView = (GridView)findViewById(R.id.grid2);
        gridView.setNumColumns(SecondInts[1]);

        gridView.setAdapter(ad);
    }

    public void addListenerOnButton () {
        final Context context = this;

        button = (Button) findViewById(R.id.button8);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityChoice.class);
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
                Bundle b1 = new Bundle();
                Bundle b2 = new Bundle();
                Bundle b3 = new Bundle();
                Bundle b4 = new Bundle();
                b1.putIntArray("1stRAndC", Matrix1stDimensions);
                b2.putDoubleArray("1stD",Matrix1stData);
                b3.putIntArray("2ndRAndC",SecondInts);
                b4.putDoubleArray("2ndD",SecondFinalMatrix);

                intent.putExtras(b1);
                intent.putExtras(b2);
                intent.putExtras(b3);
                intent.putExtras(b4);
                if (intent.getExtras() == null){
                    startActivity(intent);
                } else {
                    startActivity(intent);
                }
            }
        });
    }
}
