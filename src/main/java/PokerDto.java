public class PokerDto {
    private int number;
    private String type;

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
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }
}