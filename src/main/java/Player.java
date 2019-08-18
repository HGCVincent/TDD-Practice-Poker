public class Player {
    String name;
    Poker poker;

    public Player(String name, Poker poker) {
        this.name = name;
        this.poker = poker;
    }

    public String getName() {
        return name;
    }

    public Poker getPoker() {
        return poker;
    }
}