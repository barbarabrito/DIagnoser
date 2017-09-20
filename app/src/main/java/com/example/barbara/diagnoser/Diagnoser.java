package com.example.barbara.diagnoser;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;




public class Diagnoser extends AppCompatActivity {

    private TextView textViewGb;
    private EditText editTextGb;
    private TextView textViewGba1;
    private EditText editTextGba1;
    private TextView textViewGba2;
    private EditText editTextGba2;
    private TextView textViewGba3;
    private EditText editTextGba3;
    private Button button;

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diagnoser);


        textViewGb = (TextView)findViewById(R.id.textViewGb);
        editTextGb = (EditText)findViewById(R.id.editTextGb);
        textViewGba1 = (TextView)findViewById(R.id.textViewGba1);
        editTextGba1 = (EditText)findViewById(R.id.editTextGba1);
        textViewGba2 = (TextView)findViewById(R.id.textViewGba2);
        editTextGba2 = (EditText)findViewById(R.id.editTextGba2);
        textViewGba3 =(TextView)findViewById(R.id.textViewGba3);
        editTextGba3 = (EditText)findViewById(R.id.editTextGba3);
        button = (Button)findViewById(R.id.button);



        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if ( (editTextGb.getText().toString().isEmpty()) ||
                        (editTextGba1.getText().toString().isEmpty()) ||
                        (editTextGba2.getText().toString().isEmpty()) ||
                        (editTextGba3.getText().toString().isEmpty())) {
                    showMsg();

                }else {
                    CalcInt();

                }

            }
        });

    }


    public void showMsg(){
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("Aviso");
        dlg.setIcon(R.mipmap.ic_aviso);
        dlg.setMessage("Há campos vazios");
        dlg.setNeutralButton("Ok", null);
        dlg.show();
    }


    public void CalcInt(){


        int gb,gba1,gba2,gba3,r;

        gb = Integer.valueOf(editTextGb.getText().toString());
        gba1 = Integer.valueOf(editTextGba1.getText().toString());
        gba2 = Integer.valueOf(editTextGba2.getText().toString());
        gba3 = Integer.valueOf(editTextGba3.getText().toString());


        r = gb + 20;


        if ((gba1 >= r) || (gba2 >= r) || (gba3 >= r)){
            AlertDialog.Builder result = new AlertDialog.Builder(Diagnoser.this);
            result.setTitle("Resultado");
            result.setIcon(R.mipmap.ic_announ);
            result.setMessage("Resultado negativo");
            result.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            AlertDialog alertDialog = result.create();
            alertDialog.show();

        }else {
            AlertDialog.Builder result = new AlertDialog.Builder(Diagnoser.this);
            result.setTitle("Resultado");
            result.setIcon(R.mipmap.ic_announ);
            result.setMessage("Resultado positivo");
            result.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            AlertDialog alertDialog = result.create();
            alertDialog.show();


        }

        editTextGb.setText("");
        editTextGba1.setText("");
        editTextGba2.setText("");
        editTextGba3.setText("");


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent i = null;


        if (item.getItemId() == R.id.hlp) {

            i = new Intent(this, Help.class);

        } else if (item.getItemId() == R.id.abt) {

            i = new Intent(this, About.class);

        }


        int id = item.getItemId();

        startActivity(i);


        return super.onOptionsItemSelected(item);


    }



}








