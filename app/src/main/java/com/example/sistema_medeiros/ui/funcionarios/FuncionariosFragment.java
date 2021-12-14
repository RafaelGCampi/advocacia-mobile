package com.example.sistema_medeiros.ui.funcionarios;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.sistema_medeiros.ConnectionAsyncTask;
import com.example.sistema_medeiros.R;
import com.example.sistema_medeiros.adapter.FuncionarioAdapter;
import com.example.sistema_medeiros.model.Funcionario;
import com.example.sistema_medeiros.ui.funcionarios.FuncionariosViewModel;
import com.example.sistema_medeiros.ui.funcionarios.CriarFuncionarioFragment;
import com.example.sistema_medeiros.ui.funcionarios.FuncionariosViewModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class FuncionariosFragment extends Fragment implements ConnectionAsyncTask.ConnectionListener  {

    private FuncionariosViewModel funcionarioViewModel;
    private FuncionarioAdapter funcionarioAdapter;
    private RecyclerView recicleView;
    private RecyclerView.LayoutManager funcionarioManager;
    private View funcionarioItemsView;
    private AlertDialog.Builder dialogFuncionario;
    private AlertDialog dialog;
    ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    public FuncionariosFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        funcionarioViewModel =
//                ViewModelProviders.of(this).get(FuncionarioViewModel.class);
//        View root = inflater.inflate(R.layout.funcionario_fragment, container, false);
        Button buttonCriarFuncionario ;

        funcionarioItemsView = inflater.inflate(R.layout.fragment_funcionario, container,false);
//        recicleView.setHasFixedSize(true);
        recicleView = funcionarioItemsView.findViewById(R.id.funcionarioRecycle);
        buttonCriarFuncionario = (Button)funcionarioItemsView.findViewById(R.id.criarFuncionario);
        buttonCriarFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarFuncionario();
            }
        });
        funcionarioManager = new LinearLayoutManager(getActivity());
        Funcionario funcionario = new Funcionario();
        funcionario.setId(1);
        funcionario.setNome("Jose");
        funcionario.setTipoAcesso("Administrador");
        funcionarios.add(funcionario);




        funcionarioAdapter = new FuncionarioAdapter(funcionarios,getContext());

        recicleView.setAdapter(funcionarioAdapter);
        recicleView.setLayoutManager(funcionarioManager);
        ConnectionAsyncTask connectionAsyncTask = new ConnectionAsyncTask(this);
        connectionAsyncTask.execute("http://localhost:8000/api/funcionario/listar");
//        return super.onCreateView(inflater,container,savedInstanceState);
//        final TextView textView = root.findViewById(R.id.text);
//        funcionarioViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return funcionarioItemsView ;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    public void criarFuncionario(){
        CriarFuncionarioFragment criarFuncionarioFragment = new CriarFuncionarioFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, criarFuncionarioFragment ); // give your fragment container id in first parameter
        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();
    }

    @Override
    public void onConnectResult(JSONObject object) {
        try {

            JSONArray funcionariosArray = object.getJSONArray("funcionario");

            for(int position = 0 ; position < funcionariosArray.length(); position++){

                JSONObject funcionarioObject = funcionariosArray.getJSONObject(position);

                int id = funcionarioObject.getInt("id_funcionario");
                String nome = funcionarioObject.getString("nome");
                String tipoAcesso = funcionarioObject.getString("tipo_acesso");

                Funcionario funcionario = new Funcionario();
                funcionario.setId(id);
                funcionario.setNome(nome);
                funcionario.setTipoAcesso(tipoAcesso);
                funcionarios.add(funcionario);
            }

            funcionarioAdapter.notifyDataSetChanged();

        }catch (Exception e){

        }
    }

}