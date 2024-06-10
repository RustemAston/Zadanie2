package simple_rest.dto;

public class Many2ManyEntityDTO {
    private String nickname;
    private int age;
    private String heading;

    public Many2ManyEntityDTO() {
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public String getHeading() {
        return heading;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }
}