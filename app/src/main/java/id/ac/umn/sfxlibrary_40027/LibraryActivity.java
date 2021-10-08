package id.ac.umn.sfxlibrary_40027;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class LibraryActivity extends AppCompatActivity {
    private final ArrayList<SfxSource> sfxList = new ArrayList<>();
    public static final String EXTRA_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        String username = getIntent().getStringExtra(EXTRA_USERNAME);
        Objects.requireNonNull(getSupportActionBar()).setTitle(username);

        Toast.makeText(this, "Selamat datang, " + username, Toast.LENGTH_SHORT).show();

        seedSfxList();

        SfxAdapter mAdapter = new SfxAdapter(this, sfxList);
        RecyclerView rvLibraryList = findViewById(R.id.rv_library_list);
        rvLibraryList.setAdapter(mAdapter);
        rvLibraryList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_library, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setOption(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setOption(int selectedOption) {
        if (selectedOption == R.id.action_profile) {
            Intent profileIntent = new Intent(LibraryActivity.this, ProfileActivity.class);
            startActivity(profileIntent);
        } else {
            Intent mainIntent = new Intent(LibraryActivity.this, MainActivity.class);
            startActivity(mainIntent);
        }
    }

    private void seedSfxList() {
        sfxList.add(new SfxSource("Nico Nico Ni", "Anime", R.raw.nico_nico_ni));
        sfxList.add(new SfxSource("Coffin Dance", "Meme", R.raw.coffin_dance));
        sfxList.add(new SfxSource("Sad Violin", "Meme", R.raw.sad_violin));
        sfxList.add(new SfxSource("Tuturu", "Anime", R.raw.tuturu));
    }
}
