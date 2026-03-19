package Facyt.Proyecto_Sistema_2026.service;

import Facyt.Proyecto_Sistema_2026.model.Maestro;
import Facyt.Proyecto_Sistema_2026.repository.IMaestroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaestroService implements IMaestroService {

    @Autowired
    private IMaestroRepository maestroRepository;

    @Override
    public List<Maestro> findAll() {
        return maestroRepository.findAll();
    }

    @Override
    public Maestro findById(Integer id) {
        return maestroRepository.findById(id).orElse(null);
    }

    @Override
    public Maestro save(Maestro maestro) {
        return maestroRepository.save(maestro);
    }

    @Override
    public void deleteById(Integer id) {
        maestroRepository.deleteById(id);
    }
}
