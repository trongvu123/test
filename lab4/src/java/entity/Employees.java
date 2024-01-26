/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import dao.*;

/**
 *
 * @author Admin
 */
public class Employees {
//    create table Employees (
// id int not null primary key
// ,first nvarchar (255)
// ,last nvarchar (255)
// ,age int not null
//)
    private int id;
    private String first ;
    private String lastString;
    private int age ;

    public Employees() {
    }

    public Employees(int id, String first, String lastString, int age) {
        this.id = id;
        this.first = first;
        this.lastString = lastString;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLastString() {
        return lastString;
    }

    public void setLastString(String lastString) {
        this.lastString = lastString;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employees{" + "id=" + id + ", first=" + first + ", lastString=" + lastString + ", age=" + age + '}';
    }
    
}
