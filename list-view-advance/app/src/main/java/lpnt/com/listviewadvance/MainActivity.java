package lpnt.com.listviewadvance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Fruit> fruitArrayList;
    FruitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        adapter = new FruitAdapter(this, R.layout.line_fruit, fruitArrayList);

        listView.setAdapter(adapter);
    }

    private void mapping() {
        listView = findViewById(R.id.listViewIDMain);

        fruitArrayList = new ArrayList<>();

        fruitArrayList.add(new Fruit(R.drawable.frui1, "Fruit A", "Yummy"));
        fruitArrayList.add(new Fruit(R.drawable.fruit2, "Fruit B", "Yummy B"));
        fruitArrayList.add(new Fruit(R.drawable.fruit3, "Fruit C", "Yummy C"));


    }
}