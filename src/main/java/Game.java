import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {

    public String play(Player player1, Player player2) {
        player1.setPokerDtos(player1.getPokerDtos().stream().sorted(Comparator.comparing(PokerDto::getNumber).reversed()).collect(Collectors.toList()));
        player2.setPokerDtos(player2.getPokerDtos().stream().sorted(Comparator.comparing(PokerDto::getNumber).reversed()).collect(Collectors.toList()));
        Map<Integer,Long> map1 = player1.getPokerDtos().stream().collect(Collectors.groupingBy(PokerDto::getNumber,Collectors.counting()));
        Map<Integer,Long> map2 = player2.getPokerDtos().stream().collect(Collectors.groupingBy(PokerDto::getNumber,Collectors.counting()));
        if (map1.size() > map2.size()){
            return player2.getName() + " win";
        }
        else if (map2.size() > map2.size()){
            return player1.getName() + " win";
        }else {
            for (int i = 0; i < 5; i++) {
                if (player1.getPokerDtos().get(i).getNumber() > player2.getPokerDtos().get(i).getNumber()) {
                    return player1.getName() + " win";
                } else if (player1.getPokerDtos().get(i).getNumber() < player2.getPokerDtos().get(i).getNumber()) {
                    return player2.getName() + " win";
                }
            }
        }
        return "Equalize";
    }
}