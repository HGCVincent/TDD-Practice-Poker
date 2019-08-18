public class Game {
    public String play(Player player1, Player player2) {
        if (player1.getPoker().getNumber() > player2.getPoker().getNumber()){
            return player1.getName() + " win";
        }
        else {
            return player2.getName() + " win";
        }
    }
}