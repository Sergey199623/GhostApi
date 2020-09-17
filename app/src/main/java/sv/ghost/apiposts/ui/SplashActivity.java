package sv.ghost.apiposts.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import sv.ghost.apiposts.control.SplashControl;
import sv.ghost.apiposts.model.GhostResponsePost;
import sv.ghost.apiposts.utils.Constants;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SplashControl control = new SplashControl(this);
        control.ghost();
    }

    public void nextToFeed(GhostResponsePost responsePost){
        Intent intent = new Intent(this, FeedPostsActivity.class);
        intent.putExtra(Constants.POST_INTENT,responsePost);
        startActivity(intent);
        finish();
        overridePendingTransition(0,0);
    }

    public void nextToError(){
        Intent intent = new Intent(this, ErrorActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(0,0);
    }
}
