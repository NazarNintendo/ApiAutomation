import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;
import java.io.IOException;


public class TrelloTests {
    private String boardID;
    private String cardID;

    //________CARD TESTS_________
    @Test(priority = 1)
    public void checkCreateCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

        Card card = new Card("A new card");
        Card createdCard = retrofitBuilder.getTrelloApi().createCard(card).execute().body();

        Assert.assertEquals(createdCard.getName(), card.getName());

        cardID = createdCard.getId();
    }

    @Test(priority = 2)
    public void checkUpdateCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

        Card card = new Card("An updated card");
        card.setId(cardID);
        Card updatedCard = retrofitBuilder.getTrelloApi().updateCard(card.getId(), card).execute().body();

        Assert.assertEquals(updatedCard.getName(), card.getName());
    }

    @Test(priority = 3)
    public void checkGetCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

        Card card = new Card("");
        int code = retrofitBuilder.getTrelloApi().getCard(cardID, card.getKey(), card.getToken()).execute().code();

        Assert.assertEquals(code, 200);
    }

    @Test(priority = 4)
    public void checkDeleteCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

        Card card = new Card("");
        Response<Card> cardResponse = retrofitBuilder.getTrelloApi().deleteCard(cardID, card.getKey(), card.getToken()).execute();

        Assert.assertEquals(cardResponse.code(), 200);
    }





    //________BOARD TESTS_________
    /*@Test(priority = 1)
    public void checkCreateBoard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

        Board board = new Board();
        String name = "New board";

        Board createdBoard = retrofitBuilder.getTrelloApi().createBoard(board, name).execute().body();

        boardID = createdBoard.getId();

        Assert.assertEquals(createdBoard.getName(), name);
    }

    @Test(priority = 2)
    public void checkUpdateBoard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Board board = new Board();
        String updatedName = "Updated board name";
        board.setName(updatedName);

        Board updatedBoard = retrofitBuilder.getTrelloApi().updateBoard(board, boardID).execute().body();

        Assert.assertEquals(updatedBoard.getName(), updatedName);
    }

    @Test(priority = 3)
    public void checkDeleteBoard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

        Board board = new Board();

        int code = retrofitBuilder.getTrelloApi().deleteBoard(boardID, board.getKey(), board.getToken()).execute().code();
        Assert.assertEquals(200, code);
    }
    */

}
