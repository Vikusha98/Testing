import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.TicTacToe;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TicTacToeTest {

    @BeforeEach
    public void setup() {
        TicTacToe ticTacToe = new TicTacToe();
    }

    @Test
    public void testMove_validInput_success() {
        char[][] game = new char[3][3];
        TicTacToe.move(game, 'X');
        Assertions.assertEquals('X', game[0][0]);
    }

    @Test
    public void testMove_invalidInput_retry() {
        char[][] game = new char[3][3];

         //если неправильно вводим
        String input = "-1\n-1\n0\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        TicTacToe.move(game, 'X');
       Assertions.assertEquals('X', game[0][0]);
    }

    @Test
    public void testCheckWin_horizontalWin_returnTrue() {
        char[][] game = {
                {'X', 'X', 'X'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        };
        Assertions.assertTrue(TicTacToe.checkWin(game, 'X'));
    }

    @Test
    public void testCheckWin_verticalWin_returnTrue() {
        char[][] game = {
                {'O', '_', '_'},
                {'O', '_', '_'},
                {'O', '_', '_'}
        };
        Assertions.assertTrue(TicTacToe.checkWin(game, 'O'));
    }

    @Test
    public void testCheckWin_diagonalWin_returnTrue() {
        char[][] game = {
                {'_', '_', 'X'},
                {'_', 'X', '_'},
                {'X', '_', '_'}
        };
        Assertions.assertTrue(TicTacToe.checkWin(game, 'X'));
    }

    @Test
    public void testCheckDraw_notFullBoard_returnFalse() {
        char[][] game = {
                {'X', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        };
        Assertions.assertFalse(TicTacToe.checkDraw(game));
    }

    @Test
    public void testCheckDraw_fullBoard_returnTrue() {
        char[][] game = {
                {'X', 'O', 'X'},
                {'X', 'O', 'O'},
                {'O', 'X', 'X'}
        };
        Assertions.assertTrue(TicTacToe.checkDraw(game));
    }
}