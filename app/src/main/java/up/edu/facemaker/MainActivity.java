package up.edu.facemaker;
/*
 *
 * @author Alberto Lucero
 */
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public String[] hairStyles = {"Style 1", "Style 2", "Style 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
            return insets;
        });

        /**
         External Citation
         Date: 2/5/26
         Problem: Could not get extra choices for spinner.
         Resource: In class instruction/Professor Nuxoll
         Solution: I used the example code from class.
         */

        SeekBar redSeekBar = findViewById(R.id.seekBar);
        SeekBar greenSeekbar = findViewById(R.id.seekBar2);
        SeekBar blueSeekbar = findViewById(R.id.seekBar3);

        Face faceView = findViewById(R.id.faceview);
        FaceController faceController = new FaceController(faceView, redSeekBar, greenSeekbar, blueSeekbar);

        Spinner hairSpinner = findViewById(R.id.spinner);
        ArrayAdapter<String> hairAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,this.hairStyles);
        hairSpinner.setAdapter(hairAdapter);
        hairSpinner.setOnItemSelectedListener(faceController);

        //Click Listener's for RGB seekbars
        greenSeekbar.setOnSeekBarChangeListener(faceController);
        blueSeekbar.setOnSeekBarChangeListener(faceController);
        redSeekBar.setOnSeekBarChangeListener(faceController);

        //Click Listener for RadioGroup
        RadioGroup radioGroup = (findViewById(R.id.radio_group_options));
        radioGroup.setOnCheckedChangeListener(faceController);

        //Click Listener for RandomFace Button
        Button randomizeFaceButton = findViewById(R.id.randomFace);
        randomizeFaceButton.setOnClickListener(faceController);
    }
}