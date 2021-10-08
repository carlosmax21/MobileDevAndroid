package id.ac.umn.uts_34638;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button profileBtn, libraryBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        profileBtn = findViewById(R.id.profileBtn);
        libraryBtn = findViewById(R.id.libraryBtn);

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileInt = new Intent(MainActivity.this, ProfilePage.class);
                startActivity(profileInt);
            }
        });

        libraryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent libraryInt = new Intent(MainActivity.this, LoginPage.class);
                startActivity(libraryInt);
            }
        });
    }
}