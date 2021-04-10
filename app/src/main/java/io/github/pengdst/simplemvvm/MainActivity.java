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

import io.github.pengdst.simplemvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private EditText edtAlas,edtTinggi,edtPanjang,edtLebar;
    private Button btnHitungLuas,btnHitungKeliling;
    private TextView tvHasilLuas,tvHasilKeliling;
    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        edtAlas = binding.edtAlas;
        edtTinggi = binding.edtTinggi;
        edtPanjang = binding.edtPanjang;
        edtLebar= binding.edtLebar;

        tvHasilLuas = binding.tvHasilLuas;
        tvHasilKeliling = binding.tvHasilKeliling;

        btnHitungKeliling = binding.btnHitungKeliling;
        btnHitungLuas = binding.btnHitungLuas;

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