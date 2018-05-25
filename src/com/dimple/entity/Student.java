package com.dimple.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Dimple on 2018/5/21/21:44
 */
@Entity
public class Student {
    private int id;
    private String name;
    private String password;
    private String sex;
    private String profession;
    private int flag;

    @Transient
    public void setFlag(int flag) {
        this.flag = flag;
    }
    @Transient
    public int getFlag() {
        return flag;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "sex", nullable = true, length = 32)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "profession", nullable = true, length = 255)
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name) &&
                Objects.equals(password, student.password) &&
                Objects.equals(sex, student.sex) &&
                Objects.equals(profession, student.profession);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, password, sex, profession);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
