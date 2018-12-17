package com.example.joonas.pulloja;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Automaatti extends AppCompatActivity {

    private Spinner spinner;

    TextView text;

    Bottle uusi = Bottle.getInstance();

    String lol;

    private TextView luku;

    private SeekBar liukuri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automaatti);


        text = findViewById(R.id.textView);

        spinner = findViewById(R.id.spinner);

        luku = findViewById(R.id.textView3);

        liukuri = findViewById(R.id.seekBar);


        List<Object> pullot = uusi.getlista();


        liukuri.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                luku.setText(""+progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });






        ArrayAdapter<String> dataAdapter;
        dataAdapter  = new ArrayAdapter(this, android.R.layout.simple_spinner_item, pullot);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                List<String> pullot1 = uusi.getlista();

                if (parent.getItemAtPosition(position).equals("Choose Cateory")){

                }
                else{

                    String item = parent.getItemAtPosition(position).toString();

                    for(int i = 1; i < pullot1.size(); i++) {
                        lol = pullot1.get(i).toString();
                        if (lol.trim().equals(item.trim())){
                            int mita = uusi.buyBottle(i-1);
                            if (mita == 0){
                                Toast.makeText(getBaseContext(),"Ei tarpeeksi rahaa", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(getBaseContext(),"KACHUCK! Koneesta tippui"+lol, Toast.LENGTH_SHORT).show();
                            }
                            text.setText("Koneessa on: "+ uusi.getMoney()+"€ rahaa");
                            parent.setSelection(0);

                        }
                    }


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }

    public void rahetta(View lol){
            String summa = luku.getText().toString();
            double rahe = Double.parseDouble(summa);
            uusi.addMoney(rahe);
            text.setText("Koneessa on: "+ uusi.getMoney()+"€ rahaa");
    }

    public void palautus(View lol){
        uusi.returnMoney();
        Toast.makeText(getBaseContext(),"Sinne menivät raheet :(", Toast.LENGTH_SHORT).show();

        text.setText("Koneessa on: "+ uusi.getMoney()+"€ rahaa");

    }
}
