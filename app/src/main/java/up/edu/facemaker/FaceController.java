package up.edu.facemaker;
/*
 *
 * @author Alberto Lucero
 */
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import androidx.annotation.NonNull;

public class FaceController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener,
        AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {
    private Face faceViewReference;
    private FaceModel faceModelReference;
    SeekBar seekBarRed;
    SeekBar seekBarGreen;
    SeekBar seekBarBlue;

    public FaceController(Face view, SeekBar red, SeekBar green, SeekBar blue) {
        faceViewReference = view;
        faceModelReference = view.getFaceModelReference();

        seekBarRed = red;
        seekBarGreen = green;
        seekBarBlue = blue;
    }

    @Override
    public void onClick(View randomFaceButton) {
        faceViewReference.randomize();
        faceViewReference.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        /**
         External Citation
         Date: 2/15/26
         Problem: Could not make a working check for selectedId for radioButtons.
         Resource: https://stackoverflow.com/questions/35085265/android-check-radiobutton-id-in-a-radiogroup-with-linearlayout and Google AI.
         Solution: I used the example code and mixed them together.
         */
        int selectedId = ((RadioGroup) seekBar.getRootView().findViewById(R.id.radio_group_options)).getCheckedRadioButtonId();
        int seekBarId = seekBar.getId();

        //Would prefer to use Switch Case but resource ID's are non-final with Android Gradle
        if(selectedId == R.id.radioButton1) {
            if(seekBarId == R.id.seekBar) {
                faceModelReference.hairRed = progress;
            }
            else if(seekBarId == R.id.seekBar2) {
                faceModelReference.hairGreen = progress;
            }
            else if(seekBarId == R.id.seekBar3) {
                faceModelReference.hairBlue = progress;
            }
        } else if(selectedId == R.id.radioButton2) {
            if(seekBarId == R.id.seekBar) {
                faceModelReference.eyesRed = progress;
            }
            else if(seekBarId == R.id.seekBar2) {
                faceModelReference.eyesGreen = progress;
            }
            else if(seekBarId == R.id.seekBar3) {
                faceModelReference.eyesBlue = progress;
            }
        } else {
            if(seekBarId == R.id.seekBar) {
                faceModelReference.skinRed = progress;
            }
            else if(seekBarId == R.id.seekBar2) {
                faceModelReference.skinGreen = progress;
            }
            else if(seekBarId == R.id.seekBar3) {
                faceModelReference.skinBlue = progress;
            }
        }
        faceViewReference.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        faceViewReference.hairStyle = position;
        faceViewReference.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
        if(checkedId == R.id.radioButton1) {
            seekBarRed.setProgress(faceModelReference.hairRed);
            seekBarGreen.setProgress(faceModelReference.hairGreen);
            seekBarBlue.setProgress(faceModelReference.hairBlue);
        }
        else if(checkedId == R.id.radioButton2){
            seekBarRed.setProgress(faceModelReference.eyesRed);
            seekBarGreen.setProgress(faceModelReference.eyesGreen);
            seekBarBlue.setProgress(faceModelReference.eyesBlue);
        }
        else if(checkedId == R.id.radioButton3) {
            seekBarRed.setProgress(faceModelReference.skinRed);
            seekBarGreen.setProgress(faceModelReference.skinGreen);
            seekBarBlue.setProgress(faceModelReference.skinBlue);
        }
        faceViewReference.invalidate();
    }
}
