package org.crazyandroid.customview;

import android.content.Context;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class DrawView extends View{

	public float currentX = 40;
	public float currentY = 50;
	
	public DrawView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		Paint p = new Paint();
		p.setColor(Color.RED);
		
		canvas.drawCircle(currentX, currentY, 15, p);
	}
}
