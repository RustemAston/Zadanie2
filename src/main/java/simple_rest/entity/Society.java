package simple_rest.entity;

import java.util.List;

public class Society {
    private int id;
    private String heading;

    private List<User> usersSociety;
    private List<Society> userList;

    public void setUserList(List<Society> userList) {
        this.userList = userList;
    }

    public List<Society> getUserList() {
        return userList;
    }

    public Society(String heading) {
        this.heading = heading;
    }

    public Society() {
    }

    public int getId() {
        return id;
    }

    public String getHeading() {
        return heading;
    }

    public List<User> getUsersSociety() {
        return usersSociety;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setUsersSociety(List<User> usersSociety) {
        this.usersSociety = usersSociety;
    }
}