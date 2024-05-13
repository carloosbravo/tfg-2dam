package com.example.cooper_up.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cooper_up.R;
import com.example.cooper_up.models.PracticaModel;

import java.util.ArrayList;

public class RVpracticas extends RecyclerView.Adapter<RVpracticas.MyViewHolder> {

    Context context;
    ArrayList<PracticaModel> practicas;

    public RVpracticas(Context context, ArrayList<PracticaModel> practicas) {
        this.context = context;
        this.practicas = practicas;
    }

    @NonNull
    @Override
    public RVpracticas.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_practicas,parent,false);
        return new RVpracticas.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVpracticas.MyViewHolder holder, int position) {

        PracticaModel practica = practicas.get(position);
        holder.nombrePractica.setText(practica.getNombre_practica());
        holder.descripcionPractica.setText(practica.getDescripcion());

        //aqui iria el cambio de intent para cuando pulse en la practica
    }

    @Override
    public int getItemCount() {

        return practicas.size();
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder{

        TextView nombrePractica;
        TextView descripcionPractica;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.nombrePractica = itemView.findViewById(R.id.nombrePracticasTV);
            this.descripcionPractica = itemView.findViewById(R.id.descripcionPracticaTV);
        }
    }
}
