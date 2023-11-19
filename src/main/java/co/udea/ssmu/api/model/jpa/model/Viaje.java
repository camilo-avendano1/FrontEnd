package co.udea.ssmu.api.model.jpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "VIAJE")
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIAJE_id_gen")
    @SequenceGenerator(name = "VIAJE_id_gen", sequenceName = "ID_VIAJE_SECUENCIA", allocationSize = 1)
    @Column(name = "ID_VIAJE", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "ID_CONDUCTOR", nullable = false)
    private Long idConductor;

    @NotNull
    @Column(name = "ID_USUARIO", nullable = false)
    private Long idUsuario;

    @NotNull
    @Column(name = "LATITUD_INICIAL", nullable = false, precision = 9, scale = 6)
    private BigDecimal latitudInicial;

    @NotNull
    @Column(name = "LONGITUD_INICIAL", nullable = false, precision = 9, scale = 6)
    private BigDecimal longitudInicial;


    @NotNull
    @Column(name = "LATITUD_FINAL", nullable = false, precision = 9, scale = 6)
    private BigDecimal latitudFinal;


    @NotNull
    @Column(name = "LONGITUD_FINAL", nullable = false, precision = 9, scale = 6)
    private BigDecimal longitudFinal;



}