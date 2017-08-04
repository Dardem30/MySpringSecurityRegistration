package by.DAO;

import by.model.Employee;
import by.model.Message;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Роман on 02.08.2017.
 */
@Repository
public class DAOMessage {
    @Autowired
    private SessionFactory sessionFactory;
    public void saveMessage(Message message){
        this.sessionFactory.getCurrentSession().persist(message);
    }
    public List<Message> messageList(){
        List<Message> messageList=this.sessionFactory.getCurrentSession().createQuery("from Message ").list();
        return messageList;
    }
    public void sendMessageById(Message message){
        sessionFactory.getCurrentSession().persist(message);
    }
}
