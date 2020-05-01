package com.oepr.imagenes3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button buttonDrawBitmap;
    ImageView imageViewBitmap;
    TextView text_img;
    public int anterior = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_img = findViewById(R.id.text_img);
        this.buttonDrawBitmap = findViewById(R.id.buttonDrawBitmap);
        this.imageViewBitmap = this.findViewById(R.id.imageViewBitmap);
        final int[] myImageList = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6};

        this.buttonDrawBitmap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int num_random = (int) Math.floor(Math.random() * 6 + 1);
                /*
                BitmapWorkerTask task = new BitmapWorkerTask(imageViewBitmap);
                task.execute(R.drawable.forest_restoration_map);
                */
                if(anterior == 0){
                    Log.i("onOptiomsItemSelected", "Creando objeto tarea asíncrona");
                    final BitmapWorkerTask task = new BitmapWorkerTask(imageViewBitmap,
                            getResources(), imageViewBitmap.getWidth(), imageViewBitmap.getHeight());
                    final AsyncDrawable asyncDrawable =  new AsyncDrawable(getResources(), null, task);
                    imageViewBitmap.setImageDrawable(asyncDrawable);
                    task.execute(myImageList[num_random]);
                }
                else{
                    if (cancelPotentialWork(myImageList[anterior], imageViewBitmap) ) {
                        Log.i("onOptiomsItemSelected", "Creando objeto tarea asíncrona");
                        final BitmapWorkerTask task = new BitmapWorkerTask(imageViewBitmap,
                                getResources(), imageViewBitmap.getWidth(), imageViewBitmap.getHeight());
                        final AsyncDrawable asyncDrawable =  new AsyncDrawable(getResources(), null, task);
                        imageViewBitmap.setImageDrawable(asyncDrawable);
                        task.execute(myImageList[num_random]);
                    }
                }
                anterior = num_random;
                text_img.setText("Imagen cargada: "+myImageList[num_random]);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.itemMenuLoadBitmap:
                Log.i("onOptiomsItemSelected", "Creando objeto tarea asíncrona");
                BitmapWorkerTask task = new BitmapWorkerTask(imageViewBitmap, getResources(),
                        imageViewBitmap.getWidth(), imageViewBitmap.getHeight());
                //task.execute(R.drawable.forest_restoration_map);
                return true;
            case R.id.itemMenuExitApp:
                this.finish();
                System.exit(RESULT_OK);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean cancelPotentialWork(int data, ImageView imageView) {
        final BitmapWorkerTask bitmapWorkerTask = getBitmapWorkerTask(imageView);

        if (bitmapWorkerTask != null) {
            Log.i("cancelPotentialWork", "Buscando procesos previos...");
            final int bitmapData = bitmapWorkerTask.getBitmapData();
            if (bitmapData != data) {
                // Cancel previous task
                Log.i("cancelPotencialWork", "Cancelando tarea asíncrona...");
                bitmapWorkerTask.cancel(true);
                return true;
            } else {
                // The same work is already in progress
                return false;
            }
        }
        Log.i("cancelPotentialWork", "No hay hilos previos o ya se finalizaron");
        // No task associated with the ImageView, or an existing task was cancelled
        return true;
    }

    private BitmapWorkerTask getBitmapWorkerTask(ImageView imageView) {
        if (imageView != null) {
            final Drawable drawable = this.imageViewBitmap.getDrawable();
            if (drawable instanceof AsyncDrawable) {
                final AsyncDrawable asyncDrawable = (AsyncDrawable) drawable;
                return asyncDrawable.getBitmapWorkerTask();
            }
        }
        return null;
    }
}
