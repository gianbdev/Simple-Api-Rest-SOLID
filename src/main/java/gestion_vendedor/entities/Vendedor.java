package gestion_vendedor.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Vendedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vendedor")
    private Long id;

    @Column(name = "nom_vendedor", length = 45)
    private String nombre;

    @Column(name = "ape_vendedor", length = 45)
    private String apellido;

    @Column(name = "correo", length = 35)
    private String correo;

    @Column(name = "celular", length = 9)
    private String celular;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 1)
    private Estado estado;
}

