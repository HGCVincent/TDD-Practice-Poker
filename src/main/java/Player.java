public class Player {
    String name;
    PokerDto poker;

    public Player(String name, Poker poker) {
        this.name = name;
        this.poker =new PokerDto(poker);
    }

    public String getName() {
        return name;
    }

    public PokerDto getPoker() {
        return poker;
    }
}