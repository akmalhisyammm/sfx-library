package id.ac.umn.sfxlibrary_40027;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).hide();

        EditText etUsername = findViewById(R.id.et_login_username);
        Button btnNext = findViewById(R.id.btn_login_next);

        btnNext.setOnClickListener(v -> {
            String username = etUsername.getText().toString();

            if (!username.trim().isEmpty()) {
                Intent libraryIntent = new Intent(LoginActivity.this, LibraryActivity.class);
                libraryIntent.putExtra(LibraryActivity.EXTRA_USERNAME, username);
                startActivity(libraryIntent);
            } else {
                etUsername.setError("Harap diisi");
            }
        });
    }
}
