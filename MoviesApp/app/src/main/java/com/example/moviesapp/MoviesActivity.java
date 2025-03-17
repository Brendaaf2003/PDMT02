package com.example.moviesapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.content.Intent;


public class MoviesActivity extends AppCompatActivity {
    private ArrayList<String> peliculas;
    private ArrayAdapter<String> adapter;
    private ListView listaPeliculas;
    private EditText edtNuevaPelicula;
    private Button btnAgregarPelicula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        peliculas = new ArrayList<>();
        peliculas.add("The Wild Robot");
        peliculas.add("Paris, Texas");
        peliculas.add("Matilda");
        peliculas.add("The VelociPastor");
        peliculas.add("Taylor Swift: The Eras Tour");


        listaPeliculas = findViewById(R.id.lista_peliculas);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, peliculas);
        listaPeliculas.setAdapter(adapter);

        edtNuevaPelicula = findViewById(R.id.edt_nueva_pelicula);
        btnAgregarPelicula = findViewById(R.id.btn_agregar_pelicula);


        btnAgregarPelicula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nuevaPelicula = edtNuevaPelicula.getText().toString().trim();

                if (!nuevaPelicula.isEmpty()) {
                    peliculas.add(nuevaPelicula);
                    adapter.notifyDataSetChanged();
                    edtNuevaPelicula.setText("");
                    Toast.makeText(MoviesActivity.this, "Película agregada: " + nuevaPelicula, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MoviesActivity.this, "Ingrese un nombre válido", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listaPeliculas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String peliculaSeleccionada = peliculas.get(position);
                Intent intent = new Intent(MoviesActivity.this, ReviewActivity.class);
                intent.putExtra("pelicula", peliculaSeleccionada);
                startActivity(intent);
            }
        });
    }
}
