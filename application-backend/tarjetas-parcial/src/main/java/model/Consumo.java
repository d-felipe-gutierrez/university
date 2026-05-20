package ar.edu.utnfc.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CONSUMOS")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "tarjeta")
public class Consumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TARJETA", nullable = false)
    private Tarjeta tarjeta;

    @Column(name = "MONTO", nullable = false)
    private Double monto;

    @Column(name = "DIA", nullable = false)
    private Integer dia;

    @Column(name = "MES", nullable = false)
    private Integer mes;

    @Column(name = "ANIO", nullable = false)
    private Integer anio;

    @Column(name = "RUBRO", length = 20, nullable = false)
    private String rubro;

    @Column(name = "MONEDA", length = 3, nullable = false)
    private String moneda;
}