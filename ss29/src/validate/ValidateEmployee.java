package validate;

import business.model.Gender;
import business.model.Status;
import business.service.employee.EmployeeService;
import business.service.employee.EmployeeServiceImp;

import java.util.Scanner;

public class ValidateEmployee {
    private static final EmployeeService employeeService = new EmployeeServiceImp();

    public static String validId(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nhập ID nhân viên: ");
                String input = scanner.nextLine();
                if (!input.matches("^E\\w{4}$")) {
                    System.out.println("ID không hợp lệ. Vui lòng nhập ID theo định dạng Exxxx.");
                    continue;
                }
                if (isEmployeeIdExists(input)) {
                    System.out.println("ID này đã tồn tại. Vui lòng nhập ID khác.");
                    continue;
                }
                return input;
            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        }
    }

    private static boolean isEmployeeIdExists(String employeeId) {
        return employeeService.findById(employeeId) != null;
    }

    public static Gender validGender(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nhập giới tính (MALE, FEMALE, OTHER): ");
                String input = scanner.nextLine().trim().toUpperCase();
                Gender gender = Gender.valueOf(input);
                return gender;
            } catch (IllegalArgumentException e) {
                System.err.println("Giới tính không hợp lệ. Chỉ được nhập: MALE, FEMALE, OTHER.");
            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        }
    }

    public static Status validStatus(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nhập trạng thái (ACTIVE, INACTIVE, ONLEAVE, POLICYLEAVE): ");
                String input = scanner.nextLine().trim().toUpperCase();
                Status status = Status.valueOf(input);
                return status;
            } catch (IllegalArgumentException e) {
                System.err.println("Trạng thái không hợp lệ. Chỉ được nhập: ACTIVE, INACTIVE, ONLEAVE, POLICYLEAVE.");
            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        }
    }
}
