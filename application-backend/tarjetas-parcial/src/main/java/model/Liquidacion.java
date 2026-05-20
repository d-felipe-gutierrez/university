package ar.edu.utnfc.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "LIQUIDACIONES")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "tarjeta")
public class Liquidacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TARJETA", nullable = false)
    private Tarjeta tarjeta;

    @Column(name = "MES", nullable = false)
    private Integer mes;

    @Column(name = "ANIO", nullable = false)
    private Integer anio;

    @Column(name = "TOTAL_A_PAGAR", nullable = false)
    private Double totalAPagar;

    @Column(name = "TOTAL_CONSUMOS", nullable = false)
    private Double totalConsumos;

    @Column(name = "TOTAL_IMPUESTOS", nullable = false)
    private Double totalImpuestos;

    @Column(name = "TOTAL_DESCUENTOS", nullable = false)
    private Double totalDescuentos;
}