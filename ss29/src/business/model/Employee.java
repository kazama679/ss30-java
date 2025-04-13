package business.model;

import validate.ValidateEmployee;
import validate.Validator;

import java.time.LocalDate;
import java.util.Scanner;

public class Employee {
    private String id;
    private String name;
    private String email;
    private String phone;
    private Gender sex;
    private int salaryLevel;
    private float salary;
    private LocalDate birthday;
    private String address;
    private Status status;
    private int idDep;

    public Employee(String address, LocalDate birthday, String email, String id, int idDep, String name, String phone, float salary, int salaryLevel, Gender sex, Status status) {
        this.address = address;
        this.birthday = birthday;
        this.email = email;
        this.id = id;
        this.idDep = idDep;
        this.name = name;
        this.phone = phone;
        this.salary = salary;
        this.salaryLevel = salaryLevel;
        this.sex = sex;
        this.status = status;
    }

    public Employee() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdDep() {
        return idDep;
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getSalaryLevel() {
        return salaryLevel;
    }

    public void setSalaryLevel(int salaryLevel) {
        this.salaryLevel = salaryLevel;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào id nhân viên: ");
        this.id = ValidateEmployee.validId(scanner);
        System.out.println("Nhập vào tên nhân viên: ");
        this.name = Validator.ValidString(scanner, 15, 150);
        this.email = Validator.ValidEmail(scanner);
        this.phone = Validator.ValidPhone(scanner);
        System.out.println("Nhập vào giới tính: ");
        this.sex = ValidateEmployee.validGender(scanner);
        System.out.println("Nhập vào bậc lương: ");
        this.salaryLevel = Validator.ValidInt(scanner, 0);
        System.out.println("Nhập vào lương: ");
        this.salary = Validator.ValidFloat(scanner,0);
        System.out.println("Nhập vào ngày sinh: ");
        this.birthday = Validator.validDate(scanner);
        System.out.println("Nhập vào địa chỉ: ");
        this.address = Validator.ValidString(scanner, 1, 255);
        System.out.println("Nhập trạng thái nhân viên: ");
        this.status = ValidateEmployee.validStatus(scanner);
        System.out.println("Nhập id phòng ban: ");
        this.idDep = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "---------------------------" +
                "\nMã nhân viên: " + id +
                "\nTên nhân viên: " + name +
                "\nEmail: " + email +
                "\nSố điện thoại: " + phone +
                "\nGiới tính: " + sex +
                "\nBậc lương: " + salaryLevel +
                "\nLương: " + salary +
                "\nNgày sinh: " + birthday +
                "\nĐịa chỉ: " + address +
                "\nTrạng thái: " + status +
                "\nPhòng ban ID: " + idDep +
                "\n---------------------------";
    }
}
