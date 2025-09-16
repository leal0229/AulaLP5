/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Usuarios;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u11884167403
 */
public class ProdutosDAO extends AbstractDAO{

    @Override
    public void insert(Object object) {
       session.getTransaction();
       session.save(object);
       session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.getTransaction();
        session.flush();
        session.clear();
       session.update(object);
       session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.getTransaction();
         session.flush();
        session.clear();
       session.delete(object);
       session.getTransaction().commit();
    }

    @Override
    public Object list(int codigo) {
     session.beginTransaction();
     Criteria criteria = session.createCriteria(Usuarios.class);
     criteria.add(Restrictions.eq("idusuarios", codigo));
     List lista = criteria.list();
     session.getTransaction().commit();
     return lista;
    }

    @Override
    public Object listAll() {
         session.beginTransaction();
     Criteria criteria = session.createCriteria(Usuarios.class);
     List lista = criteria.list();
     session.getTransaction().commit();
     return lista;
    }
    
    
}
