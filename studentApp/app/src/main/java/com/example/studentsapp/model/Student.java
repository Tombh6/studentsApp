package com.example.studentsapp.model;

public class Student {
    String name = "";
    String id = "";
    boolean flag = false;

    public Student(){}
    public Student(String name, String id, boolean flag) {
        this.name = name;
        this.id = id;
        this.flag = flag;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isFlag() {
        return flag;
    }
}
