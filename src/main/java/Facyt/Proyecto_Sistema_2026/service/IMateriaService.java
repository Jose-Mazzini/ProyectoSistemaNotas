package Facyt.Proyecto_Sistema_2026.service;

import Facyt.Proyecto_Sistema_2026.model.Materias;

import java.util.List;

public interface IMateriaService {
    public List<Materias> listarMaterias ();
    public void agregarMateria (Materias materia);
    public void eliminarMateria (Materias materia);
}
