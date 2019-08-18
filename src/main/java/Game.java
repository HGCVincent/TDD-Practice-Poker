import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    protected final static int HIGH_CARD = 1;
    protected final static int ONE_PAIR = 2;
    protected final static int TWO_PAIR = 3;

    public String play(Player player1, Player player2) {
        player1.setPokerDtos(player1.getPokerDtos().stream().sorted(Comparator.comparing(PokerDto::getNumber).reversed()).collect(Collectors.toList()));
        player2.setPokerDtos(player2.getPokerDtos().stream().sorted(Comparator.comparing(PokerDto::getNumber).reversed()).collect(Collectors.toList()));
        Map<Integer,Long> StatisticalPoker1 = player1.getPokerDtos().stream().collect(Collectors.groupingBy(PokerDto::getNumber,Collectors.counting()));
        Map<Integer,Long> StatisticalPoker2 = player2.getPokerDtos().stream().collect(Collectors.groupingBy(PokerDto::getNumber,Collectors.counting()));

        int levelP1 = setPlayerLevel(StatisticalPoker1.size());
        int levelP2 = setPlayerLevel(StatisticalPoker2.size());

        if (levelP1 > levelP2){
            return player1.getName() + " win";
        }
        else if (levelP1 < levelP2){
            return player2.getName() + " win";
        }
        else{
            if (levelP1 == ONE_PAIR && levelP2 == ONE_PAIR){
                return getPairNumberStatistics(StatisticalPoker1,2).get(0) > getPairNumberStatistics(StatisticalPoker2, 2).get(0) ? (player1.getName() + " win") :  (player2.getName() + " win");
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

    public int setPlayerLevel(int sizeAfterStatistics){
        switch (sizeAfterStatistics){
            case 4:
                return ONE_PAIR;
            case 3:
                return TWO_PAIR;
            default:
                return HIGH_CARD;
        }
    }


}