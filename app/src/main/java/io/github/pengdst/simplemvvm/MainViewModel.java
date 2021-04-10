package io.github.pengdst.simplemvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Double> luas = new MutableLiveData<>();
    private MutableLiveData<Double> keliling = new MutableLiveData<>();

    public void hitungLuas(Double panjang, Double lebar){
        Double hasil = panjang * lebar;
        luas.postValue(hasil);
    }

    public void hitungKeliling(Double panjang, Double lebar){
        Double hasil = 2 * (panjang * lebar);
        keliling.postValue(hasil);
    }

    public LiveData<Double> observeLuas(){
        return luas;
    }

    public LiveData<Double> observeKeliling(){
        return keliling;
    }

}