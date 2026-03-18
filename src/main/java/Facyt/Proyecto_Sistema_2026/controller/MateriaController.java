package Facyt.Proyecto_Sistema_2026.controller;

import Facyt.Proyecto_Sistema_2026.model.Materia;
import Facyt.Proyecto_Sistema_2026.repository.IMateriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/materias")

public class MateriaController {
    @Autowired
    private IMateriaRepository materiaRepository;

    // Obtener materia
    @GetMapping
    public List<Materia> getAllMaterias() {
        return materiaRepository.findAll();
    }

    //  Obtener  materia por ID
    @GetMapping("/{id}")
    public Optional<Materia> getMateriaById(@PathVariable Integer id) {
        return materiaRepository.findById(id);
    }

    //  Crear materia
    @PostMapping
    public Materia createMateria(@RequestBody Materia materia) {
        return materiaRepository.save(materia);
    }

    // Actualizar materia
    @PutMapping("/{id}")
    public Materia updateMateria(@PathVariable Integer id, @RequestBody Materia materiaActualizada) {
        return materiaRepository.findById(id)
                .map(materia -> {
                    materia.setNombreMateria(materiaActualizada.getNombreMateria());
                    materia.setCalificacion(materiaActualizada.getCalificacion());
                    materia.setDiaMateria(materiaActualizada.getDiaMateria());
                    materia.setHoraMateria(materiaActualizada.getHoraMateria());
                    return materiaRepository.save(materia);
                })
                .orElseGet(() -> {
                    materiaActualizada.setIdMateria(id);
                    return materiaRepository.save(materiaActualizada);
                });
    }

    // fulminar
    @DeleteMapping("/{id}")
    public void deleteMateria(@PathVariable Integer id) {
        materiaRepository.deleteById(id);
    }
}
