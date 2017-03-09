package edu.utep.cs.cs4330.mobileappsexam1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by oscarricaud on 3/8/17.
 */
public class CanvasView extends View {
    private float xDraw;
    private float yDraw;
    /* Begin Getters and Setters */

    public float getyDraw() {
        return yDraw;
    }

    public void setyDraw(float yDraw) {
        this.yDraw = yDraw;
    }

    public float getxDraw() {
        return xDraw;
    }

    public void setxDraw(float xDraw) {
        this.xDraw = xDraw;
    }
    /* End Getters and Setters */

    /** Green Circle Paint **/
    private final int greenColor = Color.rgb(0,128,0);

    private final Paint greenPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    {
        greenPaint.setColor(greenColor);
    }
    public void drawHere(){
        invalidate();
    }
    public CanvasView (Context ctx , AttributeSet attrs) {
        super ( ctx , attrs) ;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getxDraw(), getyDraw(), 50, greenPaint);
        getxDraw();
        getyDraw();
    }

    /** Calculate the gap between two horizontal/vertical lines. */
    protected float lineGap() {
        return Math.min(getMeasuredWidth(), getMeasuredHeight());
    }

}
