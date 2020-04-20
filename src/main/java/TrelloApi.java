import retrofit2.Call;
import retrofit2.http.*;

public interface TrelloApi {
    @POST("/1/boards/")
    Call<Board> createBoard(@Body Board board, @Query("name") String name);

    @PUT("/1/boards/{id}")
    Call<Board> updateBoard(@Body Board board, @Path("id") String id);

    @DELETE("/1/boards/{id}")
    Call<Board> deleteBoard(@Path("id") String id, @Query("key") String key, @Query("token") String token);

    @POST("/1/cards")
    Call<Card> createCard(@Body Card card);

    @PUT("/1/cards/{id}")
    Call<Card> updateCard(@Path("id") String id, @Body Card card);

    @GET("/1/cards/{id}")
    Call<Card> getCard(@Path("id") String id, @Query("key") String key, @Query("token") String token);

    @DELETE("/1/cards/{id}")
    Call<Card> deleteCard(@Path("id") String id, @Query("key") String key, @Query("token") String token);
}
