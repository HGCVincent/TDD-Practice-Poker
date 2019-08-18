import java.util.*;
import java.util.stream.Collectors;

public class Game {
    protected final static int HIGH_CARD = 1;
    protected final static int ONE_PAIR = 2;
    protected final static int TWO_PAIR = 3;
    protected final static int THREE_OF_A_KIND = 4;
    protected final static int STRAIGHT = 5;
    protected final static int FLUSH = 6;
    protected final static int FULL_HOUSE = 7;
    private final String P1_WIN;
    private final String P2_WIN;
    private final String EQUALIZE = "Equalize";
    private Player player1;
    private Player player2;
    private Map<Integer, Long> StatisticalPoker1 = new HashMap<>();
    private Map<Integer, Long> StatisticalPoker2 = new HashMap<>();

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        P1_WIN = player1.getName() + " win";
        P2_WIN = player2.getName() + " win";
    }

    public List<Integer> getPokerNumberByCount(Map<Integer, Long> map, int value) {
        List<Integer> keyList = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == value) {
                keyList.add(key);
            }
        }
        return keyList;
    }

    public boolean isStraight(List<Integer> pokersNumberASC){
        for (int i = 0; i < pokersNumberASC.size() - 1; i++) {
            if (pokersNumberASC.get(i+1) - pokersNumberASC.get(i) > 1){
                return false;
            }
        }
        return true;
    }

    public boolean isFlush(List<PokerDto> pokerDtos){
        for (int i = 0; i < pokerDtos.size() - 1; i++) {
            if (pokerDtos.get(i).getType() != pokerDtos.get(i + 1).getType()){
                return false;
            }
        }
        return true;
    }

    public int setPlayerLevel(Map<Integer, Long> statisticalPoker, List<PokerDto> pokerDtos) {
        int sizeAfterStatistics = statisticalPoker.size();
        switch (sizeAfterStatistics) {
            case 5:
                if (isFlush(pokerDtos)){
                    return FLUSH;
                }
                if (isStraight(getPokerNumberByCount(statisticalPoker, 1))){
                    return STRAIGHT;
                }
            case 4:
                return ONE_PAIR;
            case 3:
                if (getPokerNumberByCount(statisticalPoker, 3).size() == 0) {
                    return TWO_PAIR;
                }
                else return THREE_OF_A_KIND;
            case 2:
                return FULL_HOUSE;
        }
        return HIGH_CARD;
    }

    public String CompareHighCard(List<Integer> pokers1Number, List<Integer> pokers2Number){
        for (int i = 0; i < pokers1Number.size(); i++) {
            if (pokers1Number.get(i) > pokers2Number.get(i)) {
                return P1_WIN;
            }
            else if (pokers1Number.get(i) < pokers2Number.get(i)) {
                return P2_WIN;
            }
        }
        return EQUALIZE;
    }

    public String CompareStrategyInSameLevel(int samePokerNumberCount){
        int pairCount = getPokerNumberByCount(StatisticalPoker1, samePokerNumberCount).size();
        for (int i = 0; i < pairCount; i++) {
            int a = getPokerNumberByCount(StatisticalPoker1, samePokerNumberCount).get(i);
            int b = getPokerNumberByCount(StatisticalPoker2, samePokerNumberCount).get(i);
            if (getPokerNumberByCount(StatisticalPoker1, samePokerNumberCount).get(i) > getPokerNumberByCount(StatisticalPoker2, samePokerNumberCount).get(i)) {
                return P1_WIN;
            }
            if (getPokerNumberByCount(StatisticalPoker1, samePokerNumberCount).get(i) < getPokerNumberByCount(StatisticalPoker2, samePokerNumberCount).get(i)) {
                return P2_WIN;
            }
        }
        return CompareHighCard(getPokerNumberByCount(StatisticalPoker1, 1),getPokerNumberByCount(StatisticalPoker2, 1));
    }

    private String CompareFlush() {
        if (player1.getPokerDtos().get(0).getType() > player2.getPokerDtos().get(0).getType()){
            return P1_WIN;
        }
        if (player1.getPokerDtos().get(0).getType() < player2.getPokerDtos().get(0).getType()){
            return P2_WIN;
        }
        return EQUALIZE;
    }

    public String CompareWhenSameLevel(int playerLevel){
        switch (playerLevel){
            case FULL_HOUSE:
            case THREE_OF_A_KIND:
                return CompareStrategyInSameLevel(3);
            case FLUSH:
                return CompareFlush();
            case TWO_PAIR:
            case ONE_PAIR:
                return CompareStrategyInSameLevel(2);
            case HIGH_CARD:
                return CompareHighCard(getPokerNumberByCount(StatisticalPoker1, 1),getPokerNumberByCount(StatisticalPoker2, 1));
        }
        return EQUALIZE;
    }


    public String play() {
        player1.setPokerDtos(player1.getPokerDtos().stream().sorted(Comparator.comparing(PokerDto::getNumber).reversed()).collect(Collectors.toList()));
        player2.setPokerDtos(player2.getPokerDtos().stream().sorted(Comparator.comparing(PokerDto::getNumber).reversed()).collect(Collectors.toList()));
        StatisticalPoker1 = player1.getPokerDtos().stream().collect(Collectors.groupingBy(PokerDto::getNumber, Collectors.counting()));
        StatisticalPoker2 = player2.getPokerDtos().stream().collect(Collectors.groupingBy(PokerDto::getNumber, Collectors.counting()));

        int levelP1 = setPlayerLevel(StatisticalPoker1, player1.getPokerDtos());
        int levelP2 = setPlayerLevel(StatisticalPoker2, player2.getPokerDtos());

        if (levelP1 > levelP2) {
            return P1_WIN;
        }
        if (levelP1 < levelP2) {
            return P2_WIN;
        }
        return CompareWhenSameLevel(levelP1);
    }

}