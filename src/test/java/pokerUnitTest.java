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

        Game game = new Game(player1,player2);
        String result = game.play();
        assertEquals("player1 win",result);
    }

    //2
    @Test
    public void should_return_player2_win_when_player1_vs_player2_given_3C_AD() {
        Poker poker1 = new Poker("3","C");
        Poker poker2 = new Poker("A", "D");

        Player player1 = new Player("player1",poker1);
        Player player2 = new Player("player2",poker2);

        Game game = new Game(player1,player2);
        String result = game.play();
        assertEquals("player2 win",result);
    }

    //3
    @Test
    public void should_return_player1_win_when_player1_vs_player2_given_2H_3D_8S_9C_KD_vs_2H_3D_5S_9C_KD() {
        Player player1 = new Player("player1", new Poker("2","H"), new Poker("3","D"), new Poker("8","S"),
                new Poker("9","C"),new Poker("K","D"));

        Player player2 = new Player("player2", new Poker("2","H"), new Poker("3","D"), new Poker("5","S"),
                new Poker("9","C"), new Poker("K","D"));

        Game game = new Game(player1,player2);
        String result = game.play();

        assertEquals("player1 win",result);
    }

    //4
    @Test
    public void should_return_player2_win_when_player1_vs_player2_given_2H_3D_8S_9C_KD_vs_3H_3D_5S_9C_KD() {
        Player player1 = new Player("player1", new Poker("2","H"), new Poker("3","D"), new Poker("8","S"),
                new Poker("9","C"),new Poker("K","D"));

        Player player2 = new Player("player2", new Poker("3","H"), new Poker("3","D"), new Poker("5","S"),
                new Poker("9","C"), new Poker("K","D"));

        Game game = new Game(player1,player2);
        String result = game.play();

        assertEquals("player2 win",result);
    }

    //5
    @Test
    public void should_return_player1_win_when_player1_vs_player2_given_8H_3D_8S_9C_KD_vs_3H_3D_5S_10C_KD() {
        Player player1 = new Player("player1", new Poker("8","H"), new Poker("3","D"), new Poker("8","S"),
                new Poker("9","C"),new Poker("K","D"));

        Player player2 = new Player("player2", new Poker("3","H"), new Poker("3","D"), new Poker("5","S"),
                new Poker("10","C"), new Poker("K","D"));

        Game game = new Game(player1,player2);
        String result = game.play();

        assertEquals("player1 win",result);
    }

    //6
    @Test
    public void should_return_player2_win_when_player1_vs_player2_given_8H_3D_8S_9C_KD_vs_3H_3D_5S_10C_5D() {
        Player player1 = new Player("player1", new Poker("8","H"), new Poker("3","D"), new Poker("8","S"),
                new Poker("9","C"),new Poker("K","D"));

        Player player2 = new Player("player2", new Poker("3","H"), new Poker("3","D"), new Poker("5","S"),
                new Poker("10","C"), new Poker("5","D"));

        Game game = new Game(player1,player2);
        String result = game.play();

        assertEquals("player2 win",result);
    }

    //7
    @Test
    public void should_return_player1_win_when_player1_vs_player2_given_8H_3D_8S_9C_3S_vs_3H_3C_5S_10C_5D() {
        Player player1 = new Player("player1", new Poker("8","H"), new Poker("3","D"), new Poker("8","S"),
                new Poker("9","C"),new Poker("3","C"));

        Player player2 = new Player("player2", new Poker("3","H"), new Poker("3","C"), new Poker("5","S"),
                new Poker("10","C"), new Poker("5","D"));

        Game game = new Game(player1,player2);
        String result = game.play();

        assertEquals("player1 win",result);
    }

    //8
    @Test
    public void should_return_player1_win_when_player1_vs_player2_given_8H_3C_8S_9C_3S_vs_3H_3D_8S_10C_8D() {
        Player player1 = new Player("player1", new Poker("8","H"), new Poker("3","C"), new Poker("8","S"),
                new Poker("9","C"),new Poker("3","S"));

        Player player2 = new Player("player2", new Poker("3","H"), new Poker("3","D"), new Poker("8","S"),
                new Poker("10","C"), new Poker("8","D"));

        Game game = new Game(player1,player2);
        String result = game.play();

        assertEquals("player2 win",result);
    }

    //9
    @Test
    public void should_return_player1_win_when_player1_vs_player2_given_3S_3C_8S_9C_KD_vs_3H_3D_5S_10C_KD() {
        Player player1 = new Player("player1", new Poker("3","S"), new Poker("3","C"), new Poker("8","S"),
                new Poker("9","C"),new Poker("K","D"));

        Player player2 = new Player("player2", new Poker("3","H"), new Poker("3","D"), new Poker("5","S"),
                new Poker("10","C"), new Poker("K","D"));

        Game game = new Game(player1,player2);
        String result = game.play();

        assertEquals("player1 win",result);
    }

    //10
    @Test
    public void should_return_player1_win_when_player1_vs_player2_given_3S_5C_8S_9C_KD_vs_3H_3C_3D_10C_KD() {
        Player player1 = new Player("player1", new Poker("3","S"), new Poker("5","C"), new Poker("8","S"),
                new Poker("9","C"),new Poker("K","D"));

        Player player2 = new Player("player2", new Poker("3","H"), new Poker("3","C"), new Poker("3","D"),
                new Poker("10","C"), new Poker("K","D"));

        Game game = new Game(player1,player2);
        String result = game.play();

        assertEquals("player2 win",result);
    }

}