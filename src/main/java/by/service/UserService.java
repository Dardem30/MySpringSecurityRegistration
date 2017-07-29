package by.service;

import by.DAO.DAORoleImpl;
import by.DAO.DAOUserImpl;
import by.model.Role;
import by.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Роман on 21.07.2017.
 */
@Service
public class UserService {
    private DAOUserImpl daoUser;

    public void setDaoUser(DAOUserImpl daoUser) {
        this.daoUser = daoUser;
    }
    @Autowired
    private DAORoleImpl daoRole;
    @Transactional
    public User findByUsername(String username){
        return this.daoUser.findByUsername(username);
    }
    @Transactional
    public void saveUser(User user) {
        Set<Role> roles=new HashSet<>();
        roles.add(daoRole.getRoleById(2));
        user.setRoles(roles);
    this.daoUser.saveUser(user);
    }
    }
