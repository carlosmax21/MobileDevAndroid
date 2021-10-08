package id.ac.umn.uts_34638;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AudioDetail extends AppCompatActivity {
    private TextView tvAudioTitle;
    private TextView tvAudioCategory;
    private String AudioUri;
    private Button btnPlay;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_detail);

        tvAudioTitle = findViewById(R.id.tvJudul);
        tvAudioCategory = findViewById(R.id.tvKeterangan);
        btnPlay = findViewById(R.id.playBtn);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        AudioItem audio = (AudioItem) bundle.getSerializable("detilAudio");

        this.getSupportActionBar().setTitle(audio.getTitle());

        tvAudioTitle.setText(audio.getTitle());
        tvAudioCategory.setText(audio.getCategory());
        AudioUri = audio.getAudioURI();
    }

    public void playAudio (View v){
        if(player == null){
            player = MediaPlayer.create(this, Uri.parse(AudioUri));
        }
        player.start();
    }

    public void onBackPressed(){
        super.onBackPressed();
        if(player!=null && player.isPlaying()){
            player.stop();
            player.release();
            player=null;
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if(player!=null && player.isPlaying()){
                    player.stop();
                    player.release();
                    player=null;
                    finish();
                }
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
