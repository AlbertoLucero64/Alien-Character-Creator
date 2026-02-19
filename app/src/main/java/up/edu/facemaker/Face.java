package up.edu.facemaker;
/*
 *
 * @author Alberto Lucero
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;
/*
 *
 * @author Alberto Lucero
 */

public class Face extends SurfaceView {
    private FaceModel faceModelReference;
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;
    private Random random = new Random();

    //Variable that will be used to randomly select a number from 0 to 255 for RGB values
    //public int random = (int)(Math.random()*256);



    //Getter method
    public FaceModel getFaceModelReference() {
        return this.faceModelReference;
    }

    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        FaceModel faceModel = new FaceModel();
        faceModelReference = faceModel;

        setWillNotDraw(false);
        setBackgroundColor(Color.WHITE);

        //Color Palette
        //hairPaint.setStyle(Paint.Style.FILL);
        //eyePaint.setStyle(Paint.Style.FILL);
        //skinPaint.setStyle(Paint.Style.FILL);

        randomize();
        }

    public void randomize() {
        //Set each hair, eyes, and skin RGB values to a random number between 0 and 255.
        faceModelReference.hairRed = random.nextInt(256);
        faceModelReference.hairGreen = random.nextInt(256);
        faceModelReference.hairBlue = random.nextInt(256);

        faceModelReference.eyesRed = random.nextInt(256);
        faceModelReference.eyesGreen = random.nextInt(256);
        faceModelReference.eyesBlue = random.nextInt(256);

        faceModelReference.skinRed = random.nextInt(256);
        faceModelReference.skinGreen = random.nextInt(256);
        faceModelReference.skinBlue = random.nextInt(256);

        //Hair style only has 3 choices
        hairStyle=random.nextInt(3);
    }

    protected void onDraw(Canvas canvas) {
        /**
         External Citation
         Date: 2/17/26
         Problem: Could not update RGB values when drawing
         Resource: Google AI showed me the (Color.rgb) method.
         Solution: Implemented method down below, and changed FaceMode.hairRed to faceModelReference.hairRed.
         */
       //Allows RGB values taken from model to be updated on view
        Paint hairPaint = new Paint();
        Paint eyePaint = new Paint();
        Paint skinPaint = new Paint();
        hairPaint.setColor(Color.rgb(faceModelReference.hairRed, faceModelReference.hairGreen, faceModelReference.hairBlue));
        eyePaint.setColor(Color.rgb(faceModelReference.eyesRed, faceModelReference.eyesGreen, faceModelReference.eyesBlue));
        skinPaint.setColor(Color.rgb(faceModelReference.skinRed, faceModelReference.skinGreen, faceModelReference.skinBlue));

        //Draws Alien Head
        canvas.drawCircle(canvas.getWidth()/2,(canvas.getHeight()/2),400, skinPaint);
        canvas.drawOval((canvas.getWidth()/2)-325,((canvas.getHeight()/2))-400,(canvas.getWidth()/2)+325,(canvas.getHeight()/2)+550,skinPaint);

        //Draws Aliens' Eyes
        canvas.drawOval((canvas.getWidth()/2)-350,((canvas.getHeight()/2))-200,(canvas.getWidth()/2)-100,(canvas.getHeight()/2)+200,eyePaint);
        canvas.drawOval((canvas.getWidth()/2)+100,((canvas.getHeight()/2))-200,(canvas.getWidth()/2)+350,(canvas.getHeight()/2)+200,eyePaint);

        switch(hairStyle) {
            case 0:
                canvas.drawCircle((canvas.getWidth()/2),((canvas.getHeight()/2))-400,100, hairPaint);
                break;
            case 1:
                canvas.drawCircle((canvas.getWidth()/2),((canvas.getHeight()/2))-400,100, hairPaint);
                canvas.drawCircle((canvas.getWidth()/2)-400,((canvas.getHeight()/2)),100, hairPaint);
                canvas.drawCircle((canvas.getWidth()/2)+400,((canvas.getHeight()/2)),100, hairPaint);
                break;
            case 2:
                canvas.drawCircle((canvas.getWidth()/2),((canvas.getHeight()/2))-400,100, hairPaint);
                canvas.drawCircle((canvas.getWidth()/2)-400,((canvas.getHeight()/2)),100, hairPaint);
                canvas.drawCircle((canvas.getWidth()/2)+400,((canvas.getHeight()/2)),100, hairPaint);
                canvas.drawCircle((canvas.getWidth()/2)-325,((canvas.getHeight()/2)-200),100, hairPaint);
                canvas.drawCircle((canvas.getWidth()/2)+325,((canvas.getHeight()/2)-200),100, hairPaint);
                canvas.drawCircle((canvas.getWidth()/2)-175,((canvas.getHeight()/2)-300),100, hairPaint);
                canvas.drawCircle((canvas.getWidth()/2)+175,((canvas.getHeight()/2)-300),100, hairPaint);
                break;
        }
    }
}
