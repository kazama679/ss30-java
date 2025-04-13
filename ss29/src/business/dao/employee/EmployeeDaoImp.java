package business.dao.employee;

import business.config.ConnectionDB;
import business.model.Employee;
import business.model.Gender;
import business.model.Status;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImp implements EmployeeDao {
    @Override
    public Employee findById(String id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Employee employee = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_employee_by_id(?)}");
            callSt.setString(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                employee = new Employee();
                employee.setId(rs.getString("emp_id"));
                employee.setName(rs.getString("emp_name"));
                employee.setEmail(rs.getString("emp_email"));
                employee.setPhone(rs.getString("emp_phone"));
                employee.setSex(Gender.valueOf(rs.getString("emp_gender").toUpperCase()));
                employee.setSalaryLevel(rs.getInt("emp_salary_level"));
                employee.setSalary(rs.getFloat("emp_salary"));
                employee.setBirthday(LocalDate.parse(rs.getString("emp_birthday")));
                employee.setAddress(rs.getString("emp_address"));
                employee.setStatus(Status.valueOf(rs.getString("emp_status").toUpperCase()));
                employee.setIdDep(rs.getInt("emp_id_dep"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call display_employee()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getString("emp_id"));
                employee.setName(rs.getString("emp_name"));
                employee.setEmail(rs.getString("emp_email"));
                employee.setPhone(rs.getString("emp_phone"));
                employee.setSex(Gender.valueOf(rs.getString("emp_gender").toUpperCase()));
                employee.setSalaryLevel(rs.getInt("emp_salary_level"));
                employee.setSalary(rs.getFloat("emp_salary"));
                employee.setBirthday(LocalDate.parse(rs.getString("emp_birthday")));
                employee.setAddress(rs.getString("emp_address"));
                employee.setStatus(Status.valueOf(rs.getString("emp_status").toUpperCase()));
                employee.setIdDep(rs.getInt("emp_id_dep"));
                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return list;
    }

    @Override
    public boolean add(Employee employee) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_employee(?,?,?,?,?,?,?,?,?,?,?)}");
            callSt.setString(1, employee.getId());
            callSt.setString(2, employee.getName());
            callSt.setString(3, employee.getEmail());
            callSt.setString(4, employee.getPhone());
            callSt.setString(5, employee.getSex().toString());
            callSt.setInt(6, employee.getSalaryLevel());
            callSt.setFloat(7, employee.getSalary());
            callSt.setString(8, employee.getBirthday().toString());
            callSt.setString(9, employee.getAddress());
            callSt.setString(10, employee.getStatus().toString());
            callSt.setInt(11, employee.getIdDep());
            int result = callSt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean update(Employee employee) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_employee(?,?,?,?,?,?,?,?,?,?,?)}");
            callSt.setString(1, employee.getId());
            callSt.setString(2, employee.getName());
            callSt.setString(3, employee.getEmail());
            callSt.setString(4, employee.getPhone());
            callSt.setString(5, employee.getSex().toString());
            callSt.setInt(6, employee.getSalaryLevel());
            callSt.setFloat(7, employee.getSalary());
            callSt.setString(8, employee.getBirthday().toString());
            callSt.setString(9, employee.getAddress());
            callSt.setString(10, employee.getStatus().toString());
            callSt.setInt(11, employee.getIdDep());
            int result = callSt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean delete(Employee employee) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_employee(?)}");
            callSt.setString(1, employee.getId());
            int result = callSt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }
}