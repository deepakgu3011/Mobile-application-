package com.example.game;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
    private EditText numInput;
    private Button checkButton;
    private TextView resultText;
    private int computerNumber;
    private Button restartButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numInput = findViewById(R.id.num1);
        checkButton = findViewById(R.id.cr);
        resultText = findViewById(R.id.result);
        restartButton = findViewById(R.id.restartButton);
        generateComputerNumber();
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame();
            }
        });
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewGame();
            }
        });
    }
    private void startNewGame() {
        numInput.setText("");
        resultText.setText("Result");
        generateComputerNumber();
    }
    private void generateComputerNumber() {
        Random random = new Random();
        computerNumber = random.nextInt(100) + 1;
    }
    private void playGame() {
        String userInput = numInput.getText().toString();
        if (!userInput.isEmpty()) {
            int userNumber = Integer.parseInt(userInput);
            if (userNumber == computerNumber) {
                resultText.setText("Congratulations! You guessed the number!");
            } else if (userNumber > computerNumber) {
                resultText.setText("Too large! Try a smaller number.");
            } else {
                resultText.setText("Too small! Try a larger number.");
            }
        }
    }
}
