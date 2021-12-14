package com.example.sistema_medeiros.ui.gallery;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.sistema_medeiros.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
//        final TextView textView = root.findViewById(R.id.text_gallery);
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
////                textView.setText(s);
//            }
//        });
        Button buttonAtualizarDados = (Button)root.findViewById(R.id.buttonAtualizarDados);
        buttonAtualizarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context contexto = getContext();
                int duracao = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(contexto, "Dados Atualizados !",duracao);
                toast.show();
            }
        });
        Button buttonAtualizarSenha = (Button)root.findViewById(R.id.buttonCancelarFunc);
        buttonAtualizarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context contexto = getContext();
                int duracao = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(contexto, "Senha Atualizada !",duracao);
                toast.show();
            }
        });
        return root;
    }
}