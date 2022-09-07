package lpnt.com.randomimg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public RelativeLayout relativeLayout;
    public Button btnClickChange;
    public ArrayList<Integer> arrImg;
    public Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            relativeLayout = findViewById(R.id.relativeId);
            btnClickChange = findViewById(R.id.buttonId);
            aSwitch = findViewById(R.id.switchOne);

            btnClickChange.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    relativeLayout.setBackgroundResource(R.drawable.download);
                }
            });

            aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        Toast.makeText(MainActivity.this, "On", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(MainActivity.this, "Off", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }



//        for ( Integer indexs : arrImg
//             ) {
//            System.out.println(arrImg.get(indexs));
//        }
    }
}