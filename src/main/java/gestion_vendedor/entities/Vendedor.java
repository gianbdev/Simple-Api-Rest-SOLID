package gestion_vendedor.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Vendedor")
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

    // Getter y Setter para 'nombre'
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para 'apellido'
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Getter y Setter para 'correo'
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Getter y Setter para 'celular'
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    // Getter y Setter para 'estado'
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    // Getter y Setter para 'id'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

/*
package gestion_vendedor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Vendedor")
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

    @Enumerated(EnumType.STRING)  // Usa el enum para la columna 'estado'
    @Column(name = "estado", length = 1)
    private Estado estado;  // Usa el enum Estado para los valores 'A' y 'I'
}*/
