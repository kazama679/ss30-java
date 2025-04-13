package business.dao.department;

import business.config.ConnectionDB;
import business.model.Department;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImp implements DepartmentDao {
    @Override
    public Department findById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Department department = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_dep_by_id(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if(rs.next()){
                department = new Department();
                department.setId(rs.getInt("dep_id"));
                department.setName(rs.getString("dep_name"));
                department.setDescription(rs.getString("dep_description"));
                department.setStatus(rs.getBoolean("dep_status"));
            }
        } catch (SQLException e) {
            e.fillInStackTrace();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return department;
    }

    @Override
    public List<Department> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Department> listDepartments = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call display_dep()}");
            ResultSet rs = callSt.executeQuery();
            listDepartments = new ArrayList<>();
            while(rs.next()){
                Department department = new Department();
                department.setId(rs.getInt("dep_id"));
                department.setName(rs.getString("dep_name"));
                department.setDescription(rs.getString("dep_description"));
                department.setStatus(rs.getBoolean("dep_status"));
                listDepartments.add(department);
            }
        }catch (SQLException e){
            e.fillInStackTrace();
        }catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listDepartments;
    }

    @Override
    public boolean add(Department department) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_dep(?,?,?)}");
            callSt.setString(1, department.getName());
            callSt.setString(2, department.getDescription());
            callSt.setBoolean(3,department.getStatus());
            callSt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.fillInStackTrace();
        } catch (Exception e) {
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean update(Department department) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_dep(?,?,?,?)}");
            callSt.setInt(1, department.getId());
            callSt.setString(2, department.getName());
            callSt.setString(3, department.getDescription());
            callSt.setBoolean(4, department.getStatus());
            callSt.executeUpdate();
            return true;
        }catch (SQLException e){
            e.fillInStackTrace();
        }catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean delete(Department department) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_dep(?)}");
            callSt.setInt(1, department.getId());
            callSt.executeUpdate();
            return true;
        }catch (SQLException e){
            e.fillInStackTrace();
        }catch (Exception e){
            e.fillInStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }
}
