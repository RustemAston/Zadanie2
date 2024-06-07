package simple_rest.dto;

public class UserDTO {
    private String nickname;

    private int age;

    public UserDTO(String nickname, int age) {
        this.nickname = nickname;
        this.age = age;
    }

    public UserDTO() {
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAge(int age) {
        this.age = age;
    }
}