package edu.hit.bhitmap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.*;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.content.*;

public class Mapview extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.layout_mapview);
	    ImageView imageView; 
	    Matrix mMatrix = new Matrix();
	    imageView = (ImageView) findViewById(R.id.myimage);
	   
	    Bitmap bmp = ((BitmapDrawable) getResources().getDrawable(
	            R.drawable.map_up)).getBitmap();
	    mMatrix.setRotate(60);
	    Bitmap bm = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(),
	            bmp.getHeight(), mMatrix, true);
	    imageView.setImageBitmap(bm);
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout_mapview, menu);
        return true;
    }
}
