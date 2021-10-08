package id.ac.umn.uts_34638;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginPage extends AppCompatActivity {

    EditText loginInput;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        this.getSupportActionBar().hide();

        loginInput = findViewById(R.id.loginInput);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loginInput.length() == 0){
                    loginInput.setError("Harap Diisi");
                }
                else{
                    Intent galleryInt = new Intent(LoginPage.this, GalleryPage.class);
                    String loginName = loginInput.getText().toString();
                    galleryInt.putExtra("loginName", loginName);
                    startActivity(galleryInt);
                }
            }
        });
    }
}