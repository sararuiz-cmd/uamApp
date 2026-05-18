package modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Table(name="carreras")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Carrera {
    @Id
    @Column(name = "id_carrera")
    private Long id;
    @Column(name="nombre_carrera",length = 120, nullable = false)
    private String nombre;
    @DecimalMin(value = "0.01",message = "Debe ser mayor a 0")
    @Column(name="precio_carrera")
    private double precio;
}
