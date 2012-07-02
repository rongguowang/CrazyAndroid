package org.crazyandroid.customview;

import android.opengl.GLSurfaceView.Renderer;

import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ByteBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class TaperRenderer implements Renderer{
    float mTaperVertices[] = {
    	0.0f, 1.0f, 0.0f,
    	-0.6f, 0.0f, 0.0f,
    	0.0f, 0.0f, 1.3f,
    	1.0f, 0.0f, 0.0f
    };
    
    int mTaperColors[] = {
    		65535, 0, 0, 0,
    		0, 65535, 0, 0,
    		0, 0, 65535, 0,
    		65535, 65535, 0, 0
    };
    
    byte mTaperIndex[] = {
            0, 1, 2,
            0, 1, 3, 
            0, 2, 3,
            0, 3, 2,
            1, 0, 2,
            1, 0, 3,
            1, 2, 3,
            1, 3, 2,
            2, 0, 1,
            2, 0, 3,
            2, 1, 0,
            2, 1, 3,
            2, 3, 0,
            2, 3, 1,
            3, 1, 0,
            3, 1, 2,
            3, 0, 1,
            3, 0, 2,
            3, 2, 1,
            3, 2, 0
    };
    
    FloatBuffer mTaperVerticesBuffer;
    IntBuffer mTaperColorBuffer;
    ByteBuffer mTaperIndexBuffer;
    
    public TaperRenderer() {
    	ByteBuffer tvb = ByteBuffer.allocateDirect(mTaperVertices.length * 8);
    	tvb.order(ByteOrder.nativeOrder());
    	mTaperVerticesBuffer = tvb.asFloatBuffer();
    	mTaperVerticesBuffer.put(mTaperVertices);
    	mTaperVerticesBuffer.position(0);
    	
    	ByteBuffer tcb = ByteBuffer.allocateDirect(mTaperColors.length * 4);
    	tcb.order(ByteOrder.nativeOrder());
    	mTaperColorBuffer = tcb.asIntBuffer();
    	mTaperColorBuffer.put(mTaperColors);
    	mTaperColorBuffer.position(0);
    	
    	mTaperIndexBuffer = ByteBuffer.allocateDirect(mTaperIndex.length);
    	mTaperIndexBuffer.put(mTaperIndex);
    	mTaperIndexBuffer.position(0);
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
    	gl.glFrustumf(ratio, ratio, -1, 1, 1, 10);
    }
    
    public void onDrawFrame(GL10 gl) {
    	gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
    	gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
//    	gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
    	gl.glMatrixMode(GL10.GL_MODELVIEW);
    	
    	gl.glLoadIdentity();
    	gl.glTranslatef(-0.6f, 0.0f, -1.5f);
    	gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mTaperVerticesBuffer);
    	gl.glRotatef(90.f, 1.0f, 1.0f, 1.0f);
//    	gl.glColorPointer(4, GL10.GL_FIXED, 0, mTaperColorBuffer);
    	gl.glDrawElements(GL10.GL_TRIANGLE_STRIP, mTaperIndexBuffer.remaining(), GL10.GL_UNSIGNED_BYTE, mTaperIndexBuffer);
    	
    	
    	gl.glFinish();
    	gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
//    	gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}
