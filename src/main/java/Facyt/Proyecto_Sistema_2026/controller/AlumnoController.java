package Facyt.Proyecto_Sistema_2026.controller;

import Facyt.Proyecto_Sistema_2026.model.Alumno;
import Facyt.Proyecto_Sistema_2026.model.Materia;
import Facyt.Proyecto_Sistema_2026.service.IAlumnoService;
import Facyt.Proyecto_Sistema_2026.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private IAlumnoService alumnoService;

    @Autowired
    private IMateriaService materiaService;

    // Listar todos los alumnos
    @GetMapping
    public String listarAlumnos(Model model) {
        List<Alumno> alumnos = alumnoService.findAll();
        model.addAttribute("alumnos", alumnos);
        return "alumnos/listar";
    }

    // Mostrar formulario para crear nuevo alumno
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("alumno", new Alumno());
        List<Materia> materias = materiaService.findAll();
        model.addAttribute("materias", materias);
        return "alumnos/formulario";
    }

    // Mostrar formulario para editar alumno
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Alumno alumno = alumnoService.findById(id);
        if (alumno == null) {
            return "redirect:/alumnos?error=Alumno no encontrado";
        }
        model.addAttribute("alumno", alumno);
        List<Materia> materias = materiaService.findAll();
        model.addAttribute("materias", materias);
        return "alumnos/formulario";
    }

    // Guardar alumno (crear o actualizar)
    @PostMapping("/guardar")
    public String guardarAlumno(@ModelAttribute Alumno alumno) {
        alumnoService.save(alumno);
        return "redirect:/alumnos?exito=Alumno guardado correctamente";
    }

    // Ver detalles del alumno
    @GetMapping("/{id}")
    public String verDetalles(@PathVariable Integer id, Model model) {
        Alumno alumno = alumnoService.findById(id);
        if (alumno == null) {
            return "redirect:/alumnos?error=Alumno no encontrado";
        }
        model.addAttribute("alumno", alumno);
        return "alumnos/detalles";
    }

    // Eliminar alumno
    @GetMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable Integer id) {
        alumnoService.deleteById(id);
        return "redirect:/alumnos?exito=Alumno eliminado correctamente";
    }
}

