package hr.fer.oop.mtexam.task2;

class Cryptocurrency extends Token implements Exchangable {
    private double exchangeRate;
    private CryptocurrencyType type;

    public Cryptocurrency(double amount, CryptocurrencyType type) {
        super(amount, String.valueOf(type));
        this.type = type;
        switch (type) {
            case BTC -> this.exchangeRate = (int) (Math.random() * 500) + 40400;
            case ETH -> this.exchangeRate = (int) (Math.random() * 100) + 2900;
        }
    }

    public CryptocurrencyType getType() {
        return type;
    }

    public void setType(CryptocurrencyType type) {
        this.type = type;
    }

    @Override
    public String getTokenType() {
        return "Cryptocurrency";
    }

    @Override
    public double getExchangeRate() {
        return exchangeRate;
    }

    @Override
    public String toString() {
        return String.format("%.4f %s", this.getAmount(), this.type);
    }
}
