package hr.fer.oop.mtexam.task2;

class Bidder extends Agent {
    private BiddingStrategyType strategyType;

    public Bidder(String name, int ID, BiddingStrategyType strategyType) {
        super(name, ID);
        this.strategyType = strategyType;
    }

    public BiddingStrategyType getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(BiddingStrategyType type) {
        this.strategyType = type;
    }

    @Override
    public String getAgentType() {
        return "bidder";
    }
}
