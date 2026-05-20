package ar.edu.utnfc.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "COTIZACIONES")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cotizacion {

    @Id
    @Column(name = "MONEDA", length = 3)
    private String moneda;

    @Column(name = "TASA_CAMBIO", nullable = false)
    private Double tasaCambio;
}