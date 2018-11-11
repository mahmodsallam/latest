package inc.com.elmohandes.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import inc.com.elmohandes.R;
import inc.com.elmohandes.activities.ColorsActivity;
import inc.com.elmohandes.model.ColorCategory;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {
    private Context context;
    private ArrayList<ColorCategory> colorCategories;

    public CategoriesAdapter(Context context, ArrayList<ColorCategory> colorCategories) {
        this.context = context;
        this.colorCategories = colorCategories;
    }

    //creating a view holder
    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.categories_row, viewGroup, false);
        return new CategoriesViewHolder(view);

    }

    //filling the views with data
    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder , int position ) {

        final ColorCategory colorCategory =  colorCategories.get(position) ;
            holder.categoryName.setText( colorCategory.getCategoryName());
            holder.numberOfPics.setText(colorCategory.getNumebrOfPic());
            //getting image from the api and display it



    }

    @Override
    public int getItemCount() {
        return colorCategories.size();
    }

    //categories view holder
    public class CategoriesViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName, numberOfPics;
        ImageView categoryImage;

        public CategoriesViewHolder(View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            numberOfPics = itemView.findViewById(R.id.numberOfColors);
            categoryImage = itemView.findViewById(R.id.catImageId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context , ColorsActivity.class) ;
                    context.startActivity(intent);
                }
            });
        }
    }
}
