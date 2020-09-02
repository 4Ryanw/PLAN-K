package bean;

/**
 * 反馈信息实体类
 */
public class Info {
    private String name;
    private String photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Info(String name, String photo) {
        this.name = name;
        this.photo = photo;
    }
}
