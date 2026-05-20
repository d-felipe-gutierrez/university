package ar.edu.utnfc.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TARJETAS")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"consumos", "liquidaciones"})
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NUMERO", length = 16, nullable = false, unique = true)
    private String numero;

    @Column(name = "TITULAR", length = 100, nullable = false)
    private String titular;

    @Column(name = "LIMITE_CREDITO", nullable = false)
    private Double limiteCredito;

    // ── Relaciones ──────────────────────────────────────────────────────────
    @OneToMany(mappedBy = "tarjeta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consumo> consumos = new ArrayList<>();

    @OneToMany(mappedBy = "tarjeta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Liquidacion> liquidaciones = new ArrayList<>();
}