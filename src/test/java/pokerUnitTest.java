import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class pokerUnitTest {
    //1
    @Test
    public void should_return_player1_win_when_player1_vs_player2_given_3c_2d() {
        Poker poker1 = new Poker("3","C");
        Poker poker2 = new Poker("2", "D");

        Player player1 = new Player("player1",poker1);
        Player player2 = new Player("player2",poker2);

        Game game = new Game();
        String result = game.play(player1,player2);
        assertEquals("player1 win",result);
    }

    //2
    @Test
    public void should_return_player2_win_when_player1_vs_player2_given_3C_AD() {
        Poker poker1 = new Poker("3","C");
        Poker poker2 = new Poker("A", "D");

        Player player1 = new Player("player1",poker1);
        Player player2 = new Player("player2",poker2);

        Game game = new Game();
        String result = game.play(player1,player2);
        assertEquals("player2 win",result);
    }
}