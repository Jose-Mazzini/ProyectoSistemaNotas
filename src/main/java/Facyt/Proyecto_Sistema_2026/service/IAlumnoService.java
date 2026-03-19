package Facyt.Proyecto_Sistema_2026.service;

import Facyt.Proyecto_Sistema_2026.model.Alumno;

import java.util.List;

public interface IAlumnoService {
    List<Alumno> findAll();
    Alumno findById(Integer id);
    Alumno save(Alumno alumno);
    void deleteById(Integer id);
}
