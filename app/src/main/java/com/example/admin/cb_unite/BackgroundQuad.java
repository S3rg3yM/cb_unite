package com.example.admin.cb_unite;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class BackgroundQuad extends View{

    Paint paint;
    Shader luar;
    //    final float[] color = { 301.3125f, 0.43854168f, 0.49374998f };
    final float[] color = { 1.f, 1.f, 1.f };


    public BackgroundQuad(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BackgroundQuad(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    int rgb;

    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(this.toString(), "OnDraw");
        if (paint == null) {
            paint = new Paint();
            luar = new LinearGradient(0.f, 0.f, 0.f, this.getMeasuredHeight(), 0xffffffff, 0xff000000, Shader.TileMode.CLAMP);
        }
//        rgb = Color.HSVToColor(color);
        Shader dalam = new LinearGradient(0.f, 0.f, this.getMeasuredWidth(), 0.f, 0xffffffff, rgb, Shader.TileMode.CLAMP);
        ComposeShader shader = new ComposeShader(luar, dalam, PorterDuff.Mode.MULTIPLY);
        paint.setShader(shader);
        canvas.drawRect(0.f, 0.f, this.getMeasuredWidth(), this.getMeasuredHeight(), paint);
        Log.d("Draw", "w: "+getMeasuredWidth()+ " h: "+getMeasuredHeight());
    }

    void setHue(float hue) {
        color[0] = hue;
        invalidate();
    }

    void setMyColor(int _color){
        rgb = _color;
        invalidate();
    }
}
