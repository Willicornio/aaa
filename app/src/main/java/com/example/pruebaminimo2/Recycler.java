package com.example.pruebaminimo2;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.support.v7.widget.RecyclerView;

public class Recycler extends RecyclerView.Adapter<Recycler.ViewHolder> {


    private Context context;

    public Recycler(Context context) {
        this.lista = new ArrayList<>();
        this.context = context;
    }

    private List<Element> lista;

    public void rellenarLista(List<Element> todoselementos){
        lista.addAll(todoselementos);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.citiesitem, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Element element = lista.get(i);

        viewHolder.ineMunicipiView.setText(element.getIne());
        viewHolder.nomMunicipiView.setText(element.getMunicipiNom());

        Picasso.with(context).load(element.getMunicipiEscut()).into(viewHolder.escutMuncipi);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ConstraintLayout constraintLayout; //esto no se usa, pero el Vera sabrá más que tu, payaso
        private TextView nomMunicipiView;
        private TextView ineMunicipiView;
        private ImageView escutMuncipi;

        public ViewHolder(View v){
            super(v);
            constraintLayout = v.findViewById(R.id.constraintLayout); //Esto es el id del ConstraitLayout que hay que ponerlo donde "ConstariLayout" ID"
            nomMunicipiView = v.findViewById(R.id.nomMunicipi);
            ineMunicipiView = v.findViewById(R.id.numeroIne);
            escutMuncipi = v.findViewById(R.id.escutMunicipi);

        }


    }
}
