import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    protected final static int HIGH_CARD = 1;
    protected final static int ONE_PAIR = 2;

    public String play(Player player1, Player player2) {
        int levelP1 = HIGH_CARD;
        int levelP2 = HIGH_CARD;
        player1.setPokerDtos(player1.getPokerDtos().stream().sorted(Comparator.comparing(PokerDto::getNumber).reversed()).collect(Collectors.toList()));
        player2.setPokerDtos(player2.getPokerDtos().stream().sorted(Comparator.comparing(PokerDto::getNumber).reversed()).collect(Collectors.toList()));
        Map<Integer,Long> map1 = player1.getPokerDtos().stream().collect(Collectors.groupingBy(PokerDto::getNumber,Collectors.counting()));
        Map<Integer,Long> map2 = player2.getPokerDtos().stream().collect(Collectors.groupingBy(PokerDto::getNumber,Collectors.counting()));

        if (map1.size() < player1.getPokerDtos().size()){
            levelP1 = ONE_PAIR;
        }
        if (map2.size() < player2.getPokerDtos().size()){
            levelP2 = ONE_PAIR;
        }
        if (levelP1 > levelP2){
            return player1.getName() + " win";
        }
        else if (levelP1 < levelP2){
            return player2.getName() + " win";
        }
        else{
            if (levelP1 == ONE_PAIR && levelP2 == ONE_PAIR){
                return getPairNumberStatistics(map1,2).get(0) > getPairNumberStatistics(map2, 2).get(0) ? (player1.getName() + " win") :  (player2.getName() + " win");
            }
            if (levelP1 == HIGH_CARD && levelP2 == HIGH_CARD){
                for (int i = 0; i < 5; i++) {
                    if (player1.getPokerDtos().get(i).getNumber() > player2.getPokerDtos().get(i).getNumber()) {
                        return player1.getName() + " win";
                    } else if (player1.getPokerDtos().get(i).getNumber() < player2.getPokerDtos().get(i).getNumber()) {
                        return player2.getName() + " win";
                    }
                }
            }
        }
        return "Equalize";
    }

    public List<Integer> getPairNumberStatistics(Map<Integer,Long> map, int value){
        List<Integer> keyList = new ArrayList<>();
        for(Integer key: map.keySet()){
            if(map.get(key) == value){
                keyList.add(key);
            }
        }
        return keyList;
    }


}