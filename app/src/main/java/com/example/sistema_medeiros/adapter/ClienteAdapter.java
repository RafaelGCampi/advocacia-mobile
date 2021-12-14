package com.example.sistema_medeiros.adapter;


import com.example.sistema_medeiros.MainActivity;
import com.example.sistema_medeiros.R;
import com.example.sistema_medeiros.model.Cliente;

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

public class ClienteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Cliente> clientes;
    Context context;

    public ClienteAdapter(ArrayList<Cliente> clientes,Context context) {
        this.clientes = clientes;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_clientes,parent,false);
        ClienteViewHolder viewHolder = new ClienteViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Cliente cliente = clientes.get(position);
//
//        ClienteViewHolder clienteViewHolder = (ClienteViewHolder) holder;
//
//        TextView nameTextView = clienteViewHolder.itemView.findViewById(R.id.textCliente);
        ((ClienteViewHolder) holder).nomeCliente.setText(cliente.toString());

        ((ClienteViewHolder) holder).relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirPopupCliente();
            }
        });
    }


    @Override
    public int getItemCount() {
        return clientes.size();
    }
    class ClienteViewHolder extends RecyclerView.ViewHolder{
        private TextView nomeCliente;
//        private Button criarCliente;
        public ConstraintLayout relativeLayout;
        public ClienteViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeCliente = itemView.findViewById(R.id.textCliente);
            relativeLayout= itemView.findViewById(R.id.constraintListCliente);
//            criarCliente = itemView.findViewById(R.id.criarCliente);
//            itemView.setOnClickListener((View.OnClickListener) this);

        }
    }
    public void abrirPopupCliente() {
    }

}