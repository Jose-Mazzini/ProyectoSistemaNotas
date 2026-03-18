package Facyt.Proyecto_Sistema_2026.service;

import Facyt.Proyecto_Sistema_2026.model.Materia;

import java.util.List;

public interface IMateriaService {
    public List<Materia> listarMaterias ();
    public void agregarMateria (Materia materia);
    public void eliminarMateria (Materia materia);
}
