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
    private int calificacion;
    private String diaMateria;
    private String horaMateria;

 @ManyToMany (mappedBy = "materias", fetch = FetchType.EAGER)
    private Set<Alumno> alumnos = new HashSet<>();

}
