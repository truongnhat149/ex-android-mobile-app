package lpnt.com.processapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public TextView textViewTest;
    public Button onClickMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTest = findViewById(R.id.editTextTest);



        onClickMe = findViewById(R.id.buttonOnClick);

        onClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textContent = textViewTest.getText().toString();

                Toast.makeText(MainActivity.this, textContent, Toast.LENGTH_LONG).show();
            }
        });
    }
}