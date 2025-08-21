package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player3 = new Player(3,"Masha", 10);


    @Test
    public void theSecondPlayerShouldBeStrongerAllAreRegistered() {
        Game game = new Game();

        Player player1 = new Player(1,"Nastya", 10);
        Player player2 = new Player(2,"Olya", 15);

        game.registered(player1);
        game.registered(player2);

        int expected = 2;
        int actual = game.round("Nastya", "Olya");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void theFirstPlayerShouldBeStrongerAllAreRegistered() {
        Game game = new Game();

        Player player1 = new Player(1,"Nastya", 15);
        Player player2 = new Player(2,"Olya", 10);

        game.registered(player1);
        game.registered(player2);

        int expected = 1;
        int actual = game.round("Nastya", "Olya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nobodyShouldBeStrongerAllAreRegistered() {
        Game game = new Game();

        Player player1 = new Player(1,"Nastya", 15);
        Player player2 = new Player(2,"Olya", 15);

        game.registered(player1);
        game.registered(player2);

        int expected = 0;
        int actual = game.round("Nastya", "Olya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void theFirstPlayerIsNotRegistered() {
        Game game = new Game();

        Player player2 = new Player(2,"Olya", 15);
        game.registered(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Nastya", "Olya"));
    }

    @Test
    public void theSecondPlayerIsNotRegistered() {
        Game game = new Game();

        Player player1 = new Player(1,"Nastya", 15);
        game.registered(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Nastya", "Olya"));
    }
}
