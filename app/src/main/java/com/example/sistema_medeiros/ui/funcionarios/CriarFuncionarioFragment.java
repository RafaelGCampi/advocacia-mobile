package com.example.sistema_medeiros.ui.funcionarios;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.sistema_medeiros.R;


public class CriarFuncionarioFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =inflater.inflate(R.layout.fragment_criar_funcionario, container, false);
        Button buttonAtualizarDados = (Button)root.findViewById(R.id.buttonCriarFunc);
        buttonAtualizarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context contexto = getContext();
                int duracao = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(contexto, "Funcionario Criado !",duracao);
                toast.show();
            }
        });
        return root;
    }
}