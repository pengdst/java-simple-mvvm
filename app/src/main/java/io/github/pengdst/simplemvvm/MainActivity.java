package io.github.pengdst.simplemvvm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtAlas,edtTinggi,edtPanjang,edtLebar;
    private Button btnHitungLuas,btnHitungKeliling;
    private TextView tvHasilLuas,tvHasilKeliling;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtAlas = findViewById(R.id.edt_alas);
        edtTinggi = findViewById(R.id.edt_tinggi);
        edtPanjang = findViewById(R.id.edt_panjang);
        edtLebar= findViewById(R.id.edt_lebar);

        tvHasilLuas = findViewById(R.id.tv_hasil_luas);
        tvHasilKeliling = findViewById(R.id.tv_hasil_keliling);

        btnHitungKeliling = findViewById(R.id.btn_hitung_keliling);
        btnHitungLuas = findViewById(R.id.btn_hitung_luas);

        initViewModel();
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnHitungLuas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtAlas.getText() != null && edtTinggi.getText() != null){
                    Double alas = Double.valueOf(edtAlas.getText().toString());
                    Double tinggi = Double.valueOf(edtTinggi.getText().toString());

                    viewModel.hitungLuas(alas,tinggi);
                }
            }
        });

        btnHitungKeliling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtPanjang.getText() != null && edtLebar.getText() != null){
                    Double panjang = Double.valueOf(edtPanjang.getText().toString());
                    Double lebar = Double.valueOf(edtLebar.getText().toString());

                    viewModel.hitungKeliling(panjang,lebar);
                }
            }
        });

        viewModel.observeLuas().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double luas) {
                tvHasilLuas.setText(luas.toString());
            }
        });

        viewModel.observeKeliling().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double keliling) {
                tvHasilKeliling.setText(keliling.toString());
            }
        });
    }

    private void initViewModel() {
        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        viewModel = new ViewModelProvider(this, factory).get(MainViewModel.class);
    }
}