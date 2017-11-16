/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.controle.exceptions;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import rh.modelo.Empregado;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import rh.controle.exceptions.exceptions.IllegalOrphanException;
import rh.controle.exceptions.exceptions.NonexistentEntityException;
import rh.controle.exceptions.exceptions.PreexistingEntityException;
import rh.modelo.Departamento;

/**
 *
 * @author aluno
 */
public class DepartamentoJpaController implements Serializable {

    public DepartamentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Departamento departamento) throws PreexistingEntityException, Exception {
        if (departamento.getEmpregadoCollection() == null) {
            departamento.setEmpregadoCollection(new ArrayList<Empregado>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Empregado> attachedEmpregadoCollection = new ArrayList<Empregado>();
            for (Empregado empregadoCollectionEmpregadoToAttach : departamento.getEmpregadoCollection()) {
                empregadoCollectionEmpregadoToAttach = em.getReference(empregadoCollectionEmpregadoToAttach.getClass(), empregadoCollectionEmpregadoToAttach.getIdEmpregados());
                attachedEmpregadoCollection.add(empregadoCollectionEmpregadoToAttach);
            }
            departamento.setEmpregadoCollection(attachedEmpregadoCollection);
            em.persist(departamento);
            for (Empregado empregadoCollectionEmpregado : departamento.getEmpregadoCollection()) {
                Departamento oldDepartamentosidDepartamentosOfEmpregadoCollectionEmpregado = empregadoCollectionEmpregado.getDepartamentosidDepartamentos();
                empregadoCollectionEmpregado.setDepartamentosidDepartamentos(departamento);
                empregadoCollectionEmpregado = em.merge(empregadoCollectionEmpregado);
                if (oldDepartamentosidDepartamentosOfEmpregadoCollectionEmpregado != null) {
                    oldDepartamentosidDepartamentosOfEmpregadoCollectionEmpregado.getEmpregadoCollection().remove(empregadoCollectionEmpregado);
                    oldDepartamentosidDepartamentosOfEmpregadoCollectionEmpregado = em.merge(oldDepartamentosidDepartamentosOfEmpregadoCollectionEmpregado);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDepartamento(departamento.getIdDepartamentos()) != null) {
                throw new PreexistingEntityException("Departamento " + departamento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Departamento departamento) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Departamento persistentDepartamento = em.find(Departamento.class, departamento.getIdDepartamentos());
            Collection<Empregado> empregadoCollectionOld = persistentDepartamento.getEmpregadoCollection();
            Collection<Empregado> empregadoCollectionNew = departamento.getEmpregadoCollection();
            List<String> illegalOrphanMessages = null;
            for (Empregado empregadoCollectionOldEmpregado : empregadoCollectionOld) {
                if (!empregadoCollectionNew.contains(empregadoCollectionOldEmpregado)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Empregado " + empregadoCollectionOldEmpregado + " since its departamentosidDepartamentos field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Empregado> attachedEmpregadoCollectionNew = new ArrayList<Empregado>();
            for (Empregado empregadoCollectionNewEmpregadoToAttach : empregadoCollectionNew) {
                empregadoCollectionNewEmpregadoToAttach = em.getReference(empregadoCollectionNewEmpregadoToAttach.getClass(), empregadoCollectionNewEmpregadoToAttach.getIdEmpregados());
                attachedEmpregadoCollectionNew.add(empregadoCollectionNewEmpregadoToAttach);
            }
            empregadoCollectionNew = attachedEmpregadoCollectionNew;
            departamento.setEmpregadoCollection(empregadoCollectionNew);
            departamento = em.merge(departamento);
            for (Empregado empregadoCollectionNewEmpregado : empregadoCollectionNew) {
                if (!empregadoCollectionOld.contains(empregadoCollectionNewEmpregado)) {
                    Departamento oldDepartamentosidDepartamentosOfEmpregadoCollectionNewEmpregado = empregadoCollectionNewEmpregado.getDepartamentosidDepartamentos();
                    empregadoCollectionNewEmpregado.setDepartamentosidDepartamentos(departamento);
                    empregadoCollectionNewEmpregado = em.merge(empregadoCollectionNewEmpregado);
                    if (oldDepartamentosidDepartamentosOfEmpregadoCollectionNewEmpregado != null && !oldDepartamentosidDepartamentosOfEmpregadoCollectionNewEmpregado.equals(departamento)) {
                        oldDepartamentosidDepartamentosOfEmpregadoCollectionNewEmpregado.getEmpregadoCollection().remove(empregadoCollectionNewEmpregado);
                        oldDepartamentosidDepartamentosOfEmpregadoCollectionNewEmpregado = em.merge(oldDepartamentosidDepartamentosOfEmpregadoCollectionNewEmpregado);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = departamento.getIdDepartamentos();
                if (findDepartamento(id) == null) {
                    throw new NonexistentEntityException("The departamento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Departamento departamento;
            try {
                departamento = em.getReference(Departamento.class, id);
                departamento.getIdDepartamentos();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The departamento with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Empregado> empregadoCollectionOrphanCheck = departamento.getEmpregadoCollection();
            for (Empregado empregadoCollectionOrphanCheckEmpregado : empregadoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Departamento (" + departamento + ") cannot be destroyed since the Empregado " + empregadoCollectionOrphanCheckEmpregado + " in its empregadoCollection field has a non-nullable departamentosidDepartamentos field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(departamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Departamento> findDepartamentoEntities() {
        return findDepartamentoEntities(true, -1, -1);
    }

    public List<Departamento> findDepartamentoEntities(int maxResults, int firstResult) {
        return findDepartamentoEntities(false, maxResults, firstResult);
    }

    private List<Departamento> findDepartamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Departamento.class));
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

    public Departamento findDepartamento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Departamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getDepartamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Departamento> rt = cq.from(Departamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
