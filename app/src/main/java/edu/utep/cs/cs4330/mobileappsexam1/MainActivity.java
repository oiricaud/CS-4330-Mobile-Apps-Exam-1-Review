package edu.utep.cs.cs4330.mobileappsexam1;



import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
    private CanvasView canvasView;
    private TextView xCoordinate;
    private TextView yCoordinate;

    // Save values
    float xState = 0;
    float yState = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // find the canvas view and register OnTouchListener
        canvasView = (CanvasView) findViewById(R.id.canvasView);
        xCoordinate = (TextView) findViewById(R.id.textViewX);
        yCoordinate = (TextView) findViewById(R.id.textViewY);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                xState = 0; // Catch when the the floating numbers are empty
                yState = 0;
            } else{
                xState = extras.getFloat("x");
                yState = extras.getFloat("y");
            }
        } else {
            xState = (float) savedInstanceState.getSerializable("x");
            yState = (float) savedInstanceState.getSerializable("y");
            xCoordinate.setText(String.valueOf(xState));
            yCoordinate.setText(String.valueOf(yState));
            canvasView.setxDraw(xState);
            canvasView.setyDraw(yState);
        }

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

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putFloat("x", canvasView.getxDraw());
        savedInstanceState.putFloat("y", canvasView.getyDraw());
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }
}
