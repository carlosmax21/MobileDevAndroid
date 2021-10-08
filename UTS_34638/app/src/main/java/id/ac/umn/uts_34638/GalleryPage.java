package id.ac.umn.uts_34638;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.LinkedList;

public class GalleryPage extends AppCompatActivity {
    String titleName;
    RecyclerView rvDaftarAudio;
    AudioGalleryAdapter mAdapter;
    LinkedList<AudioItem> audioGallery = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_page);

        Intent loginInt = getIntent();
        titleName = loginInt.getStringExtra("loginName");
        getSupportActionBar().setTitle(titleName);
        Toast.makeText(this, "Selamat datang " + titleName, Toast.LENGTH_SHORT).show();

        inputAudio();
        rvDaftarAudio= findViewById(R.id.recyclerView);
        mAdapter = new AudioGalleryAdapter(this, audioGallery);
        rvDaftarAudio.setAdapter(mAdapter);
        rvDaftarAudio.setLayoutManager(new LinearLayoutManager(this));
    }

    private void inputAudio(){
        audioGallery.add(new AudioItem("Chotto Mate Kudasai", "song", "android.resource://"+ getPackageName() + "/" + R.raw.audio1 ));
        audioGallery.add(new AudioItem("Bakamitai", "yakuza ost", "android.resource://"+ getPackageName() + "/" + R.raw.audio2 ));
        audioGallery.add(new AudioItem("Roblox Death Sound", "Roblox", "android.resource://"+ getPackageName() + "/" + R.raw.audio3 ));
        audioGallery.add(new AudioItem("We'll be right back", "meme", "android.resource://"+ getPackageName() + "/" + R.raw.audio4 ));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profileMenu:
                Intent intentProfile = new Intent(GalleryPage.this, ProfilePage.class);
                startActivity(intentProfile);
                return true;
            case R.id.homeMenu:
                Intent intentHome = new Intent(GalleryPage.this, MainActivity.class);
                startActivity(intentHome);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}