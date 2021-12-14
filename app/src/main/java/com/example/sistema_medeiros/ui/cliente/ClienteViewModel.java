package com.example.sistema_medeiros.ui.cliente;

import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistema_medeiros.R;
import com.example.sistema_medeiros.model.Cliente;

import java.util.ArrayList;

public class ClienteViewModel extends ViewModel {
    private MutableLiveData<String> mText;
    private ArrayList<Cliente> clientes = new ArrayList<>();
    public ClienteViewModel() {
//        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(userAdapter);

    }

    public LiveData<String> getText() {
        return mText;
    }
}