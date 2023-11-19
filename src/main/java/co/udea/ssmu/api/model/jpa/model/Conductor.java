package co.udea.ssmu.api.model.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CONDUCTOR")
public class Conductor {
    @Id
    @Column(name = "ID_CONDUCTOR", nullable = false)
    private Long id;

    @Size(max = 10)
    @Column(name = "ROL", length = 10)
    private String rol;

    @Size(max = 50)
    @NotNull
    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Size(max = 50)
    @NotNull
    @Column(name = "APELLIDO", nullable = false, length = 50)
    private String apellido;

    @Size(max = 10)
    @NotNull
    @Column(name = "CEDULA", nullable = false, length = 10)
    private String cedula;

    @Size(max = 10)
    @Column(name = "ESTADO", length = 10)
    private String estado;

    @Size(max = 10)
    @Column(name = "PLACA",  length = 10)
    private String placa;

    @Size(max = 20)
    @Column(name = "MODELO",  length = 20)
    private String modelo;

    @Size(max = 20)
    @Column(name = "COLOR",  length = 20)
    private String color;

    @Size(max = 20)
    @Column(name = "MARCA",  length = 20)
    private String marca;

}