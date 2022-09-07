package lpnt.com.imagestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    ListView lviewObject;
    ArrayList<Objectt> arrObject;
    ObjecttAdapter adapter;

    public static Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnAdd = findViewById(R.id.btnAddImage);
        lviewObject = findViewById(R.id.listViewMain);
        arrObject = new ArrayList<>();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(
                        MainActivity.this,
                        AddObjectActivity.class));
            }
        });

        database = new Database(this, "Objectt.sqlite", null, 1);

        database.queryDB("CREATE TABLE IF NOT EXISTS ObjecttTB(Id INTEGER PRIMARY KEY AUTOINCREMENT, NAME VARCHAR(250), DESCRIPTION VARCHAR(250), IMAGE BLOB)");

//        database.queryDB("INSERT INTO ObjecttTB values (null, phong, phong dep, null)");

        Cursor cursor = database.getDB("SELECT * FROM ObjecttTB");

        while (cursor.moveToNext()) {
            arrObject.add(new Objectt(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getBlob(3)
                    ));
        }

        adapter.notifyDataSetChanged();


    }
}