package hr.fer.oop;

public class Main {
    public static void main(String[] args) {
        try {
            Parser.parseInputString("1234;12 31 2002;412.1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
