package ar.edu.utnfc.backend.repository;

import ar.edu.utnfc.backend.model.Liquidacion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.util.List;
import java.util.Optional;

public class LiquidacionRepository {

    private final EntityManager em;

    public LiquidacionRepository(EntityManager em) {
        this.em = em;
    }

    // ── CRUD ────────────────────────────────────────────────────────────────

    public void guardar(Liquidacion liquidacion) {
        em.getTransaction().begin();
        em.persist(liquidacion);
        em.getTransaction().commit();
    }

    public Liquidacion actualizar(Liquidacion liquidacion) {
        em.getTransaction().begin();
        Liquidacion resultado = em.merge(liquidacion);
        em.getTransaction().commit();
        return resultado;
    }

    public void eliminar(Long id) {
        em.getTransaction().begin();
        Liquidacion liquidacion = em.find(Liquidacion.class, id);
        if (liquidacion != null) {
            em.remove(liquidacion);
        }
        em.getTransaction().commit();
    }

    public Optional<Liquidacion> buscarPorId(Long id) {
        return Optional.ofNullable(em.find(Liquidacion.class, id));
    }

    public List<Liquidacion> buscarTodas() {
        return em.createQuery("SELECT l FROM Liquidacion l", Liquidacion.class)
                .getResultList();
    }

    // ── Consultas específicas ────────────────────────────────────────────────

    /**
     * Liquidación de una tarjeta buscando por número de tarjeta, año y mes.
     */
    public Optional<Liquidacion> buscarPorNumeroTarjetaAnioMes(
            String numeroTarjeta, int anio, int mes) {
        try {
            Liquidacion l = em.createQuery("""
                    SELECT l FROM Liquidacion l
                    WHERE l.tarjeta.numero = :numero
                      AND l.anio = :anio
                      AND l.mes  = :mes
                    """, Liquidacion.class)
                    .setParameter("numero", numeroTarjeta)
                    .setParameter("anio",   anio)
                    .setParameter("mes",    mes)
                    .getSingleResult();
            return Optional.of(l);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}