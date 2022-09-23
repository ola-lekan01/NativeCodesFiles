package Diary;


import java.time.LocalDate;

public class Entry {
    private String title;
    private String body;
    private final String Id;
    private final LocalDate localDate;

    public Entry(String Id, String title, String body, LocalDate localDate) {
        this.Id = Id;
        this.title = title;
        this.body = body;
        this.localDate = localDate;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void addTitle(String title) {
        this.title = title;
    }

    public void addBody(String body) {
        this.body = body;
    }

    public String getId() {
        return Id;
    }
    public void Update(String title, String body) {
        addBody(body);
        addTitle(title);
    }

    public LocalDate getDate() {
        return localDate;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", Id='" + Id + '\'' +
                ", localDate=" + localDate +
                '}';
    }
}
