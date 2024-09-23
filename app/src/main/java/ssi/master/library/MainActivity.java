package ssi.master.library;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ssi.master.library.services.AddBookActivity;
import ssi.master.library.services.ListBookActivity;
import ssi.master.library.services.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String username = getIntent().getStringExtra("username");

        TextView tvWelcome = findViewById(R.id.tv_welcome);
        tvWelcome.setText("Welcome, " + username);

        findViewById(R.id.btn_logout).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        findViewById(R.id.btn_add_book).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddBookActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });

        findViewById(R.id.btn_list_books).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListBookActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });
    }
}
