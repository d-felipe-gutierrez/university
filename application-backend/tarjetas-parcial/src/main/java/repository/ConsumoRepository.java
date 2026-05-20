package ar.edu.utnfc.backend.repository;

import ar.edu.utnfc.backend.model.Consumo;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ConsumoRepository {

    private final EntityManager em;

    public ConsumoRepository(EntityManager em) {
        this.em = em;
    }

    // ── CRUD ────────────────────────────────────────────────────────────────

    public void guardar(Consumo consumo) {
        em.getTransaction().begin();
        em.persist(consumo);
        em.getTransaction().commit();
    }

    public Consumo actualizar(Consumo consumo) {
        em.getTransaction().begin();
        Consumo resultado = em.merge(consumo);
        em.getTransaction().commit();
        return resultado;
    }

    public void eliminar(Long id) {
        em.getTransaction().begin();
        Consumo consumo = em.find(Consumo.class, id);
        if (consumo != null) {
            em.remove(consumo);
        }
        em.getTransaction().commit();
    }

    public Optional<Consumo> buscarPorId(Long id) {
        return Optional.ofNullable(em.find(Consumo.class, id));
    }

    public List<Consumo> buscarTodos() {
        return em.createQuery("SELECT c FROM Consumo c", Consumo.class)
                .getResultList();
    }

    // ── Consultas específicas ────────────────────────────────────────────────

    /**
     * Consumos de una tarjeta para un año y mes específico.
     */
    public List<Consumo> buscarPorTarjetaAnioMes(Long idTarjeta, int anio, int mes) {
        String jpql = """
                SELECT c FROM Consumo c
                WHERE c.tarjeta.id = :idTarjeta
                  AND c.anio = :anio
                  AND c.mes  = :mes
                ORDER BY c.dia
                """;
        return em.createQuery(jpql, Consumo.class)
                .setParameter("idTarjeta", idTarjeta)
                .setParameter("anio", anio)
                .setParameter("mes",  mes)
                .getResultList();
    }
}