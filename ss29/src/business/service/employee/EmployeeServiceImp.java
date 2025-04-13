package business.service.employee;

import business.dao.employee.EmployeeDao;
import business.dao.employee.EmployeeDaoImp;
import business.model.Employee;

import java.util.List;

public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeServiceImp() {
        this.employeeDao = new EmployeeDaoImp();
    }

    @Override
    public Employee findById(String id) {
        return employeeDao.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public boolean add(Employee employee) {
        return employeeDao.add(employee);
    }

    @Override
    public boolean update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public boolean delete(Employee employee) {
        return employeeDao.delete(employee);
    }
}