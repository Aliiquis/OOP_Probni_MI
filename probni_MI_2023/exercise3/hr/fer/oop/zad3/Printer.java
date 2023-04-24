package hr.fer.oop.zad3;

public class Printer {
    public static <T extends Video> String printVideoList(MyList<T> myList) {
        StringBuilder toReturn = new StringBuilder();
        for (int i = 0; i < myList.size(); i++) {
            T element = myList.elementAt(i);
            toReturn.append(element.getTitle() + " - " + element.getLength() + " sec. - " + element.getFormat() + '\n');
        }
        return toReturn.toString();
    }

    public static <T extends Audio> String printAudioList(MyList<T> myList) {
        StringBuilder toReturn = new StringBuilder();
        for (int i = 0; i < myList.size(); i++) {
            T element = myList.elementAt(i);
            toReturn.append(element.getTitle() + " - " + element.getLength() + " sec. - " + element.getCodec() + '\n');
        }
        return toReturn.toString();
    }
}
