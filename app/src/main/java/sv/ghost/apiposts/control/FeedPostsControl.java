package sv.ghost.apiposts.control;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import sv.ghost.apiposts.model.GhostPost;
import sv.ghost.apiposts.model.GhostResponsePost;
import sv.ghost.apiposts.ui.FeedPostsActivity;
import sv.ghost.apiposts.utils.Constants;

public class FeedPostsControl {
    FeedPostsActivity view;

    public FeedPostsControl(FeedPostsActivity view) {
        this.view = view;
    }

    public void restore(Bundle bundle) {
        ArrayList<GhostPost> posts = bundle.getParcelableArrayList(Constants.POSTS_BUNDLE);
        if (posts != null && posts.size() > 0)
            view.showPosts(posts);
        else view.show404();
    }

    public void open(Intent intent) {
        GhostResponsePost response = intent.getParcelableExtra(Constants.POST_INTENT);
        if (response != null && response.posts != null && response.posts.size() > 0)
            view.showPosts(response.posts);
        else view.show404();
    }
}
