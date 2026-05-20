package ar.edu.utnfc.backend.repository;

import ar.edu.utnfc.backend.model.Cotizacion;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class CotizacionRepository {

    private final EntityManager em;

    public CotizacionRepository(EntityManager em) {
        this.em = em;
    }

    // ── CRUD ────────────────────────────────────────────────────────────────

    public void guardar(Cotizacion cotizacion) {
        em.getTransaction().begin();
        em.persist(cotizacion);
        em.getTransaction().commit();
    }

    public Cotizacion actualizar(Cotizacion cotizacion) {
        em.getTransaction().begin();
        Cotizacion resultado = em.merge(cotizacion);
        em.getTransaction().commit();
        return resultado;
    }

    public void eliminar(String moneda) {
        em.getTransaction().begin();
        Cotizacion cotizacion = em.find(Cotizacion.class, moneda);
        if (cotizacion != null) {
            em.remove(cotizacion);
        }
        em.getTransaction().commit();
    }

    public Optional<Cotizacion> buscarPorMoneda(String moneda) {
        return Optional.ofNullable(em.find(Cotizacion.class, moneda));
    }

    public List<Cotizacion> buscarTodas() {
        return em.createQuery("SELECT c FROM Cotizacion c", Cotizacion.class)
                .getResultList();
    }
}