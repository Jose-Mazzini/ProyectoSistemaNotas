package Facyt.Proyecto_Sistema_2026.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="maestro_materias")
public class MaestroMateria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="maestro_id")
    private Maestro maestro;

    @ManyToOne
    @JoinColumn(name="materia_id")
    private Materia materia;
}
