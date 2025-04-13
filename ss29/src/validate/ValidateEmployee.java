package validate;

import business.model.Gender;
import business.model.Status;

import java.util.Scanner;

public class ValidateEmployee {
    public static String validId(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine();
                if(!input.matches("^E\\w{4}$")) {
                    System.out.println("Id không hợp lệ");
                    continue;
                }
                if(false){
                    System.out.println("Id không được trùng");
                }
                return input;
            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        }
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
                System.out.print("Nhập giới tính (ACTIVE, INACTIVE, ONLEAVE, POLICYLEAVE): ");
                String input = scanner.nextLine().trim().toUpperCase();
                Status status = Status.valueOf(input);
                return status;
            } catch (IllegalArgumentException e) {
                System.err.println("Giới tính không hợp lệ. Chỉ được nhập: ACTIVE, INACTIVE, ONLEAVE, POLICYLEAVE.");
            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        }
    }
}
