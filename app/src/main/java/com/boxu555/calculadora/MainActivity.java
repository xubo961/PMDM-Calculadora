package com.boxu555.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.udojava.evalex.Expression;


import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView inputDisplay, outputDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonMasMenos = findViewById(R.id.buttonOso);
        Button buttonPunto = findViewById(R.id.buttonPunto);
        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        Button buttonMultiplicar = findViewById(R.id.buttonMultiplicar);
        Button buttonDividir = findViewById(R.id.buttonDividir);
        Button buttonSumar = findViewById(R.id.buttonSumar);
        Button buttonRestar = findViewById(R.id.buttonRestar);
        Button buttonCE = findViewById(R.id.buttonCE);
        Button buttonC = findViewById(R.id.buttonC);
        Button buttonDelete = findViewById(R.id.buttonDelete);

        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(button0);
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);
        buttons.add(buttonPunto);
        buttons.add(buttonMultiplicar);
        buttons.add(buttonDividir);
        buttons.add(buttonSumar);
        buttons.add(buttonRestar);


        TextView pantalla = findViewById(R.id.pantalla);
        pantalla.setText("");

        for (Button button: buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String textoPantalla = pantalla.getText().toString();
                    textoPantalla += button.getText().toString();
                    pantalla.setText(textoPantalla);
                }
            });
        }

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String delete = pantalla.getText().toString();
                delete = delete.substring(0, delete.length()-1);
                pantalla.setText(delete);
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pantalla.setText("");
            }
        });

        buttonCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pantalla.setText("");
            }
        });

        buttonMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantallaT = pantalla.getText().toString();

                if (!pantallaT.isEmpty()) {
                    if (!pantallaT.contains(" * ")) {
                        pantalla.setText(pantallaT + " * ");
                    }
                }
            }
        });

        buttonDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantallaT = pantalla.getText().toString();

                if (!pantallaT.isEmpty()) {
                    if (!pantallaT.contains(" / ")) {
                        pantalla.setText(pantallaT + " / ");
                    }
                }
            }
        });

        buttonSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantallaT = pantalla.getText().toString();

                if (!pantallaT.isEmpty()) {
                    if (!pantallaT.contains(" + ")) {
                        pantalla.setText(pantallaT + " + ");
                    }
                }
            }
        });

        buttonRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantallaT = pantalla.getText().toString();

                if (!pantallaT.isEmpty()) {
                    if (!pantallaT.contains(" - ")) {
                        pantalla.setText(pantallaT + " - ");
                    }
                }
            }
        });

        buttonPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantallaT = pantalla.getText().toString();

                if (!pantallaT.isEmpty()) {
                    if (!pantallaT.contains(" . ")) {
                        pantalla.setText(pantallaT + " . ");
                    }
                }
            }
        });

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String calculo = pantalla.getText().toString();

                try {
                    Expression expression = new Expression(calculo);
                    double resltado = expression.eval().doubleValue();

                    pantalla.setText(resltado+"");
                } catch (Exception e) {
                    pantalla.setText("Error");
                }
            }
        });
















    }
}
