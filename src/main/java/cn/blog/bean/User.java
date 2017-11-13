package cn.blog.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class User {
    @Id
    private Integer id;

    private String name;

    private String password;

    private Date birthday;

    public User() {
    }

    public User(String name, String password, Date birthday) {
        this.name = name;
        this.password = password;
        this.birthday = birthday;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}