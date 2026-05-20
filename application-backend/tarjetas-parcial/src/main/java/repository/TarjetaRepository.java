package ar.edu.utnfc.backend.repository;

import ar.edu.utnfc.backend.model.Tarjeta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.util.List;
import java.util.Optional;

public class TarjetaRepository {

    private final EntityManager em;

    public TarjetaRepository(EntityManager em) {
        this.em = em;
    }

    // ── CRUD ────────────────────────────────────────────────────────────────

    public void guardar(Tarjeta tarjeta) {
        em.getTransaction().begin();
        em.persist(tarjeta);
        em.getTransaction().commit();
    }

    public Tarjeta actualizar(Tarjeta tarjeta) {
        em.getTransaction().begin();
        Tarjeta resultado = em.merge(tarjeta);
        em.getTransaction().commit();
        return resultado;
    }

    public void eliminar(Long id) {
        em.getTransaction().begin();
        Tarjeta tarjeta = em.find(Tarjeta.class, id);
        if (tarjeta != null) {
            em.remove(tarjeta);
        }
        em.getTransaction().commit();
    }

    public Optional<Tarjeta> buscarPorId(Long id) {
        return Optional.ofNullable(em.find(Tarjeta.class, id));
    }

    public List<Tarjeta> buscarTodas() {
        return em.createQuery("SELECT t FROM Tarjeta t", Tarjeta.class)
                .getResultList();
    }

    // ── Consultas específicas ────────────────────────────────────────────────

    /**
     * Tarjetas que NO tienen liquidación para el año/mes indicado.
     */
    public List<Tarjeta> buscarSinLiquidacion(int anio, int mes) {
        String jpql = """
                SELECT t FROM Tarjeta t
                WHERE t.id NOT IN (
                    SELECT l.tarjeta.id FROM Liquidacion l
                    WHERE l.anio = :anio AND l.mes = :mes
                )
                """;
        return em.createQuery(jpql, Tarjeta.class)
                .setParameter("anio", anio)
                .setParameter("mes",  mes)
                .getResultList();
    }

    /**
     * Busca una tarjeta por su número de plástico.
     */
    public Optional<Tarjeta> buscarPorNumero(String numero) {
        try {
            Tarjeta t = em.createQuery(
                            "SELECT t FROM Tarjeta t WHERE t.numero = :numero", Tarjeta.class)
                    .setParameter("numero", numero)
                    .getSingleResult();
            return Optional.of(t);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}