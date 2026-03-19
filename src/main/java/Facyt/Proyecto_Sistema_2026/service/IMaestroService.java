package Facyt.Proyecto_Sistema_2026.service;

import Facyt.Proyecto_Sistema_2026.model.Maestro;

import java.util.List;

public interface IMaestroService {
    List<Maestro> findAll();
    Maestro findById(Integer id);
    Maestro save(Maestro maestro);
    void deleteById(Integer id);
}
