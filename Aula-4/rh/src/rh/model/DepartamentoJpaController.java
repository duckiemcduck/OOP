/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.model;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import rh.model.exceptions.IllegalOrphanException;
import rh.model.exceptions.NonexistentEntityException;
import rh.model.exceptions.PreexistingEntityException;

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
        if (departamento.getEmpregadoList() == null) {
            departamento.setEmpregadoList(new ArrayList<Empregado>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Empregado> attachedEmpregadoList = new ArrayList<Empregado>();
            for (Empregado empregadoListEmpregadoToAttach : departamento.getEmpregadoList()) {
                empregadoListEmpregadoToAttach = em.getReference(empregadoListEmpregadoToAttach.getClass(), empregadoListEmpregadoToAttach.getIdEmpregados());
                attachedEmpregadoList.add(empregadoListEmpregadoToAttach);
            }
            departamento.setEmpregadoList(attachedEmpregadoList);
            em.persist(departamento);
            for (Empregado empregadoListEmpregado : departamento.getEmpregadoList()) {
                Departamento oldDepartamentosidDepartamentosOfEmpregadoListEmpregado = empregadoListEmpregado.getDepartamentosidDepartamentos();
                empregadoListEmpregado.setDepartamentosidDepartamentos(departamento);
                empregadoListEmpregado = em.merge(empregadoListEmpregado);
                if (oldDepartamentosidDepartamentosOfEmpregadoListEmpregado != null) {
                    oldDepartamentosidDepartamentosOfEmpregadoListEmpregado.getEmpregadoList().remove(empregadoListEmpregado);
                    oldDepartamentosidDepartamentosOfEmpregadoListEmpregado = em.merge(oldDepartamentosidDepartamentosOfEmpregadoListEmpregado);
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
            List<Empregado> empregadoListOld = persistentDepartamento.getEmpregadoList();
            List<Empregado> empregadoListNew = departamento.getEmpregadoList();
            List<String> illegalOrphanMessages = null;
            for (Empregado empregadoListOldEmpregado : empregadoListOld) {
                if (!empregadoListNew.contains(empregadoListOldEmpregado)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Empregado " + empregadoListOldEmpregado + " since its departamentosidDepartamentos field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Empregado> attachedEmpregadoListNew = new ArrayList<Empregado>();
            for (Empregado empregadoListNewEmpregadoToAttach : empregadoListNew) {
                empregadoListNewEmpregadoToAttach = em.getReference(empregadoListNewEmpregadoToAttach.getClass(), empregadoListNewEmpregadoToAttach.getIdEmpregados());
                attachedEmpregadoListNew.add(empregadoListNewEmpregadoToAttach);
            }
            empregadoListNew = attachedEmpregadoListNew;
            departamento.setEmpregadoList(empregadoListNew);
            departamento = em.merge(departamento);
            for (Empregado empregadoListNewEmpregado : empregadoListNew) {
                if (!empregadoListOld.contains(empregadoListNewEmpregado)) {
                    Departamento oldDepartamentosidDepartamentosOfEmpregadoListNewEmpregado = empregadoListNewEmpregado.getDepartamentosidDepartamentos();
                    empregadoListNewEmpregado.setDepartamentosidDepartamentos(departamento);
                    empregadoListNewEmpregado = em.merge(empregadoListNewEmpregado);
                    if (oldDepartamentosidDepartamentosOfEmpregadoListNewEmpregado != null && !oldDepartamentosidDepartamentosOfEmpregadoListNewEmpregado.equals(departamento)) {
                        oldDepartamentosidDepartamentosOfEmpregadoListNewEmpregado.getEmpregadoList().remove(empregadoListNewEmpregado);
                        oldDepartamentosidDepartamentosOfEmpregadoListNewEmpregado = em.merge(oldDepartamentosidDepartamentosOfEmpregadoListNewEmpregado);
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
            List<Empregado> empregadoListOrphanCheck = departamento.getEmpregadoList();
            for (Empregado empregadoListOrphanCheckEmpregado : empregadoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Departamento (" + departamento + ") cannot be destroyed since the Empregado " + empregadoListOrphanCheckEmpregado + " in its empregadoList field has a non-nullable departamentosidDepartamentos field.");
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
