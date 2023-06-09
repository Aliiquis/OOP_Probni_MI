package hr.fer.oop.zad1;

class Cherry extends Fruit {
    private boolean hasWorm;

    public Cherry(String species, int numberOfFruits, double productionPrice, boolean hasWorm) {
        super(species, numberOfFruits, productionPrice);
        this.hasWorm = hasWorm;
    }

    public boolean isHasWorm() {
        return hasWorm;
    }

    public void setHasWorm(boolean hasWorm) {
        this.hasWorm = hasWorm;
    }

    @Override
    public double myMarketPrice() {
        return (hasWorm ? this.getProductionPrice() * 1.2 : this.getProductionPrice() * 1.5) / this.getNumberOfFruits();
    }
}
