package com.example.egz012024;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNumer, etImie, etNazwisko;
    private RadioGroup rgKolorOczu;
    private ImageView ivZdjecie, ivOdcisk;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumer = findViewById(R.id.etNumer);
        etImie = findViewById(R.id.etImie);
        etNazwisko = findViewById(R.id.etNazwisko);
        rgKolorOczu = findViewById(R.id.rgKolorOczu);
        ivZdjecie = findViewById(R.id.ivZdjecie);
        ivOdcisk = findViewById(R.id.ivOdcisk);
        btnOk = findViewById(R.id.btnOk);

        etNumer.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    aktualizujObrazy(etNumer.getText().toString().trim());
                }
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imie = etImie.getText().toString().trim();
                String nazwisko = etNazwisko.getText().toString().trim();

                if (imie.isEmpty() || nazwisko.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Wprowadź dane", Toast.LENGTH_SHORT).show();
                } else {
                    int selectedId = rgKolorOczu.getCheckedRadioButtonId();
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String kolorOczu = selectedRadioButton != null ? selectedRadioButton.getText().toString() : "niebieskie";

                    String komunikat = imie + " " + nazwisko + " kolor oczu " + kolorOczu;
                    Toast.makeText(MainActivity.this, komunikat, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void aktualizujObrazy(String numer) {
        int idZdjecie = getResources().getIdentifier(numer + "_zdjecie", "drawable", getPackageName());
        int idOdcisk = getResources().getIdentifier(numer + "_odcisk", "drawable", getPackageName());

        if (idZdjecie != 0) {
            ivZdjecie.setImageResource(idZdjecie);
        } else {
            ivZdjecie.setImageDrawable(null);
        }

        if (idOdcisk != 0) {
            ivOdcisk.setImageResource(idOdcisk);
        } else {
            ivOdcisk.setImageDrawable(null);
        }
    }
}