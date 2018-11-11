package inc.com.elmohandes.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.Locale;

import inc.com.elmohandes.R;
import inc.com.elmohandes.adapters.CategoriesAdapter;
import inc.com.elmohandes.model.ColorCategory;

public class ColorCategoryActivity extends AppCompatActivity {

    RecyclerView categoriesList;
    ArrayList<ColorCategory> colorCategories;
    CategoriesAdapter adapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //for showing the up arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        categoriesList = findViewById(R.id.colorsCategoryList);
        colorCategories = new ArrayList<>();
        colorCategories.add(new ColorCategory("cat 1 ", "250 pics ", " "));
        colorCategories.add(new ColorCategory("cat 1 ", "250 pics ", " "));
        colorCategories.add(new ColorCategory("cat 1 ", "250 pics ", " "));
        colorCategories.add(new ColorCategory("cat 1 ", "250 pics ", " "));

        adapter = new CategoriesAdapter(this, colorCategories);

        mLayoutManager = new GridLayoutManager(this, 1);
        categoriesList.setLayoutManager(mLayoutManager);
        categoriesList.setItemAnimator(new DefaultItemAnimator());
        categoriesList.setAdapter(adapter);


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
