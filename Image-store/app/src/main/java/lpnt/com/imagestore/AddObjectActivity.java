package lpnt.com.imagestore;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddObjectActivity extends AppCompatActivity {

    Button btnAdd, btnCancel;
    EditText editName, editDesc;
    ImageButton imgBtnCamera, imgBtnFolder;
    ImageView imageView;

    int REQUEST_CODE_CAMERA = 123;
    int REQUEST_CODE_FOLDER = 456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_image);

        mapping();

        imgBtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CODE_CAMERA);
            }
        });

        imgBtnFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");

                startActivityForResult(intent, REQUEST_CODE_FOLDER);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // convert data img -> byte[]

                BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();

                Bitmap bitmap = bitmapDrawable.getBitmap();

                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);

                byte[] img = byteArray.toByteArray();

                MainActivity.database.insertObject(
                        editName.getText().toString().trim(),
                        editDesc.getText().toString().trim(),
                        img
                );

                Toast.makeText(AddObjectActivity.this, "Added", Toast.LENGTH_LONG).show();

                startActivity(new Intent(AddObjectActivity.this, MainActivity.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            imageView.setImageBitmap(bitmap);
        }

        if (requestCode == REQUEST_CODE_FOLDER &&  requestCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                imageView.setImageBitmap(bitmap);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void mapping() {
        imageView = findViewById(R.id.imageView);

        btnAdd = findViewById(R.id.buttonAdd);
        btnCancel = findViewById(R.id.buttonCancel);

        editName = findViewById(R.id.nameText);
        editDesc = findViewById(R.id.descText);

        imgBtnCamera =  findViewById(R.id.imageCamera);

        imgBtnFolder = findViewById(R.id.imageFolder);

    }
}
