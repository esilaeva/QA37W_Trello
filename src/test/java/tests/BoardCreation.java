package tests;

import model.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {


    @Test
    public void boardCreation1() {
        Board board = Board.builder().title("qa37").build();

        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillInBoardCreationForm(board);
        //  app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        //app.getBoard().isCreated();

        Assert.assertTrue(app.getBoard().isCreated());
        //app.getBoard().pause(2000);
        // app.getBoard().returnToHomePage();

        //Assert

    }

    @Test
    public void boardCreation2() {

        int boardCountBeforeCreation = app.getBoard().getBoardCount();
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillInBoardCreationForm("qa37");
        app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();
        app.getBoard().pause(2000);

        int boardCountAfterCreation = app.getBoard().getBoardCount();

        Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);


    }

    @Test
    public void boardCreation3() {
        Board board = Board.builder().title("qa37new").build();
        app.getBoard().startBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().fillInBoardCreationForm(board);
        // app.getBoard().pause(2000);
        //app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        //app.getBoard().isCreated();

        Assert.assertTrue(app.getBoard().isCreated());
    }

    @Test
    public void refuseBoardCreation() {
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().closeCreationWindow();
    }

    @Test
    public void refuseBoardCreation2() {
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().returnToCreationPage();
    }


}