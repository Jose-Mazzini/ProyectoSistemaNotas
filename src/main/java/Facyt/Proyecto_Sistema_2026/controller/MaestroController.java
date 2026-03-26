package Facyt.Proyecto_Sistema_2026.controller;

import Facyt.Proyecto_Sistema_2026.model.Maestro;
import Facyt.Proyecto_Sistema_2026.model.MaestroMateria;
import Facyt.Proyecto_Sistema_2026.model.Materia;
import Facyt.Proyecto_Sistema_2026.service.IMaestroService;
import Facyt.Proyecto_Sistema_2026.service.IMateriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/maestros")
public class MaestroController {


    private final IMaestroService maestroService;
    private final IMateriaService materiaService;

    public MaestroController(IMaestroService maestroService, IMateriaService materiaService) {
        this.maestroService = maestroService;
        this.materiaService = materiaService;
    }

    @GetMapping
    public String listarMaestros(Model model) {
        model.addAttribute("maestros", maestroService.findAll());
        return "maestros/listar";
    }

    @GetMapping("/nuevo")
    public String nuevoMaestro(Model model) {
        model.addAttribute("maestro", new Maestro());
        model.addAttribute("materias", materiaService.findAll());
        return "maestros/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editarMaestro(@PathVariable Integer id, Model model) {
        Maestro maestro = maestroService.findById(id);

        if (maestro == null) {
            return "redirect:/maestros";
        }

        model.addAttribute("maestro", maestro);
        model.addAttribute("materias", materiaService.findAll());
        return "maestros/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Maestro maestro,
                          @RequestParam(required = false) List<Integer> materiasIds) {

        maestro.getMaestroMaterias().clear();

        if (materiasIds != null) {
            List<Materia> materias = materiaService.findAllById(materiasIds);

            for (Materia materia : materias) {
                MaestroMateria mm = new MaestroMateria();
                mm.setMaestro(maestro);
                mm.setMateria(materia);

                maestro.getMaestroMaterias().add(mm);
            }
        }

        maestroService.save(maestro);
        return "redirect:/maestros";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        maestroService.deleteById(id);
        return "redirect:/maestros";
    }

    @GetMapping("/{id}")
    public String verDetalle(@PathVariable Integer id, Model model) {
        Maestro maestro = maestroService.findById(id);

        if (maestro == null) {
            return "redirect:/maestros";
        }

        model.addAttribute("maestro", maestro);
        return "maestros/detalles";
    }
}