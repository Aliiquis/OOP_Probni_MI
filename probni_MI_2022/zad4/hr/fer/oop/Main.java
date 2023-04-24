package hr.fer.oop;

public class Main {
    public static void main(String[] args) {
        try {
            Parser.parseInputString("12345/pero/peric/A");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
