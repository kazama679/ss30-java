package business.service.department;

import business.dao.department.DepartmentDao;
import business.dao.department.DepartmentDaoImp;
import business.model.Department;

import java.util.List;

public class DepartmentServiceImp implements DepartmentService {
    private final DepartmentDao departmentDao;
    public DepartmentServiceImp() {
        departmentDao = new DepartmentDaoImp();
    }

    @Override
    public Department findById(int id) {
        return departmentDao.findById(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public boolean add(Department department) {
        return departmentDao.add(department);
    }

    @Override
    public boolean update(Department department) {
        return departmentDao.update(department);
    }

    @Override
    public boolean delete(Department department) {
        return departmentDao.delete(department);
    }
}
