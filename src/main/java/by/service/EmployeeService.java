package by.service;

import by.DAO.DAOEmployee;
import by.model.Department;
import by.model.Employee;
import by.model.Role;
import by.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Роман on 01.08.2017.
 */
@Service
public class EmployeeService {
    @Autowired
    private DAOEmployee daoEmployee;
    @Transactional
    public List<Employee> listEmployee(){
        return this.daoEmployee.listEmployee();
    }
    @Transactional
    public void updateEmployee(Employee employee){
        this.daoEmployee.updateEmployee(employee);
    }
    @Transactional
    public Employee getById(int id){
        return this.daoEmployee.getById(id);
    }
    @Transactional
    public List<Department> getListDepartment(){
        return this.daoEmployee.getListDepartment();
    }
    @Transactional
    public List<Employee> getEmployeeListAdmin(){
        return this.daoEmployee.getEmployeeListAdmin();
    }
}
