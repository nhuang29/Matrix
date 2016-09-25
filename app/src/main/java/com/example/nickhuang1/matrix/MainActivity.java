package com.example.nickhuang1.matrix;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton () {
        final Context context = this;

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MatrixEntry1.class);
                Bundle bundle = new Bundle();
                EditText editRow = (EditText) findViewById(R.id.editText);
                EditText editColumn = (EditText) findViewById(R.id.editText2);

                String RowNum = editRow.getText().toString();
                String RowCol = editColumn.getText().toString();

                int RowNumber = Integer.parseInt(RowNum);
                int RowColumn = Integer.parseInt(RowCol);
                int[] ints = new int[2];
                ints[0] = RowNumber;
                ints[1] = RowColumn;

                bundle.putIntArray("Data", ints);
                intent.putExtras(bundle);

                if (intent.getExtras() == null) {
                    startActivity(intent);
                } else {
                    startActivity(intent);
                }

            }
        });
    }
}
