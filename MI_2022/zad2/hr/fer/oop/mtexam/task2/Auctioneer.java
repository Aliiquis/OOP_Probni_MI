package hr.fer.oop.mtexam.task2;

class Auctioneer extends Agent implements Auctionable {
    private int startingPrice;

    public Auctioneer(String name, int ID) {
        super(name, ID);
        startAuction();
    }

    public int getStartingPrice() {
        return startingPrice;
    }

    @Override
    public void startAuction() {
        this.startingPrice = (int) (Math.random() * 10) + 10;
    }

    @Override
    public String getAgentType() {
        return "auctioneer";
    }
}
