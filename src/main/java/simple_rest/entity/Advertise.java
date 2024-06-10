package simple_rest.entity;

public class Advertise {
    private int id;
    private String title;

    private User user;

    public Advertise(String title) {
        this.title = title;
    }

    public Advertise() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser(User user) {
        this.user = user;
    }
}