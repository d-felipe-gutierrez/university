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
    private String moneda;          // "ARS", "USD", "EUR", etc.

    @Column(name = "TASA_CAMBIO", nullable = false)
    private Double tasaCambio;      // cuántos ARS vale 1 unidad de esa moneda
}
