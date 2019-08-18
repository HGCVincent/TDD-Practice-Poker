import java.util.Comparator;
import java.util.stream.Collectors;

public class Game {
    public String play(Player player1, Player player2) {
        player1.setPokerDtos(player1.getPokerDtos().stream().sorted(Comparator.comparing(PokerDto::getNumber).reversed()).collect(Collectors.toList()));
        player2.setPokerDtos(player2.getPokerDtos().stream().sorted(Comparator.comparing(PokerDto::getNumber).reversed()).collect(Collectors.toList()));
        for (int i = 0; i < 5; i++){
            if (player1.getPokerDtos().get(i).getNumber() > player2.getPokerDtos().get(i).getNumber()){
                return player1.getName() + " win";
            }
            else if (player1.getPokerDtos().get(i).getNumber() < player2.getPokerDtos().get(i).getNumber()){
                return player2.getName() + " win";
            }
        }
        return "Equalize";
    }
}