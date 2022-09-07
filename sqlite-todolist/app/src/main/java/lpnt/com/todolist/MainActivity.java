package lpnt.com.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Database database;

    ListView lvWork;

    ArrayList<Work> arrayList;

    WorkAdapter workAdapter;

    String SELECT_SQL = "SELECT * FORM WORKS";

    String UPDATE_SQL = "UPDATE WORKS SET NAME = '' WHERE ID = ''";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new Database(this, "Note.sqlite", null, 1);

//        database.QueryData("CREATE TABLE IF NOT EXISTS WORKS(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME VARCHAR(250))");

//        database.QueryData("INSERT INTO WORKS VALUES(null, 'hoc lap trinh tai SG')");
        lvWork = findViewById(R.id.listViewMain);

        arrayList = new ArrayList<>();

        workAdapter = new WorkAdapter(this, R.layout.line_work, arrayList);

        lvWork.setAdapter(workAdapter);

      getDataWork();
    }

    private void getDataWork() {
        Cursor getDB = database.GetData("SELECT * FROM WORKS");
        arrayList.clear();
        while( getDB.moveToNext()) {
            int id = getDB.getInt(0);
            String data = getDB.getString(1);
//            Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();

            arrayList.add(new Work(id, data));

        }
        workAdapter.notifyDataSetChanged();

    }

    public void dialogDeleteWork(int id, String name) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Are you sure delete " + name +" ?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                database.QueryData("DELETE FROM WORKS WHERE id = " + id);
                Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                getDataWork();
            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
    }

    public void dialogEditWork(int id, String name) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_edit);

        Button btnEdit = dialog.findViewById(R.id.btnEdit);
        Button btnCancel = dialog.findViewById(R.id.btnCancelEdit);
        EditText editText = dialog.findViewById(R.id.txtEditText);

        editText.setText(name);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = editText.getText().toString().trim();
                database.QueryData("UPDATE WORKS SET NAME = '" + newName + "' WHERE ID = " + id );

                Toast.makeText(MainActivity.this, "updated", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                getDataWork();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.add_work, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.Add) {
            DialogAdd();
        }
        return super.onOptionsItemSelected(item);
    }

    private void DialogAdd() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_work);


        final  EditText editText = dialog.findViewById(R.id.txtInputName);
        Button btnAdd = dialog.findViewById(R.id.btnAdd);
        Button btnDelete = dialog.findViewById(R.id.btnCancel);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String nameWork = editText.getText().toString();
            if (nameWork.equals("")) {
                Toast.makeText(MainActivity.this, "Please, type name..", Toast.LENGTH_SHORT).show();
            } else {
                database.QueryData("INSERT INTO WORKS VALUES(null, '"+ nameWork +"')");
                Toast.makeText(MainActivity.this, "Added", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                getDataWork();
            }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


}