package presentation;

import business.model.Department;
import business.model.Employee;
import business.service.department.DepartmentService;
import business.service.department.DepartmentServiceImp;
import business.service.employee.EmployeeService;
import business.service.employee.EmployeeServiceImp;

import java.util.List;
import java.util.Scanner;

public class DashBoardUI {
    private static final EmployeeService employeeService = new EmployeeServiceImp();

    public static void displayDashBoard(Scanner scanner) {
        do {
            System.out.println("***************DashBoard MANAGEMENT****************");
            System.out.println("1. Số lượng nhân viên theo từng phòng ban");
            System.out.println("2. Tổng số nhân viên của toàn bộ hệ thống");
            System.out.println("3. Phòng ban có nhiều nhân viên nhất");
            System.out.println("4. Phòng ban có lương cao nhất");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    displayTotalEmployeeCount();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Quay lại menu chính");
                    return;
                default:
                    System.err.println("Vui lòng chọn từ 1-5");
            }
        } while (true);
    }

    private static void displayTotalEmployeeCount() {
        List<Employee> employees = employeeService.findAll();
        System.out.println("Tổng số nhân viên của toàn bộ hệ thống: " + employees.size());
    }
}
