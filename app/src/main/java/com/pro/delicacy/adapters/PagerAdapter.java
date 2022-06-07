package com.pro.delicacy.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.pro.delicacy.models.Category;
import com.pro.delicacy.ui.Categories_details;

import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {

    private List<Category> mCategory;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior, List<Category> category) {
        super(fm, behavior);
        mCategory = category;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return Categories_details.newInstance(mCategory.get(position));
    }

    @Override
    public int getCount() {
        return mCategory.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mCategory.get(position).getStrCategory();
    }
}
