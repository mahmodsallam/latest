package inc.com.elmohandes.activities;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import inc.com.elmohandes.R;
import inc.com.elmohandes.adapters.ColorsAdapter;
import inc.com.elmohandes.database.ColorsDatabase;
import inc.com.elmohandes.model.Colors;


public class ColorsActivity extends AppCompatActivity {

    RecyclerView colorsRecycler;
    ColorsAdapter adapter;
    ArrayList<Colors> colorsList;
    RecyclerView.LayoutManager mLayoutManager;
    ColorsDatabase databse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //for showing the up arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        colorsRecycler = findViewById(R.id.colorRecycler);
        colorsList = new ArrayList<>();
        colorsList.add(new Colors("red", "#D6300D"));
        colorsList.add(new Colors("blue ", "#0D5FD6"));
        colorsList.add(new Colors("yellow ", "#F1CB0B"));
        colorsList.add(new Colors("green ", "#31F10B"));

        //database
//        databse = ColorsDatabase.getInstance(this) ;

        adapter = new ColorsAdapter(this, colorsList);

        mLayoutManager = new GridLayoutManager(this, 1);
        colorsRecycler.setLayoutManager(mLayoutManager);
        colorsRecycler.setItemAnimator(new DefaultItemAnimator());
        colorsRecycler.setAdapter(adapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}
