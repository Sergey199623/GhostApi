package sv.ghostapiposts.get;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sv.ghostapiposts.model.GhostResponsePage;
import sv.ghostapiposts.model.GhostResponsePost;
import sv.ghostapiposts.utils.Constants;

public class GhostGetter {

    public static Call<GhostResponsePost> posts(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.GHOST_BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GhostService service = retrofit.create(GhostService.class);
        return service.posts(Constants.GHOST_KEY,"tags");
    }


    public static Call<GhostResponsePage> pages(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.GHOST_BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GhostService service = retrofit.create(GhostService.class);
        return service.pages(Constants.GHOST_KEY,"tags");
    }
}
