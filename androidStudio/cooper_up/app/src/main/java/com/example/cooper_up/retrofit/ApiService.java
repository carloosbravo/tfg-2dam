package com.example.cooper_up.retrofit;

import com.example.cooper_up.models.AlumnoModel;
import com.example.cooper_up.models.EmpresaModelo;
import com.example.cooper_up.models.PracticaModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @GET("usuarionormal/allAlumnos")
    Call <List<AlumnoModel>> getAllAlumnos();

    @GET("usuarionormal/alumnosById/{id}")
    Call <AlumnoModel> getAlumnos(@Path("id") Integer id);

    //login ALumno

    @GET("usuarionormal/logIn/{correo}")
    Call <AlumnoModel> logInAlumno(@Path("correo") String correo);


    @GET("practica/getAll")
    Call <List<PracticaModel>> getAllPracticas();


    //registrar un Alumno
    @POST("register-update")
    Call<AlumnoModel> register(@Body AlumnoModel alumno);



    //login empresa

    @GET("empresa/logIn/{correo}")
    Call<EmpresaModelo> logInEmpresa(@Path("correo") String correo);



}
