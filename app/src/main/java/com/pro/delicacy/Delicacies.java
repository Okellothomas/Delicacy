package com.pro.delicacy;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pro.delicacy.adapters.CategoriesAdapter;
import com.pro.delicacy.models.CategoriesResponse;
import com.pro.delicacy.models.Category;
import com.pro.delicacy.network.DelicacyAPi;
import com.pro.delicacy.network.DelicacyClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Delicacies extends AppCompatActivity {

    @BindView(R.id.recyclerView) RecyclerView mRecylerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    private CategoriesAdapter mAdapter;

//    public List<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delicacies);
        ButterKnife.bind(this);

        DelicacyAPi client = DelicacyClient.getClient();

        Call<CategoriesResponse> call = client.categoryMeals();

        call.enqueue(new Callback<CategoriesResponse>() {
            @Override
            public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
                if (response.isSuccessful()){
                    List<Category> categories = response.body().getCategories();
                    mAdapter = new CategoriesAdapter(mRecylerView.getContext(),categories);
                    mRecylerView.setAdapter(mAdapter);
                    mRecylerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    mRecylerView.setHasFixedSize(true);
                    showCategories();
                    hideProgressBar();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<CategoriesResponse> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();
            }
        });
    }
    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showCategories() {
        mRecylerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}