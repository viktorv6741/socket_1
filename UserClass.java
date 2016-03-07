package socket_1;

import java.io.Serializable;

public class UserClass implements Serializable {

    private String name;
    private String surName;
    private int age;

///////////////////////////////////////////////////////////////

    public UserClass(String name, String surName, int age) {
        this.name = name;
        this.age = age;
        this.surName = surName;
    }

    public UserClass() {
    }

///////////////////////////////////////////////////////////////

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

///////////////////////////////////////////////////////////////

    @Override
    public String toString() {
        return "NAME -> " + name + '\n' +
                "SURNAME -> " + surName + '\n' +
                "AGE -> " + age + '\n';
    }
}
