package validate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validator {
        public static int ValidInt(Scanner sc, int min) {
            while(true){
                try {
                    int n = Integer.parseInt(sc.nextLine());
                    if(n<=min){
                        System.out.println("Phải lớn hơn "+min);
                        continue;
                    }
                    return n;
                } catch (NumberFormatException e1) {
                    System.out.println("Không phải số, nhập lại");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public static float ValidFloat(Scanner sc, float min) {
            while(true){
                try {
                    float n = Float.parseFloat(sc.nextLine());
                    if(n<=min){
                        System.out.println("Phải lớn hơn "+min);
                        continue;
                    }
                    return n;
                } catch (NumberFormatException e1) {
                    System.out.println("Không phải số thực, nhập lại");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public static Boolean ValidBoolean(Scanner sc) {
            while(true){
                try {
                    String b = sc.nextLine();
                    if(b.equals("true")||b.equals("false")||b.isEmpty()){
                        return Boolean.parseBoolean(b);
                    }
                    throw new Exception("Không đúng định dạng kiểu Boolean, nhập lại");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public static String ValidString(Scanner sc, int min, int max) {
            while(true){
                try {
                    String s = sc.nextLine();
                    if(s.length()<min||s.length()>max){
                        throw new Exception("Không đúng định dạng chuỗi, nhập lại");
                    }
                    return s;
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public static String ValidEmail(Scanner sc) {
            while(true){
                try {
                    System.out.println("Nhập vào email: ");
                    String email = sc.nextLine();
                    if(!email.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,6})+$")){
                        throw new Exception("Không đúng định dạng email, nhập lại");
                    }
                    return email;
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public static String ValidPhone(Scanner sc) {
            while(true){
                try {
                    System.out.println("Nhập vào số điện thoại Việt Nam: ");
                    String phone = sc.nextLine();
                    if(!phone.matches("^(03[2-9]|05[2689]|07[0-9]|08[1-9]|09[0-9])\\d{7}$")){
                        throw new Exception("Không đúng định dạng số điện thoại Việt Nam, nhập lại");
                    }
                    return phone;
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    public static LocalDate validDate(Scanner sc) {
        while(true){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                return LocalDate.parse(sc.nextLine(), formatter);
            }catch (DateTimeParseException e1) {
                System.out.println("Định dạng date k đúng, nhập lại");
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
