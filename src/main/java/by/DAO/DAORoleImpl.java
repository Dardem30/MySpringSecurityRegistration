package by.DAO;

import by.model.Role;
import org.hibernate.SessionFactory;

/**
 * Created by Роман on 23.07.2017.
 */
public class DAORoleImpl implements DAORole {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Role getRoleById(int id){
        Role role= (Role) this.sessionFactory.getCurrentSession().get(Role.class,id);
        return role;
    }
}
