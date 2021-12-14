package com.example.sistema_medeiros.ui.cliente;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.sistema_medeiros.R;


public class CriarClienteFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root =inflater.inflate(R.layout.criar_cliente, container, false);
        Button buttonCriarCliente = (Button)root.findViewById(R.id.buttonCriarFunc);
        buttonCriarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context contexto = getContext();
                int duracao = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(contexto, "Cliente Criado",duracao);
                toast.show();
            }
        });
       Button  buttonListaCliente = (Button)root.findViewById(R.id.buttonCancelarFunc);
        buttonListaCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaCliente();
            }
        });
        return root;
    }
    public void listaCliente(){
        ClienteFragment clienteFragment = new ClienteFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, clienteFragment ); // give your fragment container id in first parameter
        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();
    }
}