package com.dimple.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Dimple on 2018/5/21/21:44
 */
@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return id == manager.id &&
                Objects.equals(name, manager.name) &&
                Objects.equals(password, manager.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password);
    }
}
