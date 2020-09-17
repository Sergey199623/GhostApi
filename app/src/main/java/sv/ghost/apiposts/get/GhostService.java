package sv.ghost.apiposts.get;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import sv.ghost.apiposts.model.GhostResponsePage;
import sv.ghost.apiposts.model.GhostResponsePost;


public interface GhostService {
    @GET("content/posts")
    Call<GhostResponsePost> posts(@Query("key") String key, @Query("include") String include);

    @GET("content/pages")
    Call<GhostResponsePage> pages(@Query("key") String key, @Query("include") String include);
}
