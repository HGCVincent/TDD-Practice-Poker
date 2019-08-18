import java.util.*;
import java.util.stream.Collectors;

public class Game {
    protected final static int HIGH_CARD = 1;
    protected final static int ONE_PAIR = 2;
    protected final static int TWO_PAIR = 3;
    protected final static int THREE_OF_A_KIND = 4;
    protected final static int STRAIGHT = 5;
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

    public int setPlayerLevel(Map<Integer, Long> statisticalPoker) {
        int sizeAfterStatistics = statisticalPoker.size();
        switch (sizeAfterStatistics) {
            case 5:
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

    public String CompareOnePairOrTwoPairOrTreeOfAKind(int smaePokerNumberCount){
        int pairCount = getPokerNumberByCount(StatisticalPoker1, smaePokerNumberCount).size();
        for (int i = 0; i < pairCount; i++) {
            if (getPokerNumberByCount(StatisticalPoker1, smaePokerNumberCount).get(i) > getPokerNumberByCount(StatisticalPoker2, smaePokerNumberCount).get(i)) {
                return P1_WIN;
            }
            if (getPokerNumberByCount(StatisticalPoker1, smaePokerNumberCount).get(i) > getPokerNumberByCount(StatisticalPoker2, smaePokerNumberCount).get(i)) {
                return P2_WIN;
            }
        }
        return CompareHighCard(getPokerNumberByCount(StatisticalPoker1, 1),getPokerNumberByCount(StatisticalPoker2, 1));
    }


    public String CompareWhenSameLevel(int playerLevel){
        switch (playerLevel){
            case THREE_OF_A_KIND:
                return CompareOnePairOrTwoPairOrTreeOfAKind(3);
            case TWO_PAIR:
            case ONE_PAIR:
                return CompareOnePairOrTwoPairOrTreeOfAKind(2);
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

        int levelP1 = setPlayerLevel(StatisticalPoker1);
        int levelP2 = setPlayerLevel(StatisticalPoker2);

        if (levelP1 > levelP2) {
            return P1_WIN;
        }
        if (levelP1 < levelP2) {
            return P2_WIN;
        }
        return CompareWhenSameLevel(levelP1);
    }

}