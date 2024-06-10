package simple_rest.entity;

import java.util.List;

public class User {
    private int id;
    private String nickname;
    private int age;

    private List<Advertise> owner;
    private List<Society> societyList;

    public List<Society> getSocietyList() {
        return societyList;
    }

    public User(String nickname, int age) {
        this.nickname = nickname;
        this.age = age;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public List<Advertise> getOwner() {
        return owner;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOwner(List<Advertise> owner) {
        this.owner = owner;
    }

    public void setSocietyList(List<Society> societyList) {
        this.societyList = societyList;
    }
}
