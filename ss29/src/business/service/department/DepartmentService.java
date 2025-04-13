package business.service.department;

import business.model.Department;
import business.service.AppService;

public interface DepartmentService extends AppService<Department> {
    Department findById(int id);
}
