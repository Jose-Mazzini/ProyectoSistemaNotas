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
public class Maestro extends Persona {
    @OneToMany(mappedBy = "maestro", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MaestroMateria> maestroMaterias = new HashSet<>();


    public Set<Materia> getMaterias() {
        Set<Materia> materias = new HashSet<>();
        for (MaestroMateria mm : maestroMaterias) {
            if (mm.getMateria() != null) {
                materias.add(mm.getMateria());
            }
        }
        return materias;
    }

}
