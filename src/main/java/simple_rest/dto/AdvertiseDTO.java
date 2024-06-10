package simple_rest.dto;

public class AdvertiseDTO {
    private String title;

    public AdvertiseDTO(String title) {
        this.title = title;
    }

    public AdvertiseDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}