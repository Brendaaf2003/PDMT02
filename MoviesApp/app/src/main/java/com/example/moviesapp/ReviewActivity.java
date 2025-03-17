package com.example.moviesapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ReviewActivity extends AppCompatActivity {
    private TextView txtPelicula;
    private RatingBar ratingBar;
    private EditText edtResena;
    private Button btnGuardarResena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        txtPelicula = findViewById(R.id.txt_pelicula);
        ratingBar = findViewById(R.id.rating_bar);
        edtResena = findViewById(R.id.edt_resena);
        btnGuardarResena = findViewById(R.id.btn_guardar_resena);


        String pelicula = getIntent().getStringExtra("pelicula");
        txtPelicula.setText("Califica: " + pelicula);

        btnGuardarResena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
