/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.controle.exceptions;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import rh.controle.exceptions.exceptions.NonexistentEntityException;
import rh.controle.exceptions.exceptions.PreexistingEntityException;
import rh.modelo.Departamento;
import rh.modelo.Empregado;

/**
 *
 * @author aluno
 */
public class EmpregadoJpaController implements Serializable {

    public EmpregadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empregado empregado) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Departamento departamentosidDepartamentos = empregado.getDepartamentosidDepartamentos();
            if (departamentosidDepartamentos != null) {
                departamentosidDepartamentos = em.getReference(departamentosidDepartamentos.getClass(), departamentosidDepartamentos.getIdDepartamentos());
                empregado.setDepartamentosidDepartamentos(departamentosidDepartamentos);
            }
            em.persist(empregado);
            if (departamentosidDepartamentos != null) {
                departamentosidDepartamentos.getEmpregadoCollection().add(empregado);
                departamentosidDepartamentos = em.merge(departamentosidDepartamentos);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpregado(empregado.getIdEmpregados()) != null) {
                throw new PreexistingEntityException("Empregado " + empregado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empregado empregado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empregado persistentEmpregado = em.find(Empregado.class, empregado.getIdEmpregados());
            Departamento departamentosidDepartamentosOld = persistentEmpregado.getDepartamentosidDepartamentos();
            Departamento departamentosidDepartamentosNew = empregado.getDepartamentosidDepartamentos();
            if (departamentosidDepartamentosNew != null) {
                departamentosidDepartamentosNew = em.getReference(departamentosidDepartamentosNew.getClass(), departamentosidDepartamentosNew.getIdDepartamentos());
                empregado.setDepartamentosidDepartamentos(departamentosidDepartamentosNew);
            }
            empregado = em.merge(empregado);
            if (departamentosidDepartamentosOld != null && !departamentosidDepartamentosOld.equals(departamentosidDepartamentosNew)) {
                departamentosidDepartamentosOld.getEmpregadoCollection().remove(empregado);
                departamentosidDepartamentosOld = em.merge(departamentosidDepartamentosOld);
            }
            if (departamentosidDepartamentosNew != null && !departamentosidDepartamentosNew.equals(departamentosidDepartamentosOld)) {
                departamentosidDepartamentosNew.getEmpregadoCollection().add(empregado);
                departamentosidDepartamentosNew = em.merge(departamentosidDepartamentosNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empregado.getIdEmpregados();
                if (findEmpregado(id) == null) {
                    throw new NonexistentEntityException("The empregado with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empregado empregado;
            try {
                empregado = em.getReference(Empregado.class, id);
                empregado.getIdEmpregados();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empregado with id " + id + " no longer exists.", enfe);
            }
            Departamento departamentosidDepartamentos = empregado.getDepartamentosidDepartamentos();
            if (departamentosidDepartamentos != null) {
                departamentosidDepartamentos.getEmpregadoCollection().remove(empregado);
                departamentosidDepartamentos = em.merge(departamentosidDepartamentos);
            }
            em.remove(empregado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empregado> findEmpregadoEntities() {
        return findEmpregadoEntities(true, -1, -1);
    }

    public List<Empregado> findEmpregadoEntities(int maxResults, int firstResult) {
        return findEmpregadoEntities(false, maxResults, firstResult);
    }

    private List<Empregado> findEmpregadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empregado.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Empregado findEmpregado(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empregado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpregadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empregado> rt = cq.from(Empregado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
