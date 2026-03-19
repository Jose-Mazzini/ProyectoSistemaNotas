package Facyt.Proyecto_Sistema_2026.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


@Entity
public class Alumno extends Persona {
@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "alumno_materias",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn (name = "materia_id")
    )
    private Set <Materia> materias = new HashSet<>();
}
