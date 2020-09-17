package sv.ghost.apiposts.ui;

import android.os.Bundle;
import android.view.Display;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import sv.ghost.apiposts.R;
import sv.ghost.apiposts.model.GhostPost;
import sv.ghost.apiposts.utils.Constants;

public class DetailsPostActivity extends AppCompatActivity {
    GhostPost post;
    @BindView(R.id.web)
    WebView web;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(Constants.POSTS_BUNDLE, post);
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        ButterKnife.bind(this);
        if (savedInstanceState != null)
            post = savedInstanceState.getParcelable(Constants.POSTS_BUNDLE);
        else
            post = getIntent().getParcelableExtra(Constants.POST_INTENT);

        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();

        String pish = "<html><head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><style type=\"text/css\">@font-face {font-family: MyFont;src: url(\"file:///android_asset/source_regular.ttf\")}body {font-family: MyFont;font-size: medium;text-align: justify;}</style></head><body>";
        String pas = "</body></html>";
        String html = pish +post.html + pas;



        //Glide.with(this).load(post.featureImage).into(postImage);
        web.getSettings().setDomStorageEnabled(true);
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setLoadWithOverviewMode(true);
        web.getSettings().setUseWideViewPort(true);

        web.loadDataWithBaseURL(null,html, "text/html", "UTF-8", null);

    }
}
