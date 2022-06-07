package com.pro.delicacy.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pro.delicacy.CategoriesDetails;
import com.pro.delicacy.R;
import com.pro.delicacy.models.Category;
import com.pro.delicacy.ui.Categories_details;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.myViewHolder>{

    private Context mContext;
    private List<Category> categories;

    public CategoriesAdapter(Context mContext, List<Category> categories) {
        this.mContext = mContext;
        this.categories = categories;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delicacies_catogories_item, parent, false);
        myViewHolder viewHolder = new myViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.bindCategories(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.delicaciesImageView) ImageView mCategoriesImageView;
        @BindView(R.id.delicaciesNameTextView) TextView mCategoriesName;
        @BindView(R.id.delicaciesDescriptionTextView) TextView mCategoriesDescription;

        private Context mContext;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindCategories(Category category){
            Picasso.get().load(category.getStrCategoryThumb()).into(mCategoriesImageView);
            mCategoriesName.setText(category.getStrCategory());
            mCategoriesDescription.setText(category.getStrCategoryDescription());
        }

        @Override
        public void onClick(View v){
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, CategoriesDetails.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("category", Parcels.wrap(categories));
            mContext.startActivity(intent);
        }
    }


}
