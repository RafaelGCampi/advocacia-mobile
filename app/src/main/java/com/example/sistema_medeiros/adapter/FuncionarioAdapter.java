package com.example.sistema_medeiros.adapter;


import com.example.sistema_medeiros.MainActivity;
import com.example.sistema_medeiros.R;
import com.example.sistema_medeiros.model.Funcionario;
import com.example.sistema_medeiros.model.Funcionario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class FuncionarioAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Funcionario> funcionarios;
    Context context;

    public FuncionarioAdapter(ArrayList<Funcionario> funcionarios, Context context) {
        this.funcionarios = funcionarios;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_funcionarios, parent, false);
        FuncionarioViewHolder viewHolder = new FuncionarioViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Funcionario funcionario = funcionarios.get(position);
//
//        FuncionarioViewHolder funcionarioViewHolder = (FuncionarioViewHolder) holder;
//
//        TextView nameTextView = funcionarioViewHolder.itemView.findViewById(R.id.textFuncionario);
        ((FuncionarioViewHolder) holder).nomeFuncionario.setText(funcionario.toString());

        ((FuncionarioViewHolder) holder).relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirPopupFuncionario();
            }
        });
    }


    @Override
    public int getItemCount() {
        return funcionarios.size();
    }

    class FuncionarioViewHolder extends RecyclerView.ViewHolder {
        private TextView nomeFuncionario;
        //        private Button criarFuncionario;
        public ConstraintLayout relativeLayout;

        public FuncionarioViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeFuncionario = itemView.findViewById(R.id.textFuncionario);
            relativeLayout = itemView.findViewById(R.id.constraintListFuncionario);
//            criarFuncionario = itemView.findViewById(R.id.criarFuncionario);
//            itemView.setOnClickListener((View.OnClickListener) this);

        }
    }

    public void abrirPopupFuncionario() {
    }

}
