package hr.fer.oop;

public class Main {
    public static void main(String[] args) {
        try {
            Parser.parseInputString("deviceId:123, timestamp:01-02-2000, a:, a:, a:");
        } catch (Exception e) {
            System.out.println("bacena " + e);
        }
    }
}
