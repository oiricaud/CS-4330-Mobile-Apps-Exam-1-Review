package edu.utep.cs.cs4330.mobileappsexam1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CanvasView canvasView;
    private TextView xCoordinate;
    private TextView yCoordinate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // find the canvas view and register OnTouchListener
        canvasView = (CanvasView) findViewById(R.id.canvasView);

        canvasView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                    screenTouched(event.getX(), event.getY());
                return false;
            }
        });

        // 2. THE REST OF CODE FOR ONCREATE METHOD HERE.
    }
    /** Called when the screen is touched at position x and y */
    protected void screenTouched(float x, float y) {
        xCoordinate = (TextView) findViewById(R.id.textViewX);
        yCoordinate = (TextView) findViewById(R.id.textViewY);
        xCoordinate.setText(String.valueOf(x));
        yCoordinate.setText(String.valueOf(y));
        canvasView.setxDraw(x);
        canvasView.setyDraw(y);
        canvasView.drawHere();
    }
}
