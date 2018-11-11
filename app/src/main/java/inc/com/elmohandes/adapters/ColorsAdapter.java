package inc.com.elmohandes.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import inc.com.elmohandes.R;
import inc.com.elmohandes.activities.ColorDetailsActivity;
import inc.com.elmohandes.database.ColorsDao;
import inc.com.elmohandes.model.Colors;


public class ColorsAdapter extends RecyclerView.Adapter<ColorsAdapter.ColorHolder> {
    Context context;
    ArrayList<Colors> colorsList;

    public ColorsAdapter(Context context, ArrayList<Colors> colorsList) {
        this.context = context;
        this.colorsList = colorsList;
    }
    @NonNull
    @Override
    public ColorHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.color_row, viewGroup, false);
        return new ColorHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ColorHolder colorHolder, int position) {
        Colors color = colorsList.get(position);
        colorHolder.colorName.setText(color.getName());
        colorHolder.colorCode.setText(color.getCode());
        colorHolder.colorBack.setCardBackgroundColor(Color.parseColor(color.getCode()));
    }
    @Override
    public int getItemCount() {
        return colorsList.size();
    }

    //colors holder
    public class ColorHolder extends RecyclerView.ViewHolder {

        TextView colorName, colorCode;
        ImageView like;
        CardView colorBack;

        public ColorHolder(@NonNull View itemView) {
            super(itemView);
            colorName = itemView.findViewById(R.id.colorName);
            colorCode = itemView.findViewById(R.id.colorCode);
            like = itemView.findViewById(R.id.like);
            colorBack = itemView.findViewById(R.id.colorBack);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ColorDetailsActivity.class);
                    intent.putExtra("color", colorCode.getText().toString());
                    context.startActivity(intent);
                }
            });

            like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //adding to favourite
                    Toast.makeText(context, "adding to  favourite ", Toast.LENGTH_LONG).show();
                }
            });
        }
    }


}
