package hr.fer.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Parser {

    public static Reading parseInputString(String inputReadingString) throws ParseReadingException {
        Integer deviceId;
        LocalDate timestamp;
        StringBuilder input = new StringBuilder(inputReadingString);
        int numOfCommas = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == ',' && input.charAt(i + 1) == ' ') {
                numOfCommas++;
            }
        }
        SensorReadingValue[] sensorReadings = new SensorReadingValue[numOfCommas - 1];
        if (numOfCommas < 2) {
            throw new IncorrectReadingFormatException();
        } else {
            try {
                deviceId = Integer.parseInt(input.substring(9, input.indexOf(",")));
                input.delete(0, input.indexOf(" ") + 1);
                timestamp = Parser.parseDate(input.substring(10, input.indexOf(",")));
                input.delete(0, input.indexOf(" ") + 1);
            } catch (Exception e) {
                e.printStackTrace();
                throw new FormatException(e);
            }

            for (int i = 0; i < numOfCommas - 1; i++) {
                try {
                    String attributeName = input.substring(0, input.indexOf(":"));
                    String attributeValue;
                    if (i == numOfCommas - 2) {
                        attributeValue = input.substring(input.indexOf(":") + 1, input.length());
                    } else {
                        attributeValue = input.substring(input.indexOf(":") + 1, input.indexOf(","));
                    }
                    sensorReadings[i] = new SensorReadingValue(attributeName, attributeValue);
                } catch (Exception e) {
                    sensorReadings[i] = null;
                } finally {
                    input.delete(0, input.indexOf(" ") + 1);
                }
            }
            boolean f = true;
            for (SensorReadingValue s : sensorReadings) {
                if (s != null) f = false;
            }
            if (f) throw new ReadingsFormatException();
        }
        return new Reading(deviceId, sensorReadings, timestamp);
    }

    private static LocalDate parseDate(String dateA) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        dtf = dtf.withLocale(Locale.GERMAN);
        LocalDate date = LocalDate.parse(dateA, dtf);

        return date;
    }

}
