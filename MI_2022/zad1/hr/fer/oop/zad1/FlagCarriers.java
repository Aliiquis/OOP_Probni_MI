package hr.fer.oop.zad1;

class FlagCarriers extends Airline {
    private int averageFleetOccupancy;

    public FlagCarriers(String name, String[] fleet, int averageFleetOccupancy) {
        super(name, fleet);
        this.averageFleetOccupancy = averageFleetOccupancy;
    }

    public int getAverageFleetOccupancy() {
        return averageFleetOccupancy;
    }

    public void setAverageFleetOccupancy(int averageFleetOccupancy) {
        this.averageFleetOccupancy = averageFleetOccupancy;
    }

    @Override
    public boolean availabilityOfPromotionalPrices() {
        return averageFleetOccupancy < 50;
    }

    @Override
    public String covid19Info() {
        return "Passengers are required to bring and wear medical face protective masks.";
    }
}
