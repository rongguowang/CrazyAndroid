package org.crazyandroid.advance;


import android.app.Activity;
import android.os.Bundle;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLSurfaceView;


import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ByteBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import org.crazyandroid.customview.TaperRenderer;

public class PolygonActivity extends Activity {
	private GLSurfaceView glView;
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	glView = new GLSurfaceView(this);
//    	PolygonRenderer polygon = new PolygonRenderer();
//    	glView.setRenderer(polygon);
    	TaperRenderer taper = new TaperRenderer();
    	glView.setRenderer(taper);
    	setContentView(glView);
    	glView.requestFocus();
    }
    
    public void onResume() {
    	super.onResume();
    	glView.onResume();
    }
    
    public void onPause() {
    	super.onPause();
    	glView.onPause();
    }
}
class PolygonRenderer implements Renderer {

	float triangleData[] = {
		-1.0f, 0.0f, 0.0f,
		-1.0f, -1.0f, 0.0f,
		1.00f, 0.0f, 0.0f
	};
    float vertices[] = { 0.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f,  
            -1.0f, 0.0f };  
    
	int triangleColor[] =  {
			65535, 0, 0, 0,
			0, 65535, 0, 0,
			0, 0, 65535, 0
	};
	byte index[] = {
			
	};
	float[] rectData = new float[] {
			0.4f, 0.4f, 0.0f,
			0.4f, -0.4f, 0.0f,
			-0.4f, 0.4f, 0.0f,
			-0.4f, -0.4f, 0.0f
	};
	int[] rectColor = new int[] {
			0, 65535, 0, 0,
			0, 0, 65535, 0,
			65535, 0, 0, 0,
			65535, 65535, 0, 0
	};
	float[] rectData2 = new float[] {
			-0.4f, 0.4f, 0.0f,
			0.4f, 0.4f, 0.0f,
			0.4f, -0.4f, 0.0f,
			-0.4f, -0.4f, 0.0f
	};
	float[] pentacle = new float[] {
			0.4f, 0.4f, 0.0f,
			-0.2f, 0.3f, 0.0f,
			0.5f, 0.0f, 0f,
			-0.4f, 0.0f, 0f,
			-0.1f, -0.3f, 0f
	};
	
	ByteBuffer byteBuffer;
	FloatBuffer triangleDataBuffer;
	IntBuffer triangleColorBuffer;
	FloatBuffer rectDataBuffer;
	IntBuffer rectColorBuffer;
	FloatBuffer rectDataBuffer2;
	FloatBuffer pentacleBuffer;
	
	public PolygonRenderer() {
		byteBuffer = ByteBuffer.allocateDirect(triangleData.length * 8);
		byteBuffer.order(ByteOrder.nativeOrder());
		triangleDataBuffer = byteBuffer.asFloatBuffer();
//		triangleDataBuffer.put(vertices);
		triangleDataBuffer.put(triangleData);
		triangleDataBuffer.position(0);
		
		
		rectDataBuffer = FloatBuffer.wrap(rectData);
		rectDataBuffer2 = FloatBuffer.wrap(rectData2);
		pentacleBuffer = FloatBuffer.wrap(pentacle);
		
		ByteBuffer mcf = ByteBuffer.allocateDirect(triangleColor.length * 4);
		mcf.order(ByteOrder.nativeOrder());
		triangleColorBuffer = mcf.asIntBuffer();
		triangleColorBuffer.put(triangleColor);
		triangleColorBuffer.position(0);
		
		rectColorBuffer = IntBuffer.wrap(rectColor);
	}
	
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		gl.glDisable(GL10.GL_DITHER);
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
		gl.glClearColor(0, 0, 0, 0);
		gl.glShadeModel(GL10.GL_SMOOTH);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glDepthFunc(GL10.GL_LEQUAL);
	}
	
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		float ratio = (float)width / height;
		gl.glFrustumf(-ratio, ratio, -1, 1, 1, 10);
	}
	
	public void onDrawFrame(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		
		gl.glLoadIdentity();
		gl.glTranslatef(0.0f, 0.0f, -6.0f);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, triangleDataBuffer);
		gl.glColorPointer(4, GL10.GL_FIXED, 0, triangleColorBuffer);
		gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 3);
		
		gl.glFinish();
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	}
}
