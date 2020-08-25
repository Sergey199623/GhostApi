package sv.ghostapiposts.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import tk.ursusexmachina.ghosapiposts.R;

public class ErrorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onButton() {
        Intent intent = new Intent(this, ErrorActivity.class);
        startActivity(intent);
        finish();
    }
}
