package com.example.sistema_medeiros.ui.cliente;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sistema_medeiros.ConnectionAsyncTask;
import com.example.sistema_medeiros.MainActivity;
import com.example.sistema_medeiros.R;
import com.example.sistema_medeiros.adapter.ClienteAdapter;
import com.example.sistema_medeiros.model.Cliente;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ClienteFragment extends Fragment implements ConnectionAsyncTask.ConnectionListener  {


    private ClienteViewModel clienteViewModel;
    private ClienteAdapter clienteAdapter;
    private RecyclerView recicleView;
    private RecyclerView.LayoutManager clienteManager;
    private View clienteItemsView;
    private AlertDialog.Builder dialogCliente;
    private AlertDialog dialog;
    ArrayList<Cliente>clientes = new ArrayList<Cliente>();
    public ClienteFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        clienteViewModel =
//                ViewModelProviders.of(this).get(ClienteViewModel.class);
//        View root = inflater.inflate(R.layout.cliente_fragment, container, false);
        Button buttonCriarCliente ;

        clienteItemsView = inflater.inflate(R.layout.cliente_fragment, container,false);
//        recicleView.setHasFixedSize(true);
        recicleView = clienteItemsView.findViewById(R.id.clienteRecycle);
        buttonCriarCliente = (Button)clienteItemsView.findViewById(R.id.criarCliente);
        buttonCriarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarCliente();
            }
        });
        clienteManager = new LinearLayoutManager(getActivity());
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNome("Jose");
        cliente.setCpf("214.445.687-89");
        cliente.setCpf("123.456.789-89");
        clientes.add(cliente);
        ;

        clienteAdapter = new ClienteAdapter(clientes,getContext());

        recicleView.setAdapter(clienteAdapter);
        recicleView.setLayoutManager(clienteManager);
        ConnectionAsyncTask connectionAsyncTask = new ConnectionAsyncTask(this);
        connectionAsyncTask.execute("http://localhost:8000/api/cliente/listar");
//        return super.onCreateView(inflater,container,savedInstanceState);
//        final TextView textView = root.findViewById(R.id.text);
//        clienteViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return clienteItemsView ;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    public void criarCliente(){
        CriarClienteFragment criarClienteFragment = new CriarClienteFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, criarClienteFragment ); // give your fragment container id in first parameter
        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();
    }

    @Override
    public void onConnectResult(JSONObject object) {
        try {

            JSONArray clientesArray = object.getJSONArray("cliente");

            for(int position = 0 ; position < clientesArray.length(); position++){

                JSONObject clienteObject = clientesArray.getJSONObject(position);

                int id = clienteObject.getInt("id_cliente");
                String nome = clienteObject.getString("nome");
                String cpf = clienteObject.getString("cpf");

                Cliente cliente = new Cliente();
                cliente.setId(id);
                cliente.setNome(nome);
                cliente.setCpf(cpf);
                clientes.add(cliente);
            }

            clienteAdapter.notifyDataSetChanged();

        }catch (Exception e){

        }
    }
}