package ar.edu.utnfc.backend;

import ar.edu.utnfc.backend.model.*;
import ar.edu.utnfc.backend.repository.*;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TarjetasTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    private static TarjetaRepository     tarjetaRepo;
    private static ConsumoRepository     consumoRepo;
    private static CotizacionRepository  cotizacionRepo;
    private static LiquidacionRepository liquidacionRepo;

    // ── Setup / TearDown ─────────────────────────────────────────────────────

    @BeforeAll
    static void setUp() {
        emf = Persistence.createEntityManagerFactory("tarjetasPU");
        em  = emf.createEntityManager();

        tarjetaRepo     = new TarjetaRepository(em);
        consumoRepo     = new ConsumoRepository(em);
        cotizacionRepo  = new CotizacionRepository(em);
        liquidacionRepo = new LiquidacionRepository(em);
    }

    @AfterAll
    static void tearDown() {
        if (em  != null) em.close();
        if (emf != null) emf.close();
    }

    // ── Cotizaciones ─────────────────────────────────────────────────────────

    @Test @Order(1)
    void testBuscarTodasLasCotizaciones() {
        List<Cotizacion> lista = cotizacionRepo.buscarTodas();
        assertFalse(lista.isEmpty(), "Debe haber cotizaciones cargadas");
        assertEquals(5, lista.size());
    }

    @Test @Order(2)
    void testBuscarCotizacionPorMoneda() {
        Optional<Cotizacion> usd = cotizacionRepo.buscarPorMoneda("USD");
        assertTrue(usd.isPresent());
        assertEquals(1550.0, usd.get().getTasaCambio());
    }

    // ── Tarjetas ─────────────────────────────────────────────────────────────

    @Test @Order(3)
    void testBuscarTodasLasTarjetas() {
        List<Tarjeta> lista = tarjetaRepo.buscarTodas();
        assertEquals(10, lista.size());
    }

    @Test @Order(4)
    void testBuscarTarjetaPorId() {
        Optional<Tarjeta> t = tarjetaRepo.buscarPorId(1L);
        assertTrue(t.isPresent());
        assertEquals("Juan Perez", t.get().getTitular());
    }

    @Test @Order(5)
    void testBuscarTarjetaPorNumero() {
        Optional<Tarjeta> t = tarjetaRepo.buscarPorNumero("4500123412340003");
        assertTrue(t.isPresent());
        assertEquals("Carlos Diaz", t.get().getTitular());
    }

    @Test @Order(6)
    void testGuardarYEliminarTarjeta() {
        Tarjeta nueva = new Tarjeta(null, "9999000099990000",
                "Test User", 500000.0,
                null, null);
        tarjetaRepo.guardar(nueva);
        assertNotNull(nueva.getId());

        tarjetaRepo.eliminar(nueva.getId());
        assertFalse(tarjetaRepo.buscarPorId(nueva.getId()).isPresent());
    }

    // ── Consumos ─────────────────────────────────────────────────────────────

    @Test @Order(7)
    void testBuscarTodosLosConsumos() {
        List<Consumo> lista = consumoRepo.buscarTodos();
        assertFalse(lista.isEmpty());
    }

    @Test @Order(8)
    void testBuscarConsumosPorTarjetaAnioMes() {
        // Tarjeta 1 tiene 15 consumos en Mayo 2026
        List<Consumo> lista = consumoRepo.buscarPorTarjetaAnioMes(1L, 2026, 5);
        assertEquals(15, lista.size());
    }

    @Test @Order(9)
    void testConsumosTarjeta4AbrilYMayo() {
        // Tarjeta 4 tiene 2 consumos en Abril 2026
        List<Consumo> abril = consumoRepo.buscarPorTarjetaAnioMes(4L, 2026, 4);
        assertEquals(2, abril.size());

        // Tarjeta 4 tiene 3 consumos en Mayo 2026
        List<Consumo> mayo = consumoRepo.buscarPorTarjetaAnioMes(4L, 2026, 5);
        assertEquals(3, mayo.size());
    }

    // ── Liquidaciones ─────────────────────────────────────────────────────────

    @Test @Order(10)
    void testTarjetasSinLiquidacionMayo2026() {
        // No hay liquidaciones cargadas → todas las tarjetas deben aparecer
        List<Tarjeta> sinLiq = tarjetaRepo.buscarSinLiquidacion(2026, 5);
        assertEquals(10, sinLiq.size());
    }

    @Test @Order(11)
    void testGuardarLiquidacionYBuscarPorNumero() {
        // Buscar tarjeta 1
        Tarjeta t1 = tarjetaRepo.buscarPorId(1L).orElseThrow();

        Liquidacion liq = new Liquidacion(null, t1, 5, 2026,
                150000.0, 130000.0,
                20000.0,  0.0);
        liquidacionRepo.guardar(liq);
        assertNotNull(liq.getId());

        // Ahora sólo 9 tarjetas sin liquidación
        List<Tarjeta> sinLiq = tarjetaRepo.buscarSinLiquidacion(2026, 5);
        assertEquals(9, sinLiq.size());

        // Buscar por número de tarjeta
        Optional<Liquidacion> encontrada =
                liquidacionRepo.buscarPorNumeroTarjetaAnioMes(
                        "4500123412340001", 2026, 5);
        assertTrue(encontrada.isPresent());
        assertEquals(150000.0, encontrada.get().getTotalAPagar());
    }

    @Test @Order(12)
    void testBuscarLiquidacionInexistente() {
        Optional<Liquidacion> resultado =
                liquidacionRepo.buscarPorNumeroTarjetaAnioMes(
                        "4500123412340002", 2026, 5);
        assertFalse(resultado.isPresent());
    }
}