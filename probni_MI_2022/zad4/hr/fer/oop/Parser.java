package hr.fer.oop;

public class Parser {
    public static User parseInputString(String input) throws Exception {
        String[] args = input.split("/");
        if (args.length != 4) throw new InvalidNumberOfArgumentsException("Exception occured!");
        Double OIB;
        String ime, prezime;
        String type;
        ServiceType serviceType;
        try {
            OIB = Double.valueOf(args[0]);
        } catch (Exception e) {
            throw new ArgumentParseException(e);
        }
        try {
            ime = args[1];
            prezime = args[2];
            type = args[3];
        } catch (Exception e) {
            throw new ArgumentParseException("Exception occured!");
        }
        if (ime.equals("") || prezime.equals("") || type.equals("")) {
            throw new ArgumentParseException("Exception occured!");
        }
        switch (type) {
            case "A" -> serviceType = ServiceType.SUBSCRIBE;
            case "B" -> serviceType = ServiceType.PREPAID;
            case "C" -> serviceType = ServiceType.VIRTUAL;
            default -> throw new ArgumentParseException("Exception occured!");
        }
        return new User(OIB, ime, prezime, serviceType);
    }
}
