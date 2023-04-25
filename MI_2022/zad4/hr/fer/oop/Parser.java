package hr.fer.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Parser {

    public static Reading parseInputString(String input) throws ParseReadingException {
        Boolean version = null;
        for (char c : input.toCharArray()) {
            if (c == ',') {
                version = true;
                break;
            }
            if (c == ';') {
                version = false;
                break;
            }
        }
        if (version == null) throw new ReadingFormatException();

        Integer serialNumber;
        LocalDate timestamp;
        Double readingValue;

        String[] args;
        if (version) {
            args = input.split(", ");
            if (args.length != 3) throw new IncorrectArgumentNumberException();
            try {
                serialNumber = Integer.parseInt(args[0].substring(args[0].indexOf(": ") + 2));
                timestamp = Parser.parseDateForManufacturerA(args[1].substring(args[1].indexOf(": ") + 2));
                readingValue = Double.parseDouble(args[2].substring(args[2].indexOf(": ") + 2, args[2].length() - 1));
            } catch (Exception e) {
                throw new ReadingFormatException(e);
            }
        } else {
            args = input.split(";");
            if (args.length != 3) throw new IncorrectArgumentNumberException();
            try {
                serialNumber = Integer.parseInt(args[0]);
                timestamp = Parser.parseDateForManufacturerB(args[1]);
                readingValue = Double.parseDouble(args[2]);
            } catch (Exception e) {
                throw new ReadingFormatException(e);
            }
        }
        return new Reading(serialNumber, readingValue, timestamp);
    }

    private static LocalDate parseDateForManufacturerA(String dateA) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        dtf = dtf.withLocale(Locale.GERMAN);
        LocalDate date = LocalDate.parse(dateA, dtf);

        return date;
    }

    private static LocalDate parseDateForManufacturerB(String dateB) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM dd yyyy");
        dtf = dtf.withLocale(Locale.GERMAN);
        LocalDate date = LocalDate.parse(dateB, dtf);

        return date;
    }

}
