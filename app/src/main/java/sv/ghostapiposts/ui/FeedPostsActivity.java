package sv.ghostapiposts.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import tk.ursusexmachina.ghosapiposts.R;
import sv.ghostapiposts.control.FeedPostsControl;
import sv.ghostapiposts.model.GhostPost;
import sv.ghostapiposts.utils.Constants;
import sv.ghostapiposts.utils.PostAdapter;
import sv.ghostapiposts.utils.PostListener;

public class FeedPostsActivity extends AppCompatActivity implements PostListener {
    @BindView(R.id.viewItems)
    RecyclerView viewItems;
    @BindView(R.id.view404)
    LinearLayout view404;

    FeedPostsControl control;
    ArrayList<GhostPost> posts;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(Constants.POSTS_BUNDLE,posts);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        ButterKnife.bind(this);

        control = new FeedPostsControl(this);
        if (savedInstanceState != null) control.restore(savedInstanceState);
        else control.open(getIntent());

    }

    public void showPosts(ArrayList<GhostPost> posts) {

        this.posts = posts;
        PostAdapter adapter = new PostAdapter(this.posts, this);
        viewItems.setAdapter(adapter);
        viewItems.setLayoutManager(new LinearLayoutManager(this));
    }

    public void show404() {
        view404.setVisibility(View.VISIBLE);
        viewItems.setVisibility(View.GONE);
    }

    @Override
    public void onPostClicked(GhostPost post) {
        Intent intent = new Intent(this, DetailsPostActivity.class);
        intent.putExtra(Constants.POST_INTENT,post);
        startActivity(intent);

    }
}
