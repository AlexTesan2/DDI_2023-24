package com.in28minutes.springboot.rest.example.springboot2jdbcwithh2;

public class student {
    private long id;
    private String name;
    private String passportnumber;

    public student() {
        super();
    }

    public student(long id, String name, String passportnumber) {
        super();
        this.id = id;
        this.name = name;
        this.passportnumber = passportnumber;
    }

    public student(String name, String passportnumber) {
        super();
        this.name = name;
        this.passportnumber = passportnumber;
    }

    public long getid() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getpassportnumber() {
        return passportnumber;
    }

    public void setpassportnumber(String passportnumber) {
        this.passportnumber = passportnumber;
    }

    @Override
    public String toString() {
        return String.format("student [id=%s, name=%s, passportnumber=%s]", id, name, passportnumber);
    }

}

