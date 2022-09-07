package lpnt.com.amzingrace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public TextView txtView;
    public ImageButton imgBtn;
    public CheckBox cbOne, cbTwo, cbThree;
    public SeekBar sbOne, sbTwo, sbThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapView();

        CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {


            @Override
            public void onTick(long l) {
                int num = 5;
                Random random = new Random();

                int nbOne = random.nextInt(num);
                int nbTwo = random.nextInt(num);
                int nbThree = random.nextInt(num);

                sbOne.setProgress(sbOne.getProgress() + nbOne);
                sbTwo.setProgress(sbTwo.getProgress() + nbTwo);
                sbThree.setProgress(sbThree.getProgress() + nbThree);


            }

            @Override
            public void onFinish() {

            }
        };

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBtn.setVisibility(View.VISIBLE);
                countDownTimer.start();
            }
        });
    }

    private void mapView() {
        txtView = findViewById(R.id.textView);

        cbOne = findViewById(R.id.checkBox);
        cbTwo = findViewById(R.id.checkBox2);
        cbThree = findViewById(R.id.checkBox3);

        sbOne = findViewById(R.id.seekBar);
        sbTwo = findViewById(R.id.seekBar2);
        sbThree = findViewById(R.id.seekBar3);

        imgBtn = findViewById(R.id.imgStart);
    }
}