package itis.q32.entities;

public class Group {

    private String title;
    private Long id;
    private String code;


    public Group(String title, Long id, String code) {
        this.title = title;
        this.id = id;
        this.code = code;
    }

    public Group() {
    }

    @Override
    public String toString() {
        return "Group{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", course='" + code + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
