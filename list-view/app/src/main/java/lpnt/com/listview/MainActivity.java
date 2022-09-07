package lpnt.com.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ListView listViewId;
    public ArrayList<String> arrayList;
    public Button btnAdd, btnEdit, btnDelete;
    public EditText txtContent;
    public int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewId = findViewById(R.id.listViewId);
        btnAdd = findViewById(R.id.buttonOne);
        btnEdit = findViewById(R.id.buttonTwo);
        btnDelete = findViewById(R.id.buttonThree);
        txtContent = findViewById(R.id.editTextId);


        arrayList = new ArrayList<>();

        arrayList.add("IOS");
        arrayList.add("Python");
        arrayList.add("Android");

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);

        listViewId.setAdapter(arrayAdapter);

        listViewId.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txtContent.setText(arrayList.get(i));
                index = i;
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = txtContent.getText().toString();
                arrayList.set(index, content);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.remove(index);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = txtContent.getText().toString();
                arrayList.add(content);
                arrayAdapter.notifyDataSetChanged();
            }
        });


    }
}