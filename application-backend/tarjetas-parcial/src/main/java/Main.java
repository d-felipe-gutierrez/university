package ar.edu.utnfc.backend;

import ar.edu.utnfc.backend.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        // ── Bootstrap JPA ────────────────────────────────────────────────────
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tarjetasPU");
        EntityManager em = emf.createEntityManager();

        // ── Repositorios ─────────────────────────────────────────────────────
        TarjetaRepository     tarjetaRepo     = new TarjetaRepository(em);
        ConsumoRepository     consumoRepo     = new ConsumoRepository(em);
        CotizacionRepository  cotizacionRepo  = new CotizacionRepository(em);
        LiquidacionRepository liquidacionRepo = new LiquidacionRepository(em);

        // ── Demo: listar tarjetas ─────────────────────────────────────────────
        System.out.println("=== TARJETAS ===");
        tarjetaRepo.buscarTodas().forEach(System.out::println);

        // ── Demo: consumos tarjeta 1, mayo 2026 ──────────────────────────────
        System.out.println("\n=== CONSUMOS tarjeta 1 - Mayo 2026 ===");
        consumoRepo.buscarPorTarjetaAnioMes(1L, 2026, 5)
                .forEach(System.out::println);

        // ── Demo: tarjetas sin liquidación mayo 2026 ─────────────────────────
        System.out.println("\n=== TARJETAS SIN LIQUIDACIÓN - Mayo 2026 ===");
        tarjetaRepo.buscarSinLiquidacion(2026, 5)
                .forEach(System.out::println);

        // ── Demo: cotizaciones ────────────────────────────────────────────────
        System.out.println("\n=== COTIZACIONES ===");
        cotizacionRepo.buscarTodas().forEach(System.out::println);

        // ── Cierre ────────────────────────────────────────────────────────────
        em.close();
        emf.close();
    }
}