package task4;

public class  CharCount {
    char symbol;
    int count;

    public CharCount(char symbol, int count) {
        this.symbol = symbol;
        this.count = count;
    }

    @Override
    public String toString() {
        return symbol + " " + count;
    }
}
