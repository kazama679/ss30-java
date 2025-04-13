package presentation;

import business.model.Department;
import business.service.department.DepartmentService;
import business.service.department.DepartmentServiceImp;

import java.util.List;
import java.util.Scanner;

public class DepartmentUI {
    private final DepartmentService departmentService;
    public DepartmentUI() {
        departmentService = new DepartmentServiceImp();
    }

    public static void displayDepartment(Scanner scanner){
        DepartmentUI departmentUI = new DepartmentUI();
        do {
            System.out.println("***************Department MANAGEMENT****************");
            System.out.println("1. Danh sách phòng ban");
            System.out.println("2. Thêm mới phòng ban");
            System.out.println("3. Cập nhật phòng ban");
            System.out.println("4. Xóa phòng ban");
            System.out.println("5. Tìm kiếm phòng ban theo tên");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    departmentUI.displayDep();
                    break;
                case 2:
                    departmentUI.addDep(scanner);
                    break;
                case 3:
                    departmentUI.updateDep(scanner);
                    break;
                case 4:
                    departmentUI.deleteDep(scanner);
                    break;
                case 5:
                    departmentUI.searchDepByName(scanner);
                    break;
                case 6:
                    System.out.println("Quay lại menu chính");
                    return;
                default:
                    System.err.println("Vui lòng chọn từ 1-6");
            }
        } while (true);
    }

    public void displayDep(){
        List<Department> listDepartments = departmentService.findAll();
        if(listDepartments.isEmpty()){
            System.out.println("Danh sách rỗng!");
            return;
        }
        listDepartments.forEach(System.out::println);
    }

    public void addDep(Scanner scanner) {
        Department department = new Department();
        department.inputData(scanner);
        boolean result = departmentService.add(department);
        if (result) {
            System.out.println("Thêm mới thành công");
        } else {
            System.err.println("Có lỗi trong quá trình thêm mới");
        }
    }

    public void updateDep(Scanner scanner) {
        System.out.println("Nhập vào mã phòng ban cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        if(departmentService.findById(id) != null){
            Department department = new Department();
            department.setId(id);
            department.inputData(scanner);
            boolean result = departmentService.update(department);
            if (result) {
                System.out.println("Cập nhập thành công");
            }else {
                System.err.println("Có lỗi trong quá trình cập nhật");
            }
        }else {
            System.err.println("Phòng ban không tồn tại");
        }
    }

    public void deleteDep(Scanner scanner) {
        System.out.println("Nhập vào mã phòng ban cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        if(departmentService.findById(id) != null){
            Department department = new Department();
            department.setId(id);
            boolean result = departmentService.delete(department);
            if (result) {
                System.out.println("Xóa thành công");
            } else {
                System.err.println("Có lỗi trong quá trình xóa");
            }
        }else{
            System.out.println("Mã phòng ban không tồn tại");
        }
    }

    public void searchDepByName(Scanner scanner) {
        System.out.print("Nhập tên phòng ban cần tìm: ");
        String name = scanner.nextLine().trim().toLowerCase();
        List<Department> listDepartments = departmentService.findAll();
        boolean found = false;
        for (Department department : listDepartments) {
            if (department.getName().toLowerCase().contains(name)) {
                System.out.println(department);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy phòng ban nào với tên này.");
        }
    }
}
