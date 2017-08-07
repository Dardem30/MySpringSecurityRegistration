import by.model.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;

import java.util.*;

/**
 * Created by Роман on 23.07.2017.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
          session.beginTransaction();
//            List<Employee> employeeList=session.createQuery("from Employee ").list();
//            for(Employee employee: employeeList){
//                Message message=new Message();
//                message.setText("Load1");
//                message.setEmployee(employee);
//                session.save(message);
//            }
//            Message message= (Message) session.get(Message.class,1);
//            Employee employee= (Employee) session.get(Employee.class,1);
//            Message message=new Message();
//            message.setText("Sunny");
//            message.setEmployee(employee);
//            session.save(message);
//Employee employee= (Employee) session.get(Employee.class,1);
//Query query=session.createQuery("from Message where employee=:employee");
//query.setParameter("employee",employee);
//Message message= (Message) query.uniqueResult();
//            System.out.println(message.getText());
//            Message message= new Message();
//            message.setText("hello222");
//            List<Employee> employeeList=session.createQuery("from Employee ").list();
//            for(Employee employee: employeeList) {
//            Employee employee= (Employee) session.get(Employee.class,1);
//            Employee employee1= (Employee) session.get(Employee.class,4);
//                message.setEmployee(employee);
//                message.setEmployee(employee1);
//                session.saveOrUpdate(message);
//            for(Message message1:employee.getMessageSet()){
//                System.out.println(message1.getText());
//            }
//            }
//            Role role= (Role) session.get(Role.class,1);
//            Set<Role> roleSet=new HashSet<>();
//            roleSet.add(role);
////            List<User> userList=session.createQuery("from User where roles=:roles").setParameterList("roles",roleSet).list();
////            System.out.println(userList);
//            Criteria criteria=session.createCriteria(User.class);
//            criteria.add(Restrictions.like("roles",roleSet));
//            List<User> userList=criteria.list();
//            System.out.println(userList);
            ///////////////////////////////////////////////////////////////////////////////////////
//            List<User> userList1=session.createQuery("from User ").list();
//            for(User user: userList1){
//                for(Role role1: user.getRoles()){
//                    if((role1.getName()).equals("ROLE_ADMIN")){
//                        System.out.println(user.getUsername());
//                    }else {
//                        System.out.println("user");
//                    }
//                }
//            }
            /////////////////////////////////////////////////////////////////////////////////////////
//            List<User> userList2=session.createQuery("from User ").list();
//            List<Employee> employeeList=new ArrayList<>();
//            for(User user: userList2){
//                for(Role role1: user.getRoles()){
//                    if((role1.getName()).equals("ROLE_ADMIN")){
//                       employeeList.add(user.getEmployee());
//
//                    }else {
//                        System.out.println("user");
//                    }
//                }
//            }
//            System.out.println(employeeList);
 session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}