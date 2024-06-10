package simple_rest.entity;

public class Many2ManyEntity {
    private int user_id;
    private String nickname;
    private int age;
    private int society_id;
    private String heading;

    public Many2ManyEntity() {
    }

    public int getUser_id() {
        return user_id;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public int getSociety_id() {
        return society_id;
    }

    public String getHeading() {
        return heading;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSociety_id(int society_id) {
        this.society_id = society_id;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }
}