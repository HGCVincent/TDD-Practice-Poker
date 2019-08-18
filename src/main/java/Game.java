public class Game {
    public String play(Player player1, Player player2) {
        if (Integer.parseInt(player1.getPoker().getNumber()) > Integer.parseInt(player2.getPoker().getNumber())){
            return player1.getName() + " win";
        }
        else {
            return player2.getName() + " win";
        }
    }
}