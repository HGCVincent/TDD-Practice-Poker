import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    String name;
    List<PokerDto> pokerDtos = new ArrayList<>();

    public Player(String name, Poker... pokers) {
        this.name = name;
        List<Poker> pokerList = Arrays.asList(pokers);
        for (Poker poker : pokers) {
            pokerDtos.add(new PokerDto(poker));
        }
    }

    public String getName() {
        return name;
    }

    public List<PokerDto> getPokerDtos() {
        return pokerDtos;
    }

    public void setPokerDtos(List<PokerDto> pokerDtos) {
        this.pokerDtos = pokerDtos;
    }
}