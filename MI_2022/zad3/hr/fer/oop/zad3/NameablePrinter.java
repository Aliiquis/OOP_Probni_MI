package hr.fer.oop.zad3;

public class NameablePrinter<T extends Artwork & Nameable> extends MyList<T> implements Printable{
    @Override
    public String print() {
        StringBuilder toReturn = new StringBuilder();
        for(int i = 0; i < this.size(); i++){
            T element = this.elementAt(i);
            toReturn.append(element.getAuthor() + ": " + element.getName() + '\n');
        }
        return toReturn.toString();
    }
}
