package id.ac.umn.sfxlibrary_40027;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    private MediaPlayer mpSfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        SfxSource sfx = (SfxSource) bundle.getSerializable("DetailSFX");

        Objects.requireNonNull(getSupportActionBar()).setTitle(sfx.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mpSfx = MediaPlayer.create(this, sfx.getUri());

        TextView tvTitle = findViewById(R.id.tv_detail_title);
        TextView tvCategory = findViewById(R.id.tv_detail_category);
        Button btnPlay = findViewById(R.id.btn_detail_play);

        tvTitle.setText(sfx.getTitle());
        tvCategory.setText(sfx.getCategory());
        btnPlay.setOnClickListener(v -> mpSfx.start());
    }

    @Override
    protected void onPause() {
        super.onPause();
        mpSfx.stop();
        mpSfx.release();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
