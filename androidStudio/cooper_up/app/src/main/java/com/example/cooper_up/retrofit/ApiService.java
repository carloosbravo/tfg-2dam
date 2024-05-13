package com.example.cooper_up.retrofit;

import com.example.cooper_up.models.AlumnoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("usuarionormal/allAlumnos")
    Call <List<AlumnoModel>> getAllAlumnos();

    @GET("usuarionormal/alumnosById/{id}")
    Call <AlumnoModel> getAlumnos(@Path("id") Integer id);

    @GET("usuarionormal/logIn/{correo}")
    Call <AlumnoModel> logIn(@Path("correo") String correo);

}
