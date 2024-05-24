package com.example.cooper_up.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cooper_up.R;
import com.example.cooper_up.models.AlumnoModel;
import com.example.cooper_up.models.CentroModelo;

import com.example.cooper_up.pulsables.AlumnoPulsarCentro;

import java.util.ArrayList;
import java.util.List;

public class RValumnosCentro extends RecyclerView.Adapter<RValumnosCentro.MyViewHolder>{

    Context context;
    ArrayList<AlumnoModel> alumnos;
    CentroModelo centro;

    public RValumnosCentro(Context context,ArrayList<AlumnoModel> alumnos,CentroModelo centro){
        this.context = context;
        this.alumnos = alumnos;
        this.centro = centro;
    }

    @NonNull
    @Override
    public RValumnosCentro.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_alumno,parent,false);
        return new RValumnosCentro.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RValumnosCentro.MyViewHolder holder, int position) {

        AlumnoModel alumno = alumnos.get(position);
        holder.nombreAlumno.setText(alumno.getNombre());
        holder.correoAlumno.setText(alumno.getEmail());
        holder.gradoAlumno.setText(alumno.getGrado());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AlumnoPulsarCentro.class);
                intent.putExtra("centro", centro);
                intent.putExtra("alumno", alumno);

                context.startActivity(intent);
            }
        });

    }

    public void setFilteredList(ArrayList<AlumnoModel> filteredList){
        this.alumnos = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }

    public void actualizarLista(List<AlumnoModel> nuevaLista){
        alumnos.clear();
        alumnos.addAll(nuevaLista);
        notifyDataSetChanged();
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder{

        TextView nombreAlumno;
        TextView gradoAlumno;
        TextView correoAlumno;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            this.nombreAlumno = itemView.findViewById(R.id.nameAlumnoCardTV);
            this.correoAlumno = itemView.findViewById(R.id.correoAlumnoCardTV);
            this.gradoAlumno = itemView.findViewById(R.id.gradoAlumnoCardTV);

        }
}
}
