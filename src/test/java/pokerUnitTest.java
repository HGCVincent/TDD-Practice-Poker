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

    //11
    @Test
    public void should_return_player1_win_when_player1_vs_player2_given_4S_4C_4D_9C_KD_vs_3H_3C_3D_10C_KD() {
        Player player1 = new Player("player1", new Poker("4","S"), new Poker("4","C"), new Poker("4","D"),
                new Poker("9","C"),new Poker("K","D"));

        Player player2 = new Player("player2", new Poker("3","H"), new Poker("3","C"), new Poker("3","D"),
                new Poker("10","C"), new Poker("K","D"));

        Game game = new Game(player1,player2);
        String result = game.play();

        assertEquals("player1 win",result);
    }

    //12
    @Test
    public void should_return_player2_win_when_player1_vs_player2_given_4S_4C_4D_9C_KD_vs_2H_3C_4D_5C_6D() {
        Player player1 = new Player("player1", new Poker("4","S"), new Poker("4","C"), new Poker("4","D"),
                new Poker("9","C"),new Poker("K","D"));

        Player player2 = new Player("player2", new Poker("3","H"), new Poker("2","C"), new Poker("4","D"),
                new Poker("5","C"), new Poker("6","D"));

        Game game = new Game(player1,player2);
        String result = game.play();

        assertEquals("player2 win",result);
    }

    //13
    @Test
    public void should_return_player1_win_when_player1_vs_player2_given_4H_7H_9H_10H_QH_vs_2H_3C_4D_5C_6D() {
        Player player1 = new Player("player1", new Poker("4","H"), new Poker("7","H"), new Poker("9","H"),
                new Poker("10","H"),new Poker("Q","H"));

        Player player2 = new Player("player2", new Poker("3","H"), new Poker("2","C"), new Poker("4","D"),
                new Poker("5","C"), new Poker("6","D"));

        Game game = new Game(player1,player2);
        String result = game.play();

        assertEquals("player1 win",result);
    }

    //14
    @Test
    public void should_return_player1_win_when_player1_vs_player2_given_4H_7H_9H_10H_QH_vs_2S_3S_4S_5S_6S() {
        Player player1 = new Player("player1", new Poker("4","H"), new Poker("7","H"), new Poker("9","H"),
                new Poker("10","H"),new Poker("Q","H"));

        Player player2 = new Player("player2", new Poker("4","S"), new Poker("7","S"), new Poker("9","S"),
                new Poker("10","S"),new Poker("Q","S"));

        Game game = new Game(player1,player2);
        String result = game.play();

        assertEquals("player2 win",result);
    }

    //15
    @Test
    public void should_return_player1_win_when_player1_vs_player2_given_4H_4D_4S_10H_10D_vs_2S_3S_4S_5S_6S() {
        Player player1 = new Player("player1", new Poker("4","H"), new Poker("4","D"), new Poker("4","S"),
                new Poker("10","H"),new Poker("10","D"));

        Player player2 = new Player("player2", new Poker("4","S"), new Poker("7","S"), new Poker("9","S"),
                new Poker("10","S"),new Poker("Q","S"));

        Game game = new Game(player1,player2);
        String result = game.play();

        assertEquals("player1 win",result);
    }

    //16
    @Test
    public void should_return_player1_win_when_player1_vs_player2_given_4H_4D_4S_10H_10D_vs_5H_5D_5S_10S_10C() {
        Player player1 = new Player("player1", new Poker("4","H"), new Poker("4","D"), new Poker("4","S"),
                new Poker("10","H"),new Poker("10","D"));

        Player player2 = new Player("player2", new Poker("5","H"), new Poker("5","D"), new Poker("5","S"),
                new Poker("10","S"),new Poker("10","C"));

        Game game = new Game(player1,player2);
        String result = game.play();

        assertEquals("player2 win",result);
    }
}