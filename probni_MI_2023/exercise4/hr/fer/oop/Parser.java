package hr.fer.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Parser {

    public static Reading parseInputString(String inputReadingString) throws ParseReadingException {
        String[] args = inputReadingString.split(", ");
        if (args.length < 3) throw new IncorrectReadingFormatException();

        Integer deviceId;
        LocalDate timestamp;
        SensorReadingValue[] sensorReadings = new SensorReadingValue[args.length - 2];

        try {
            deviceId = Integer.parseInt(args[0].substring(args[0].indexOf(":") + 1));
            timestamp = Parser.parseDate(args[1].substring(args[1].indexOf(":") + 1));
        } catch (Exception e) {
            throw new FormatException(e);
        }

        for (int i = 0; i < sensorReadings.length; i++) {
            try {
                String readingName = args[i + 2].substring(0, args[i + 2].indexOf(":"));
                String readingValue = args[i + 2].substring(args[i + 2].indexOf(":") + 1);
                sensorReadings[i] = new SensorReadingValue(readingName, readingValue);
            } catch (Exception e) {
                sensorReadings[i] = null;
            }
        }
        boolean notNull = false;
        for (SensorReadingValue readingValue : sensorReadings) {
            if (readingValue != null) {
                notNull = true;
                break;
            }
        }
        if (!notNull) throw new ReadingsFormatException();
        return new Reading(deviceId, sensorReadings, timestamp);
    }

    private static LocalDate parseDate(String dateA) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        dtf = dtf.withLocale(Locale.GERMAN);
        LocalDate date = LocalDate.parse(dateA, dtf);
        return date;
    }
}
