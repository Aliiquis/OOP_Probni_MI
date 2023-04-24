package hr.fer.oop.task3;

public class WebEntry<T> {
    private String author;
    private String date;
    private T entry;

    public WebEntry(String author, String date, T entry) {
        this.author = author;
        this.date = date;
        this.entry = entry;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public T getEntry() {
        return entry;
    }

    public void setEntry(T entry) {
        this.entry = entry;
    }
}
