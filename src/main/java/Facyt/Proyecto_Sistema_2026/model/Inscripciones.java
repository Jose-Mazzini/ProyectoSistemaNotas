package Facyt.Proyecto_Sistema_2026.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="alumno_materias")
public class Inscripciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="alumno_id")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name="materia_id")
    private Materia materia;

    private int calificacion;
}
