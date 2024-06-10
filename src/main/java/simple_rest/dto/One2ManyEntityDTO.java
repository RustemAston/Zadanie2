package simple_rest.dto;

public class One2ManyEntityDTO {
    private String nickname;
    private int age;
    private String title;

    public One2ManyEntityDTO() {
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public String getTitle() {
        return title;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}