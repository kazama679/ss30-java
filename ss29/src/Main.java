import presentation.DashBoardUI;
import presentation.DepartmentUI;
import presentation.EmployeeUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Nhập tài khoản: ");
            String input = scanner.nextLine();
            System.out.println("Nhập mật khẩu: ");
            String password = scanner.nextLine();
            if(input.equals("admin") && password.equals("admin")){
                System.out.println("Đăng nhập thành công");
                int choice;
                do{
                    System.out.println("*****************MENU CHÍNH****************");
                    System.out.println("1. Quản ản lý phòng ban");
                    System.out.println("2. Quản ản lý nhân viên");
                    System.out.println("3. Thống kê");
                    System.out.println("4. Đăng xuất");
                    System.out.println("5. Thoát");
                    System.out.println("Lựa chọn của bạn: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch(choice){
                        case 1:
                            DepartmentUI.displayDepartment(scanner);
                            break;
                        case 2:
                            EmployeeUI.displayEmployee(scanner);
                            break;
                        case 3:
                            DashBoardUI.displayDashBoard(scanner);
                            break;
                        case 4:
                            System.out.println("Đăng xuất thành công");
                            break;
                        case 5:
                            System.out.println("Thoát chương trình");
                            System.exit(0);
                        default:
                            System.out.println("Chọn từ 1-4");
                    }
                }while(choice!=4);
            }
            if(!(input.equals("admin") && password.equals("admin"))){
                System.out.println("Tài khoản hoặc mật khẩu không chính xác!");
            }
        }
    }
}
