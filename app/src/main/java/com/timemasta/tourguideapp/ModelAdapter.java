package com.timemasta.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.MyViewHolder> {

    private List<Model> modelList;
    public TextView h3, h3Span, link;

    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageIcon;

        public MyViewHolder(View view) {
            super(view);
            h3 = (TextView) view.findViewById(R.id.title);
            imageIcon = (ImageView) view.findViewById(R.id.image_icon);
            h3.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("POSITION", "" + position);
            context.startActivity(intent);
        }
    }


    public ModelAdapter(List<Model> moviesList, Context ctx) {
        this.modelList = moviesList;
        this.context = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Model model = modelList.get(position);
        h3.setText(model.getH3());
        Picasso.get().load(model.getImagesrc())
                .resize(120, 120)
                .into(holder.imageIcon);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}