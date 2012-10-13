package edu.hit.bhitmap;

/**********DAVID LDW***********/
/**********测试BETA版**********/

import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.content.*;
import android.widget.Toast;

public class Mapview extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.layout_mapview);

	    
	    //下面的代码实现图像的旋转
	    final ImageView imageView; 
	    imageView = (ImageView) findViewById(R.id.myimage);
	    final Bitmap bmp = ((BitmapDrawable) getResources().getDrawable(
	            R.drawable.map_up)).getBitmap();
	    
	    Bitmap bm = Bitmap.createBitmap(bmp, 0,0, bmp.getWidth(),bmp.getHeight(),new Matrix(), true);
	    Button Button1 = (Button) findViewById(R.id.button1);
	    Button Button2 = (Button) findViewById(R.id.button2);
	    Button Button3 = (Button) findViewById(R.id.button3);
	    Button Button4 = (Button) findViewById(R.id.button4);
	    Button1.setOnClickListener(
	    
	    new OnClickListener(){
	    	
	    	@Override
			public void onClick(View v) {
	    		
	    			Matrix myMatrix = new Matrix();
	    			myMatrix.postScale(1f,1f);
				    Bitmap bm = Bitmap.createBitmap(bmp, 0,0, bmp.getWidth(),
				    bmp.getHeight(), myMatrix, true);
				    imageView.setImageBitmap(bm);		
			}
	    });
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout_mapview, menu);
        return true;
    }

}
