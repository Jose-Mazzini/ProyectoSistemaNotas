package Facyt.Proyecto_Sistema_2026.service;

import Facyt.Proyecto_Sistema_2026.model.Materia;

import java.util.List;

public interface IMateriaService {
    List<Materia> findAll();

    Materia findById(Integer id);

    void save(Materia materia);

    void deleteById(Integer id);

    List<Materia> findAllById(List<Integer> ids);
}
