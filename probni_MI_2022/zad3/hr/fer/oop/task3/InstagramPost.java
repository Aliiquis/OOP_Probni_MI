package hr.fer.oop.task3;

public class InstagramPost<T extends Post> extends WebEntry<T> {
    public InstagramPost(String author, String date, T entry) {
        super(author, date, entry);
    }

    public double calculatePostImpact(int likes) {
        return (double) this.getEntry().getNumberOfLikes() / likes;
    }
}
