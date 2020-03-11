package com.example.balaiodelenharestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    //Criar os objetos
    private EditText edtConsumo, edtCouvert, edtDividir;
    private TextView edtTaxa, edtTotal, edtPessoa;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //Relacionar XML com JAVA

        edtConsumo = (EditText) findViewById(R.id.edtConsumo);
        edtCouvert = (EditText) findViewById(R.id.edtCouvert);
        edtDividir = (EditText) findViewById(R.id.edtDividir);
        edtTaxa = (TextView) findViewById(R.id.edtTaxa);
        edtTotal = (TextView) findViewById(R.id.edtTotal);
        edtPessoa = (TextView) findViewById(R.id.edtPessoa);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double consumo = Double.parseDouble(edtConsumo.getText().toString());
                double couvert = Double.parseDouble(edtCouvert.getText().toString());
                int dividir = Integer.parseInt(edtDividir.getText().toString());
                double taxa = consumo * 0.10;
                double total = consumo + couvert + taxa;
                double pessoa = total / dividir;

                DecimalFormat df = new DecimalFormat("0.00");

                edtTaxa.setText(String.valueOf(df.format(taxa)));
                edtTotal.setText(String.valueOf(df.format(total)));
                edtPessoa.setText(String.valueOf(df.format(pessoa)));
            }
        });


    }
}
