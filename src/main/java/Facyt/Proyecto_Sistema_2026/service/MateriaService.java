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
    public List<Materia> findAll() {
        return materiaRepository.findAll();
    }

    @Override
    public Materia findById(Integer id) {
        return materiaRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Materia materia) {
        materiaRepository.save(materia);
    }

    @Override
    public void deleteById(Integer id) {
        materiaRepository.deleteById(id);
    }

    @Override
    public List<Materia> findAllById(List<Integer> ids) {
        return materiaRepository.findAllById(ids);
    }
}
