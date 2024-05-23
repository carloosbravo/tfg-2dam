package com.example.cooper_up.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cooper_up.pulsables.AlumnoPulsar;
import com.example.cooper_up.R;
import com.example.cooper_up.models.AlumnoModel;

import java.util.ArrayList;
import java.util.List;

public class RValumnos extends RecyclerView.Adapter<RValumnos.MyViewHolder>{

    Context context;
    ArrayList<AlumnoModel> alumnos;

    public RValumnos(Context context,ArrayList<AlumnoModel> alumnos){
        this.context = context;
        this.alumnos = alumnos;
    }

    @NonNull
    @Override
    public RValumnos.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_alumno,parent,false);
        return new RValumnos.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AlumnoModel alumno = alumnos.get(position);
        holder.nombreAlumno.setText(alumno.getNombre());
        holder.correoAlumno.setText(alumno.getEmail());
        holder.gradoAlumno.setText(alumno.getGrado());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AlumnoPulsar.class);
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
