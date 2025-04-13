package business.dao.department;

import business.dao.AppDao;
import business.model.Department;

public interface DepartmentDao extends AppDao<Department> {
    Department findById(int id);
}
