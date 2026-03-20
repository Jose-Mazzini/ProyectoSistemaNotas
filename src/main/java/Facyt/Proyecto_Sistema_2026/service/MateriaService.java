package Facyt.Proyecto_Sistema_2026.service;

import Facyt.Proyecto_Sistema_2026.model.Materia;
import Facyt.Proyecto_Sistema_2026.repository.IMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MateriaService implements IMateriaService {
    @Autowired
    private IMateriaRepository materiaRepository;
    @Override
    public List<Materia> listarMaterias() {
        return materiaRepository.findAll();
    }

    @Override
    public void agregarMateria(Materia materia) {
        materiaRepository.save(materia);
    }

    @Override
    public void eliminarMateria(Materia materia) {
       materiaRepository.delete(materia);
    }


}
