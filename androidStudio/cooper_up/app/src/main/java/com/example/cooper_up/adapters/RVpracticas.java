package com.example.cooper_up.adapters;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cooper_up.models.EmpresaModelo;
import com.example.cooper_up.pulsables.PracticaPulsar;
import com.example.cooper_up.R;
import com.example.cooper_up.models.PracticaModel;
import com.example.cooper_up.retrofit.ApiAdapter;
import com.example.cooper_up.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        holder.tituloPractica.setText(practica.getTitulo_practica());
        holder.descripcionPractica.setText(practica.getDescripcion());

        ApiAdapter apiAdapter = ApiAdapter.getInstance();
        ApiService apiService = apiAdapter.getApiService();
        Call<EmpresaModelo> call = apiService.getEmpresaId(practica.getId_empresa());

        call.enqueue(new Callback<EmpresaModelo>() {
            @Override
            public void onResponse(Call<EmpresaModelo> call, Response<EmpresaModelo> response) {
                EmpresaModelo empresa = response.body();

                holder.nombreEmpresa.setText(empresa.getNombre());
            }

            @Override
            public void onFailure(Call<EmpresaModelo> call, Throwable t) {

            }
        });
        //aqui iria el cambio de intent para cuando pulse en la practica

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PracticaPulsar.class);
                intent.putExtra("practica", practica);
                context.startActivity(intent);
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

        TextView nombreEmpresa;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tituloPractica = itemView.findViewById(R.id.nombrePracticasTV);
            this.descripcionPractica = itemView.findViewById(R.id.descripcionPracticaTV);
            this.nombreEmpresa = itemView.findViewById(R.id.nombreEmpresaCardView);

        }
    }
}
