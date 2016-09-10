package id.sch.smktelkom_mlg.tugas01.xirpl1024.formpendaftaranssbdiamondwing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    TextView tvhasil, tvposisi;
    int nPosisi;
    EditText etnama;
    EditText etumur;
    EditText etasal;
    CheckBox cbkiper, cbbek, cbgelandang, cbpenyerang;
    RadioButton rbkanan, rbkiri;
    RadioGroup rgkaki;
    Spinner spkeahlian;
    Button btnproses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvhasil = (TextView) findViewById(R.id.textView2);
        tvposisi = (TextView) findViewById(R.id.textViewPosisi);
        etnama = (EditText) findViewById(R.id.editTextNama);
        etumur = (EditText) findViewById(R.id.editTextUmur);
        etasal = (EditText) findViewById(R.id.editTextAsal);
        cbkiper = (CheckBox) findViewById(R.id.checkBoxKiper);
        cbbek = (CheckBox) findViewById(R.id.checkBoxBek);
        cbgelandang = (CheckBox) findViewById(R.id.checkBoxGelandang);
        cbpenyerang = (CheckBox) findViewById(R.id.checkBoxPenyerang);
        rgkaki = (RadioGroup) findViewById(R.id.radioGroupkaki);
        rbkanan = (RadioButton) findViewById(R.id.radioButtonKanan);
        rbkiri = (RadioButton) findViewById(R.id.radioButtonKiri);
        spkeahlian = (Spinner) findViewById(R.id.spinnerKeahlian);
        btnproses = (Button) findViewById(R.id.buttonDAFTAR);

        cbkiper.setOnCheckedChangeListener(this);
        cbbek.setOnCheckedChangeListener(this);
        cbgelandang.setOnCheckedChangeListener(this);
        cbpenyerang.setOnCheckedChangeListener(this);

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProccess();
            }
        });
    }

    private void doProccess() {
        if (isValid()) {
            String nama = etnama.getText().toString();
            String umur = etumur.getText().toString();
            String asal = etasal.getText().toString();
            String hasil = "\n Posisi                      : ";
            if (cbkiper.isChecked()) hasil += cbkiper.getText() + " ";
            if (cbbek.isChecked()) hasil += cbbek.getText() + " ";
            if (cbgelandang.isChecked()) hasil += cbgelandang.getText() + " ";
            if (cbpenyerang.isChecked()) hasil += cbpenyerang.getText() + " ";
            String hasilrg = null;
            String keahlian = spkeahlian.getSelectedItem().toString();

            if (rbkiri.isChecked()) {
                hasilrg = rbkiri.getText().toString();
            } else if (rbkanan.isChecked()) {
                hasilrg = rbkanan.getText().toString();
            } else {
                hasilrg = "belum memilih kaki utama";
            }

            tvhasil.setText(
                    " Nama                       : " + nama + " " +
                            "\n Umur                       : " + umur + " " +
                            "\n Asal                         : " + asal + hasil + " " +
                            "\n Kaki Utama            : " + hasilrg + " " +
                            "\n Keahlian Khusus  : " + keahlian + " ");
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etnama.getText().toString();
        String umur = etumur.getText().toString();
        String asal = etasal.getText().toString();

        if (nama.isEmpty()) {
            etnama.setError("Nama Belum diisikan");
            valid = false;
        } else if (nama.length() < 3) {
            etnama.setError("Nama minimal berisikan 3 karakter");
            valid = false;
        } else {
            etnama.setError(null);
        }

        if (umur.isEmpty()) {
            etumur.setError("Umur belum diisikan");
            valid = false;
        } else {
            etumur.setError(null);
        }

        if (asal.isEmpty()) {
            etasal.setError("Asal Belum diisikan");
            valid = false;
        } else if (asal.length() < 3) {
            etasal.setError("Asal kota minimal berisikan 3 karakter");
            valid = false;
        } else {
            etasal.setError(null);
        }

        return valid;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) nPosisi += 1;
        else nPosisi -= 1;

        tvposisi.setText("Posisi (" + nPosisi + " terpilih)");
    }
}
