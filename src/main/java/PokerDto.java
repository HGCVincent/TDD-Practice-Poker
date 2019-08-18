public class PokerDto {
    private int number;
    private int type;

    public PokerDto(Poker poker) {
        switch (poker.getNumber()){
            case "A":
                this.number = 14;
                break;
            case "J":
                this.number = 11;
                break;
            case "Q":
                this.number = 12;
                break;
            case "K":
                this.number = 13;
                break;
            default:
                this.number = Integer.parseInt(poker.getNumber());
                break;
        }
        switch (poker.getType()){
            case "D":
                this.type = 1;
                break;
            case "C":
                this.type = 2;
                break;
            case "H":
                this.type = 3;
                break;
            case "S":
                this.type = 4;
                break;
        }
    }

    public int getNumber() {
        return number;
    }

    public int getType() {
        return type;
    }
}