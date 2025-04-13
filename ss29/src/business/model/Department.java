package business.model;

import validate.Validator;

import java.util.Scanner;

public class Department {
    private int id;
    private String name;
    private String description;
    private Boolean status;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Department(String description, int id, String name, Boolean status) {
        this.description = description;
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Department() {
    }

    public void inputData(Scanner sc) {
        System.out.println("Nhập vào tên phòng ban: ");
        this.name = Validator.ValidString(sc, 10, 100);
        System.out.println("Nhập vào mô tả phòng ban: ");
        this.description = Validator.ValidString(sc, -1, 255);
        System.out.println("Nhập vào trạng thái phòng ban: ");
        this.status = Validator.ValidBoolean(sc);
    }

    public String toString() {
        return "--------------------\nId: " + id + "\nTên phòng ban: " + name + "\nMô tả: " + description + "\nTrạng thái: " + status;
    }
}
