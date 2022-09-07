package lpnt.com.random_number;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public TextView txtContent;

    public Button btnClick;

    public EditText numberRd1;

    public EditText numberRd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadVariable();

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int getNb1 = Integer.parseInt(numberRd1.getText().toString());
                    int getNb2 = Integer.parseInt(numberRd2.getText().toString());

                    Random rd = new Random();
                    int rdNumber = rd.nextInt((getNb2 - getNb1 + 1) + getNb1);

                    txtContent.setText(String.valueOf(rdNumber));
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Loi gồi, nhập lại", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void loadVariable() {
        txtContent = findViewById(R.id.textViewId);
        numberRd1 = findViewById(R.id.numberRd1);
        numberRd2 = findViewById(R.id.numberRd2);
        btnClick = findViewById(R.id.buttonId);
    }
}