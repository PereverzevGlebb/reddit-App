package com.example.testreddit.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.testreddit.ui.fragments.ArticleFragment;

import gap.com.redditApiTest.R;


public class MainActivity extends AppCompatActivity  {

    private ArticleFragment mArticleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mArticleFragment = (ArticleFragment)
                    getSupportFragmentManager().findFragmentByTag(ArticleFragment.class.getSimpleName());

        } else if (mArticleFragment == null) {
            mArticleFragment = new ArticleFragment();
            showArticles();
        }
    }

    public void showArticles() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container_main, mArticleFragment, ArticleFragment.class.getSimpleName());
        ft.commit();
    }

}