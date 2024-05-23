package com.example.cooper_up.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cooper_up.pulsables.AlumnosPracticaPulsar;
import com.example.cooper_up.R;
import com.example.cooper_up.models.EmpresaModelo;
import com.example.cooper_up.models.PracticaModel;

import java.util.ArrayList;
import java.util.List;

public class RVpracticasEmpresa extends RecyclerView.Adapter<RVpracticasEmpresa.MyViewHolder> {
    Context context;
    ArrayList<PracticaModel> practicas;
    EmpresaModelo empresa;

    public RVpracticasEmpresa(Context context, ArrayList<PracticaModel> practicas,EmpresaModelo empresa) {
        this.context = context;
        this.practicas = practicas;
        this.empresa = empresa;
    }

    @NonNull
    @Override
    public RVpracticasEmpresa.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_practicas, parent, false);
        return new RVpracticasEmpresa.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVpracticasEmpresa.MyViewHolder holder, int position) {
        PracticaModel practica = practicas.get(position);
        holder.tituloPractica.setText(practica.getTitulo_practica());
        holder.descripcionPractica.setText(practica.getDescripcion());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AlumnosPracticaPulsar.class);
                intent.putExtra("practica", practica);
                intent.putExtra("empresa", empresa);
                context.startActivity(intent);
            }
        });
    }

    public void setFilteredList(ArrayList<PracticaModel> filteredList) {
        this.practicas = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return practicas.size();
    }

    public void actualizarLista(List<PracticaModel> nuevaLista) {
        practicas.clear();
        practicas.addAll(nuevaLista);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tituloPractica;
        TextView descripcionPractica;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tituloPractica = itemView.findViewById(R.id.nombrePracticasTV);
            this.descripcionPractica = itemView.findViewById(R.id.descripcionPracticaTV);
        }
    }
}
