package Facyt.Proyecto_Sistema_2026.controller;

import Facyt.Proyecto_Sistema_2026.model.Materia;
import Facyt.Proyecto_Sistema_2026.service.IMateriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/materias")
public class MateriaController {

    private final IMateriaService materiaService;

    public MateriaController(IMateriaService materiaService) {
        this.materiaService = materiaService;
    }

    // LISTAR
    @GetMapping
    public String listarMaterias(Model model) {
        List<Materia> materias = materiaService.findAll();
        model.addAttribute("materias", materias);
        return "materias/listar";
    }

    // FORM NUEVO
    @GetMapping("/nuevo")
    public String nuevaMateria(Model model) {
        model.addAttribute("materia", new Materia());
        return "materias/formulario";
    }

    // FORM EDITAR
    @GetMapping("/editar/{id}")
    public String editarMateria(@PathVariable Integer id, Model model) {
        Materia materia = materiaService.findById(id);

        if (materia == null) {
            return "redirect:/materias";
        }

        model.addAttribute("materia", materia);
        return "materias/formulario";
    }

    // GUARDAR (CREAR / EDITAR)
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Materia materia) {
        materiaService.save(materia);
        return "redirect:/materias";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        materiaService.deleteById(id);
        return "redirect:/materias";
    }

    // DETALLE
    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable Integer id, Model model) {
        Materia materia = materiaService.findById(id);

        if (materia == null) {
            return "redirect:/materias";
        }

        model.addAttribute("materia", materia);
        return "materias/detalle";
    }
}