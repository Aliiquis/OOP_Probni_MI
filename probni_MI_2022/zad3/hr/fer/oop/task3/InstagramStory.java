package hr.fer.oop.task3;

public class InstagramStory extends WebEntry<Story> {
    public InstagramStory(String author, String date, Story entry) {
        super(author, date, entry);
    }

    public double calculateStoryImpact(int followers) {
        return (double) (this.getEntry().getNumberOfViews() + this.getEntry().getNumberOfReactions()) / followers;
    }
}
