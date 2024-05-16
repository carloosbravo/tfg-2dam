package com.example.cooper_up.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cooper_up.R;
import com.example.cooper_up.models.AlumnoModel;

import java.util.ArrayList;

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

    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder{

        TextView nombreAlumno;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
        }
    }
}
