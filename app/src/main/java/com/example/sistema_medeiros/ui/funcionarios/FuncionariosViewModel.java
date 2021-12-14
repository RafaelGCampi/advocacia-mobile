package com.example.sistema_medeiros.ui.funcionarios;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FuncionariosViewModel extends ViewModel {
    private MutableLiveData<String> mText;
    public FuncionariosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Funcionarios");
    }

    public LiveData<String> getText() {
        return mText;
    }
}