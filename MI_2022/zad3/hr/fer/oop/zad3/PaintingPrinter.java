package hr.fer.oop.zad3;

public class PaintingPrinter extends MyList<Painting> implements Printable{
    @Override
    public String print() {
        StringBuilder toReturn = new StringBuilder();
        for(int i = 0; i < this.size(); i++){
            Painting p = this.elementAt(i);
            toReturn.append(p.getAuthor() + ": " + p.getName() + " painted by using " + p.getTechnique() + '\n');
        }
        return toReturn.toString();
    }
}
