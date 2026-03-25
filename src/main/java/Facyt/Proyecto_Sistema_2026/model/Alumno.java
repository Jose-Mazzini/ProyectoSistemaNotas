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
public class Alumno extends Persona{
@OneToMany(mappedBy = "alumno")
    private Set<Inscripciones> inscripciones = new HashSet<>();
}
