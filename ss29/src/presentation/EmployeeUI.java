package presentation;

import business.model.Employee;
import business.model.Status;
import business.service.employee.EmployeeService;
import business.service.employee.EmployeeServiceImp;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmployeeUI {
    private static final EmployeeService employeeService = new EmployeeServiceImp();

    public static void displayEmployee(Scanner scanner) {
        do {
            System.out.println("*************** EMPLOYEE MANAGEMENT ***************");
            System.out.println("1. Danh sách nhân viên");
            System.out.println("2. Thêm mới nhân viên");
            System.out.println("3. Cập nhật trạng thái nhân viên (ACTIVE/INACTIVE)");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Tìm kiếm nhân viên theo tên");
            System.out.println("6. Sắp xếp theo lương giảm dần");
            System.out.println("7. Sắp xếp theo Tên nhân viên tăng dần");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    displayAllEmployees();
                    break;
                case 2:
                    addEmployee(scanner);
                    break;
                case 3:
                    displayAllEmployees();
                    updateEmployeeStatus(scanner);
                    break;
                case 4:
                    displayAllEmployees();
                    deleteEmployee(scanner);
                    break;
                case 5:
                    searchEmployeeByName(scanner);
                    break;
                case 6:
                    sortEmployeesBySalaryDescending();
                    break;
                case 7:
                    sortEmployeesByNameAscending();
                    break;
                case 8:
                    System.out.println("Thoát khỏi chương trình.");
                    return;
                default:
                    System.err.println("Vui lòng chọn từ 1-9");
            }
        } while (true);
    }

    private static void displayAllEmployees() {
        List<Employee> employees = employeeService.findAll();
        if (employees.isEmpty()) {
            System.out.println("Không có nhân viên nào trong hệ thống.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    private static void addEmployee(Scanner scanner) {
        Employee employee = new Employee();
        employee.inputData(scanner);
        if (employeeService.add(employee)) {
            System.out.println("Thêm mới nhân viên thành công.");
        } else {
            System.out.println("Thêm mới nhân viên thất bại.");
        }
    }

    private static void updateEmployeeStatus(Scanner scanner) {
        String id = inputEmployeeId(scanner);
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            employee.setStatus(employee.getStatus() == Status.ACTIVE ? Status.INACTIVE : Status.ACTIVE);
            if (employeeService.update(employee)) {
                System.out.println("Cập nhật trạng thái thành công!");
            } else {
                System.out.println("Cập nhật trạng thái thất bại!");
            }
        } else {
            System.out.println("Không tìm thấy nhân viên!");
        }
    }

    private static void deleteEmployee(Scanner scanner) {
        String employeeId = inputEmployeeId(scanner);
        Employee employee = employeeService.findById(employeeId);
        if (employee != null) {
            if (employeeService.delete(employee)) {
                System.out.println("Xóa nhân viên thành công.");
            } else {
                System.out.println("Xóa nhân viên thất bại.");
            }
        } else {
            System.out.println("Nhân viên không tồn tại.");
        }
    }

    private static void searchEmployeeByName(Scanner scanner) {
        System.out.print("Nhập tên nhân viên cần tìm: ");
        String name = scanner.nextLine();
        List<Employee> employees = employeeService.findAll();
        boolean found = false;
        for (Employee employee : employees) {
            if (employee.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(employee);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy nhân viên nào với tên này.");
        }
    }

    private static void sortEmployeesBySalaryDescending() {
        List<Employee> employees = employeeService.findAll().stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());

        if (employees.isEmpty()) {
            System.out.println("Không có nhân viên nào để sắp xếp.");
        } else {
            employees.forEach(System.out::println);
        }
    }

    private static void sortEmployeesByNameAscending() {
        List<Employee> employees = employeeService.findAll().stream()
                .sorted((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()))
                .collect(Collectors.toList());

        if (employees.isEmpty()) {
            System.out.println("Không có nhân viên nào để sắp xếp.");
        } else {
            employees.forEach(System.out::println);
        }
    }

    private static String inputEmployeeId(Scanner scanner) {
        System.out.print("Nhập mã nhân viên: ");
        return scanner.nextLine();
    }
}