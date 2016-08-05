package com.facci.camaraac;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivityAC extends AppCompatActivity {

    Bitmap bmp;
    ImageView imgimagen;
    Button btnfoto;
    Button btnguardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_ac);
        btnfoto = (Button) findViewById(R.id.fotoBT);
        btnguardar = (Button) findViewById(R.id.almacenarBT);


        imgimagen = (ImageView)findViewById(R.id.imagenCapturadaIV);

        btnfoto.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent llamar = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(llamar, 0);
            }
        });
        btnguardar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent llamar = new Intent(MediaStore.EXTRA_OUTPUT);
                Toast.makeText(MainActivityAC.this, "Foto almacenada correctamente", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK){
            Bundle ext = data.getExtras();
            bmp = (Bitmap)ext.get("data");
            imgimagen.setImageBitmap(bmp);
        }
    }
}
