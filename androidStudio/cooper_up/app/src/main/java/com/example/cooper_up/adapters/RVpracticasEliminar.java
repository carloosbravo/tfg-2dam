package com.example.cooper_up.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cooper_up.EliminarPractica;
import com.example.cooper_up.R;
import com.example.cooper_up.logins.LoginAlumno;
import com.example.cooper_up.mains.MainActivityEmpresa;
import com.example.cooper_up.models.EmpresaModelo;
import com.example.cooper_up.models.PracticaModel;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RVpracticasEliminar extends RecyclerView.Adapter<RVpracticasEliminar.MyViewHolder>{
    Context context;
    ArrayList<PracticaModel> practicas;
    EmpresaModelo empresa;

    public RVpracticasEliminar(Context context, ArrayList<PracticaModel> practicas, EmpresaModelo empresa) {
        this.context = context;
        this.practicas = practicas;
        this.empresa = empresa;
    }

    @NonNull
    @Override
    public RVpracticasEliminar.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_practicas,parent,false);
        return new RVpracticasEliminar.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVpracticasEliminar.MyViewHolder holder, int position) {

        PracticaModel practica = practicas.get(position);
        holder.tituloPractica.setText(practica.getTitulo_practica());
        holder.descripcionPractica.setText(practica.getDescripcion());

        //aqui iria el cambio de intent para cuando pulse en la practica

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ApiAdapter apiAdapter = ApiAdapter.getInstance();
                ApiService apiService = apiAdapter.getApiService();

                Call<Void> call = apiService.deletePractica(practica.getId());

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(context, "practica eliminada", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, MainActivityEmpresa.class);
                        intent.putExtra("practica", practica);
                        intent.putExtra("empresa", empresa);
                        context.startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                        Toast.makeText(context, "error al crear las practicas", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

    }
    public void setFilteredList(ArrayList<PracticaModel> filteredList){
        this.practicas = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        return practicas.size();
    }

    public void actualizarLista(List<PracticaModel> nuevaLista){
        practicas.clear();
        practicas.addAll(nuevaLista);
        notifyDataSetChanged();
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder{

        TextView tituloPractica;
        TextView descripcionPractica;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tituloPractica = itemView.findViewById(R.id.nombrePracticasTV);
            this.descripcionPractica = itemView.findViewById(R.id.descripcionPracticaTV);
        }
    }
}
