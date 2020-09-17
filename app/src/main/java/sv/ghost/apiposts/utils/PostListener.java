package sv.ghost.apiposts.utils;

import sv.ghost.apiposts.model.GhostPost;

public interface PostListener {
    void onPostClicked(GhostPost post);
}
