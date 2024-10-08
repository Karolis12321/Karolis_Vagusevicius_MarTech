package com.example.karolisvaguseviciusmartech;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private Button buttonColor;

    // Spalvų masyvas
    private final int[] colors = {
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.YELLOW,
            Color.CYAN,
            Color.MAGENTA
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Randa komponentus pagal jų ID
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        buttonColor = findViewById(R.id.buttonColor);

        // Nustatome WindowInsets (išlaikant jūsų specifikacijas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Pridėti "OnClickListener" pirmam mygtukui
        button.setOnClickListener(v -> textView.setText("Labas, pasauli!"));

        // Pridėti "OnClickListener" antram mygtukui spalvos keitimui
        buttonColor.setOnClickListener(v -> {
            // Atsitiktinai parinkti spalvą iš masyvo
            int randomIndex = new Random().nextInt(colors.length);
            int randomColor = colors[randomIndex];
            textView.setTextColor(randomColor);
        });
    }
}