package Facyt.Proyecto_Sistema_2026.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Materia {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )


    private Integer idMateria;
    private String nombreMateria;
    private String diaMateria;
    private String horaMateria;

 @OneToMany(mappedBy = "materia")
    Set<Inscripciones> inscripciones = new HashSet<>();

 @OneToMany(mappedBy = "materia")
    Set<MaestroMateria> maestroMaterias = new HashSet<>();

}
