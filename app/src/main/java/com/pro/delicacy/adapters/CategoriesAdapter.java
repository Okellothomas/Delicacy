package com.pro.delicacy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pro.delicacy.R;
import com.pro.delicacy.models.Category;
import com.squareup.picasso.Picasso;

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

    public class myViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.delicaciesImageView) ImageView mCategoriesImageView;
        @BindView(R.id.delicaciesNameTextView) TextView mCategoriesName;
        @BindView(R.id.delicaciesDescriptionTextView) TextView mCategoriesDescription;

        private Context mContext;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindCategories(Category category){
            Picasso.get().load(category.getStrCategoryThumb()).into(mCategoriesImageView);
            mCategoriesName.setText(category.getStrCategory());
            mCategoriesDescription.setText(category.getStrCategoryDescription());
        }
    }
}
