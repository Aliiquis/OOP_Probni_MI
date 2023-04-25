package hr.fer.oop.mtexam.task2;

class Wallet {
    private Token[] tokens;

    public Wallet(int count) {
        this.tokens = count < 1 ? new Token[1] : new Token[count];
    }

    public int getCount() {
        return tokens.length;
    }

    public Token[] getTokens() {
        return tokens;
    }

    public void setToken(Token token, int index) {
        if (index >= 0 && index < tokens.length) tokens[index] = token;
    }

    public void printWallet() {
        for (Token t : tokens) {
            if (t != null) {
                if (t instanceof Exchangable) {
                    Cryptocurrency c = (Cryptocurrency) t;
                    System.out.println(c + " equals " + c.getExchangeRate() * c.getAmount() + " EUR, token type: " + t.getTokenType());
                } else {
                    NFT n = (NFT) t;
                    System.out.println(n + ", token type: " + n.getTokenType());
                }
            }
        }
    }
}
