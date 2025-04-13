create database ss30;
use ss30;

create table departments(
    dep_id int auto_increment primary key,
    dep_name varchar(100) not null,
    dep_description varchar(255),
    dep_status bit
);

delimiter //
create procedure display_dep()
begin
    select * from departments;
end;

create procedure add_dep(name_in varchar(100), des_in varchar(255), status_in bit)
begin
    insert into departments(dep_name, dep_description, dep_status)
        values(name_in, des_in, status_in);
end;

create procedure update_dep(id_in int, name_in varchar(100), des_in varchar(255), status_in bit)
begin
    update departments
    set dep_name = name_in,
        dep_description = des_in,
        dep_status = status_in
    where dep_id = id_in;
end;

create procedure delete_dep(id_in int)
begin
    delete from departments where dep_id = id_in;
end;

create procedure search_dep_of_name(name_in varchar(100))
begin
    select * from departments
        where dep_name = name_in;
end;

create procedure get_dep_by_id(id_in int)
begin
    select * from departments
    where dep_id = id_in;
end;
delimiter //

create table employee(
    emp_id varchar(5) primary key not null,
    emp_name varchar(150) not null,
    emp_email varchar(255) not null,
    emp_phone varchar(10) not null,
    emp_gender varchar(10) not null,
    emp_salary_level int not null,
    emp_salary float not null,
    emp_birthday varchar(255) not null,
    emp_address varchar(255) not null,
    emp_status varchar(20) not null,
    emp_id_dep int not null,
    foreign key (emp_id_dep) references departments(dep_id)
);


delimiter //
create procedure display_employee()
begin
    select * from employee;
end //
delimiter ;

delimiter //
create procedure add_employee(
    in p_id varchar(5),
    in p_name varchar(150),
    in p_email varchar(255),
    in p_phone varchar(10),
    in p_gender varchar(10),
    in p_salary_level int,
    in p_salary float,
    in p_birthday varchar(255),
    in p_address varchar(255),
    in p_status varchar(20),
    in p_id_dep int
)
begin
    insert into employee(
        emp_id, emp_name, emp_email, emp_phone, emp_gender, emp_salary_level, emp_salary,
        emp_birthday, emp_address, emp_status, emp_id_dep
    ) values (
                 p_id, p_name, p_email, p_phone, p_gender, p_salary_level, p_salary,
                 p_birthday, p_address, p_status, p_id_dep
             );
end //
delimiter ;

delimiter //
create procedure update_employee(
    in p_id varchar(5),
    in p_name varchar(150),
    in p_email varchar(255),
    in p_phone varchar(10),
    in p_gender varchar(10),
    in p_salary_level int,
    in p_salary float,
    in p_birthday varchar(255),
    in p_address varchar(255),
    in p_status varchar(20),
    in p_id_dep int
)
begin
    update employee
    set emp_name = p_name,
        emp_email = p_email,
        emp_phone = p_phone,
        emp_gender = p_gender,
        emp_salary_level = p_salary_level,
        emp_salary = p_salary,
        emp_birthday = p_birthday,
        emp_address = p_address,
        emp_status = p_status,
        emp_id_dep = p_id_dep
    where emp_id = p_id;
end //
delimiter ;

delimiter //
create procedure delete_employee(
    in p_id varchar(5)
)
begin
    delete from employee where emp_id = p_id;
end //
delimiter ;


delimiter //
create procedure get_employee_by_id(
    in p_id varchar(5)
)
begin
    select * from employee where emp_id = p_id;
end;
delimiter //

