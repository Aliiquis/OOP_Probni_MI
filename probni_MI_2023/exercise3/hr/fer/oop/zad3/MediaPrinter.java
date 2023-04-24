package hr.fer.oop.zad3;

public class MediaPrinter<Media> extends PrintableList<Media> {
    @Override
    public String print() {
        StringBuilder toReturn = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            hr.fer.oop.zad3.Media media = (hr.fer.oop.zad3.Media) this.elementAt(i);
            toReturn.append(media.getTitle() + " is " + media.getLength() + " seconds long.\n");
        }
        return toReturn.toString();
    }
}
