package io.github.pengdst.simplemvvm;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MutableLiveData<String> etPanjang = new MutableLiveData<>();
    public MutableLiveData<String> etLebar = new MutableLiveData<>();

    public MutableLiveData<String> keliling = new MutableLiveData<>();
    public MutableLiveData<String> luas = new MutableLiveData<>();

    public void hitungLuasPersegi(Context context){
        if ((etPanjang == null || etPanjang.getValue() == null) || (etLebar == null || etLebar.getValue() == null)){
            Toast.makeText(context, "Semua Field Harus Terisi", Toast.LENGTH_LONG).show();
            return;
        }
        Double panjang = Double.parseDouble(etPanjang.getValue());
        Double lebar = Double.parseDouble(etLebar.getValue());

        hitungLuasPersegi(panjang, lebar);
    }

    public void hitungKelilingPersegi(Context context){

        if ((etPanjang == null || etPanjang.getValue() == null) || (etLebar == null || etLebar.getValue() == null)){
            Toast.makeText(context, "Semua Field Harus Terisi", Toast.LENGTH_LONG).show();
            return;
        }

        Double panjang = Double.valueOf(etPanjang.getValue());
        Double lebar = Double.valueOf(etLebar.getValue());

        hitungKelilingPersegi(panjang, lebar);
    }

    public void hitungLuasPersegi(Double panjang, Double lebar){
        double hasil = panjang * lebar;
        luas.postValue(Double.toString(hasil));
    }

    public void hitungKelilingPersegi(Double panjang, Double lebar){
        double hasil = 2 * (panjang * lebar);
        keliling.postValue(Double.toString(hasil));
    }

}