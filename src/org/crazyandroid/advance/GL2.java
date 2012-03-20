package org.crazyandroid.advance;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.os.Bundle;

public class GL2 extends Activity {  
    
    private GLSurfaceView mGLSurfaceView;  
  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        mGLSurfaceView = new GLSurfaceView(this);  
        mGLSurfaceView.setRenderer(new Two());  
        setContentView(mGLSurfaceView);  
    }  
  
    @Override  
    protected void onResume() {  
        super.onResume();  
        mGLSurfaceView.onResume();  
    }  
  
    @Override  
    protected void onPause() {  
        super.onPause();  
        mGLSurfaceView.onPause();  
    }  
}  
  
class Two implements Renderer {  
  
    private Triangle triangle;  
  
    public Two() {  
        triangle = new Triangle();  
    }  
  
    @Override  
    public void onDrawFrame(GL10 gl) {  
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);  
        gl.glLoadIdentity();  
  
        gl.glTranslatef(0.0f, 0.0f, -6.0f);  
        triangle.draw(gl);  
    }  
  
    @Override  
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {  
        gl.glShadeModel(GL10.GL_SMOOTH);  
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);  
        gl.glClearDepthf(1.0f);  
        gl.glEnable(GL10.GL_DEPTH_TEST);  
        gl.glDepthFunc(GL10.GL_LEQUAL);  
          
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);  
    }  
  
    @Override  
    public void onSurfaceChanged(GL10 gl, int width, int height) {  
        if (height == 0) {  
            height = 1;  
        }  
  
        gl.glViewport(0, 0, width, height);  
        gl.glMatrixMode(GL10.GL_PROJECTION);  
        gl.glLoadIdentity();  
  
        GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.1f,  
                100.0f);  
  
        gl.glMatrixMode(GL10.GL_MODELVIEW);  
        gl.glLoadIdentity();  
    }  
}  
  
class Triangle {  
    private FloatBuffer vertexBuffer;  
  
    private float vertices[] = { 0.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f,  
            -1.0f, 0.0f };  
  
    public Triangle() {  
        ByteBuffer byteBuf = ByteBuffer.allocateDirect(vertices.length * 4);  
        byteBuf.order(ByteOrder.nativeOrder());  
        vertexBuffer = byteBuf.asFloatBuffer();  
        vertexBuffer.put(vertices);  
        vertexBuffer.position(0);  
    }  
  
    public void draw(GL10 gl) {  
        gl.glFrontFace(GL10.GL_CW);  
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);  
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);  
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, vertices.length / 3);  
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);  
    }  
  
}  