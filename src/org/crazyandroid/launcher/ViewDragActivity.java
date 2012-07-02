package org.crazyandroid.launcher;

import org.crazyandroid.sample.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ViewDragActivity extends Activity{
    private static final String IMAGE_TAG = "icon";
    private View tx = null;
    private View tx2 = null;
    private GestureDetector mGesture = null;
    private boolean openStatus = false;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewdraglayout);
        tx = (View)findViewById(R.id.textview3);
        tx2 = (View)findViewById(R.id.textview4);
        tx.setTag(IMAGE_TAG);
        tx.setOnLongClickListener(new OnLongClickListener() {
            public boolean onLongClick(View v) {
//                tx.setBackgroundColor(R.layout.bg_blue);
                Item item = new Item("icon");
//                ClipData clipdata = new ClipData("icon", new String[][](), item);
                View.DragShadowBuilder myShadow = new MyDragShadowBuilder(tx);
                v.startDrag(null, myShadow, null, 0);
                return false;
            }
        });

        tx.setOnDragListener(new MyDragListener());
        tx2.setOnDragListener(new MyDragListener());
        tx.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                    switch(event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        View.DragShadowBuilder myShadow = new MyDragShadowBuilder(tx);
                        v.startDrag(null, myShadow, null, 0);
                    case MotionEvent.ACTION_MOVE:
                    case MotionEvent.ACTION_UP:
                    default: break;
                    }
                    return false;
                }
         });
//        mGesture = new GestureDetector(new MyGestureListener());
//        tx.setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                mGesture.onTouchEvent(event);
//                if(MotionEvent.ACTION_DOWN == event.getAction()) {
//                    handleActionDown();
//                } else if (MotionEvent.ACTION_MOVE == event.getAction()){
//                    handleActionMove();
//                } else if(MotionEvent.ACTION_UP == event.getAction()) {
//                    handleActionUp();
//                } else if(MotionEvent.ACTION_CANCEL == event.getAction()) {
//                    handleActionCancel();
//                }
//                return false;
//            }
//        });
    }

    public boolean handleActionDown() {
        return false;
    }

    public boolean handleActionMove() {
        return false;
    }

    public boolean handleActionUp() {
        return false;
    }

    public boolean handleActionCancel() {
        return false;
    }

    public boolean onTouchEvent(MotionEvent event) {
//        switch(event.getActionMasked()) {
//        case MotionEvent.ACTION_DOWN:
//        case MotionEvent.ACTION_MOVE:
//        case MotionEvent.ACTION_UP:
//        default: break;
//        }
//        mGesture.onTouchEvent(event);
        return false;
    }

    public void halfOpen() {
        RelativeLayout.LayoutParams tx2lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,200);
        tx2lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        tx2.setLayoutParams(tx2lp);
        tx2.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
        RelativeLayout.LayoutParams txlp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, 80);
        txlp.addRule(RelativeLayout.ABOVE, R.id.textview4);
        tx.setLayoutParams(txlp);
//        tx.setBackgroundDrawable(new ColorDrawable(Color.DKGRAY));
    }

    public void fullOpen() {
        RelativeLayout.LayoutParams tx2lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,400);
        tx2lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        tx2.setLayoutParams(tx2lp);
        tx2.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
        RelativeLayout.LayoutParams txlp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, 80);
        txlp.addRule(RelativeLayout.ABOVE, R.id.textview4);
        tx.setLayoutParams(txlp);
//        tx.setBackgroundDrawable(new ColorDrawable(Color.DKGRAY));
    }

    public void numberOpen(int tx2height) {
        RelativeLayout.LayoutParams tx2lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,tx2height);
        tx2lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        tx2.setLayoutParams(tx2lp);
        tx2.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
    }
    private static class MyDragShadowBuilder extends View.DragShadowBuilder{
        private static Drawable shadow;

        public MyDragShadowBuilder(View v) {
            super(v);
            shadow = new ColorDrawable(Color.LTGRAY);
        }

        public void onProvideShadowMetrics(Point size, Point touch) {
            int width;
            int height;
            width = getView().getWidth() / 2;
            height = getView().getHeight() / 2;
            shadow.setBounds(0, 0, width, height);
            size.set(width, height);
            touch.set(width / 2, height / 2);
        }

        public void onDrawShadow(Canvas canvas) {
            shadow.draw(canvas);
        }
    }

    private class MyDragListener implements View.OnDragListener {
        public boolean onDrag(View v, DragEvent event) {
            final int action = event.getAction();
            switch(action) {
            case DragEvent.ACTION_DRAG_STARTED:
            {
//                v.setBackgroundResource(R.layout.bg_blue);
                v.setBackgroundDrawable(new ColorDrawable(Color.GREEN));
                v.invalidate();
                return true;
            }
            case DragEvent.ACTION_DRAG_ENTERED:
            {
//                v.setBackgroundColor(R.layout.bg_green);
                v.setBackgroundDrawable(new ColorDrawable(Color.RED));
                v.invalidate();
                return true;
            }
            case DragEvent.ACTION_DRAG_LOCATION:
                return true;
            case DragEvent.ACTION_DROP:
            {
//                Item item = event.getClipData().getItemAt(0);
//                ClipData dragData = (ClipData) item.getText();
                v.setBackgroundDrawable(new ColorDrawable(Color.GREEN));
                Toast.makeText(ViewDragActivity.this, "Drag data is", Toast.LENGTH_LONG);
                v.invalidate();
                return true;
            }
            case DragEvent.ACTION_DRAG_ENDED:
                return true;
            case DragEvent.ACTION_DRAG_EXITED:
                return true;
            default:
            }
            return false;
        }
    }

    public class MyGestureListener implements  OnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                float velocityY) {
            System.out.println("e1.getX() = " + e1.getX() + " e1.getY() = " + e1.getY());
            System.out.println("e2.getX() = " + e1.getX() + " e2.getY() = " + e2.getY());
            System.out.println("velocityX = " + velocityX + " velocityY = " + velocityY);
            System.out.println("getWidth = " + tx.getWidth() + "getHeight = " + tx.getHeight());
            if (openStatus) {
                openStatus = false;
                halfOpen();
//                tx.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                tx2.setBackgroundDrawable(new ColorDrawable(Color.DKGRAY));
            } else {
                openStatus = true;
                numberOpen(300);
//                tx.setBackgroundDrawable(new ColorDrawable(Color.DKGRAY));
                tx2.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
            }
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                float distanceX, float distanceY) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }
    }
}
