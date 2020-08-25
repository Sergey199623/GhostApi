package sv.ghostapiposts.control;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sv.ghostapiposts.get.GhostGetter;
import sv.ghostapiposts.model.GhostResponsePost;
import sv.ghostapiposts.ui.SplashActivity;

public class SplashControl implements Callback<GhostResponsePost> {
    private SplashActivity view;

    public SplashControl(SplashActivity view) {
        this.view = view;
    }

    public void ghost() {
        GhostGetter.posts().enqueue(this);
    }

    @Override
    public void onResponse(Call<GhostResponsePost> call, Response<GhostResponsePost> response) {
        if (response.isSuccessful())
            view.nextToFeed(response.body());
        else onFailure(call, new Throwable());
    }

    @Override
    public void onFailure(Call<GhostResponsePost> call, Throwable t) {

        view.nextToError();
    }
}
