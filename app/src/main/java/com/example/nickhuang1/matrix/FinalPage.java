package com.example.nickhuang1.matrix;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

public class FinalPage extends AppCompatActivity {
    double[] NewResults;
    int[] RandC;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);
        addListenerOnButton3();
        addListenerOnButton4();

        Bundle b = getIntent().getExtras();
        if (b != null) {
            NewResults = b.getDoubleArray("Result");
            RandC = b.getIntArray("CandR");
        }

        String[] holdString = new String[NewResults.length];
        for(int x = 0; x < holdString.length; x++) {
            holdString[x] = Double.toString(NewResults[x]);
        }
        ArrayAdapter<String> ad = new ArrayAdapter<String>(FinalPage.this, android.R.layout.simple_list_item_1, holdString);
        GridView gridView = (GridView)findViewById(R.id.grid3);
        gridView.setNumColumns(RandC[1]);

        gridView.setAdapter(ad);
    }

    public void addListenerOnButton3 () {
        final Context context = this;

        button = (Button) findViewById(R.id.button14);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addListenerOnButton4 () {
        final Context context = this;

        button = (Button) findViewById(R.id.button15);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Tutorial.class);
                startActivity(intent);
            }
        });
    }

}
