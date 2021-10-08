package id.ac.umn.sfxlibrary_40027;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Button btnProfile = findViewById(R.id.btn_main_profile);
        Button btnLibrary = findViewById(R.id.btn_main_library);

        btnProfile.setOnClickListener(v -> {
            Intent profileIntent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(profileIntent);
        });
        btnLibrary.setOnClickListener(v -> {
            Intent libraryIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(libraryIntent);
        });
    }
}