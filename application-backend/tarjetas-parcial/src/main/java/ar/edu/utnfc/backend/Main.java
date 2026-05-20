package ar.edu.utnfc.backend;

import ar.edu.utnfc.backend.model.*;
import ar.edu.utnfc.backend.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tarjetasPU");
        EntityManager em = emf.createEntityManager();

        TarjetaRepository     tarjetaRepo     = new TarjetaRepository(em);
        ConsumoRepository     consumoRepo     = new ConsumoRepository(em);
        CotizacionRepository  cotizacionRepo  = new CotizacionRepository(em);
        LiquidacionRepository liquidacionRepo = new LiquidacionRepository(em);

        // ── 1. Listar todas las tarjetas ─────────────────────────────────────
        System.out.println("=== TARJETAS ===");
        tarjetaRepo.buscarTodas().forEach(System.out::println);

        // ── 2. Consumos de tarjeta 1 en Mayo 2026 ────────────────────────────
        System.out.println("\n=== CONSUMOS tarjeta 1 - Mayo 2026 ===");
        consumoRepo.buscarPorTarjetaAnioMes(1L, 2026, 5)
                .forEach(System.out::println);

        // ── 3. Tarjetas sin liquidación en Mayo 2026 ─────────────────────────
        System.out.println("\n=== TARJETAS SIN LIQUIDACIÓN - Mayo 2026 ===");
        tarjetaRepo.buscarSinLiquidacion(2026, 5)
                .forEach(System.out::println);

        // ── 4. Cotizaciones ───────────────────────────────────────────────────
        System.out.println("\n=== COTIZACIONES ===");
        cotizacionRepo.buscarTodas().forEach(System.out::println);

        // ── 5. Crear una liquidación de prueba ────────────────────────────────
        System.out.println("\n=== CREANDO LIQUIDACIÓN DE PRUEBA ===");
        Tarjeta tarjeta1 = tarjetaRepo.buscarPorId(1L).orElseThrow();
        Liquidacion liq = new Liquidacion(
                null,
                tarjeta1,
                5, 2026,
                150000.0,
                130000.0,
                20000.0,
                0.0
        );
        liquidacionRepo.guardar(liq);
        System.out.println("Liquidación guardada con ID: " + liq.getId());

        // ── 6. Buscar liquidación por número de tarjeta, año y mes ───────────
        System.out.println("\n=== LIQUIDACIÓN de tarjeta 4500123412340001 - Mayo 2026 ===");
        Optional<Liquidacion> liquidacion = liquidacionRepo
                .buscarPorNumeroTarjetaAnioMes("4500123412340001", 2026, 5);

        if (liquidacion.isPresent()) {
            System.out.println("Liquidación encontrada:");
            System.out.println(liquidacion.get());
            System.out.println("Total a pagar:    " + liquidacion.get().getTotalAPagar());
            System.out.println("Total consumos:   " + liquidacion.get().getTotalConsumos());
            System.out.println("Total impuestos:  " + liquidacion.get().getTotalImpuestos());
            System.out.println("Total descuentos: " + liquidacion.get().getTotalDescuentos());
        } else {
            System.out.println("No se encontró liquidación para esa tarjeta en ese período.");
        }

        // ── 7. Verificar tarjetas sin liquidación ahora (debe ser 9) ─────────
        System.out.println("\n=== TARJETAS SIN LIQUIDACIÓN DESPUÉS DE CREAR UNA ===");
        tarjetaRepo.buscarSinLiquidacion(2026, 5)
                .forEach(System.out::println);

        // ── Cierre ────────────────────────────────────────────────────────────
        em.close();
        emf.close();
    }
}