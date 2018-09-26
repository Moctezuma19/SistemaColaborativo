/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.sistemacolaborativo.modelo;

import java.util.List;
import mx.unam.ciencias.is.sistemacolaborativo.mapeobd.Estudios;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Moctezuma19
 */
public class EstudiosDAO {

    /*Sesion para conectarnos a la base de datos*/
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void guardar(Estudios estudios) {
        //se inicia la sesion
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //guardamos el usuario
            session.persist(estudios);

            tx.commit();
        } catch (Exception e) {
            //Se regresa a un estado consistente 
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            //cerramos simpre la sesion
            session.close();
        }
    }

    /**
     * Elimina el usuario de la base de datos
     *
     * @param usuario el usuario a eliminar
     */
    public void eliminar(Estudios estudios) {
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //eliminamos el usuario
            session.delete(estudios);

            tx.commit();
        } catch (Exception e) {
            //Se regresa a un estado consistente 
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            //cerramos siempre la sesion
            session.close();
        }
    }

    /**
     * Actualiza el usuario en la base de datos
     *
     */
    public void actualizar(Estudios estudios) {
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //actualizar el usuario
            session.update(estudios);

            tx.commit();
        } catch (Exception e) {
            //Se regresa a un estado consistente 
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            //cerramos siempre la sesion
            session.close();
        }
    }

    /**
     * Regresa la lista de todos los usuarios en la base de datos
     *
     * @return la lista que contiene a todos los usuarios de la base de datos
     */
    public List<Estudios> getExperiencia() {
        List<Estudios> result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "FROM Estudios";
            Query query = session.createQuery(hql);
            result = (List<Estudios>) query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public Estudios getExperiencia(int pk_id_estudios) {
        Estudios result = null;
        Session s = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = s.beginTransaction();
            String hql = "FROM Experiencia WHERE pk_id_estudios = :pk_id_estudios";
            Query query = s.createQuery(hql);
            query.setParameter("pk_id_estudios", pk_id_estudios);
            result = (Estudios) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            s.close();
        }
        return result;
    }
}
