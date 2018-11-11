package inc.com.elmohandes.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import inc.com.elmohandes.R;

public class ColorDetailsActivity extends AppCompatActivity {
    RelativeLayout colorDetailsBack;
    TextView colorCodeText ;
    ImageView screenShot ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        colorDetailsBack = findViewById(R.id.colorDetails);
        String color = getIntent().getStringExtra("color");
        colorDetailsBack.setBackgroundColor(Color.parseColor(color));

        colorCodeText = findViewById(R.id.colorCodeTxt) ;
        colorCodeText.setText(color);

        screenShot = findViewById(R.id.screenshot) ;
        screenShot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

}
