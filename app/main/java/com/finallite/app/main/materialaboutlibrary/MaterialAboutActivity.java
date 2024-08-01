package com.finallite.app.main.materialaboutlibrary;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;
import com.finallite.app.main.materialaboutlibrary.adapters.MaterialAboutListAdapter;
import com.finallite.app.main.materialaboutlibrary.model.MaterialAboutList;
import com.finallite.app.main.materialaboutlibrary.util.DefaultViewTypeManager;
import com.finallite.app.main.materialaboutlibrary.util.ViewTypeManager;
import com.finallite.R;

import java.lang.ref.WeakReference;

public abstract class MaterialAboutActivity extends LocalizationActivity {

    private MaterialAboutList list = new MaterialAboutList.Builder().build();
    private RecyclerView recyclerView;
    private MaterialAboutListAdapter adapter;
    private ImageButton btnBack;

    @NonNull
    protected abstract MaterialAboutList getMaterialAboutList(@NonNull Context context);

    @Nullable
    protected abstract CharSequence getActivityTitle();

    /**
     * Get a reference to the recyclerview in case a snackbar needs to be displayed
     * @return
     */
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mal_material_about_content);

        CharSequence title = getActivityTitle();
        if (title == null)
            setTitle(R.string.mal_title_about);
        else
            setTitle(title);


        assignViews();
        initViews();

        ListTask task = new ListTask(this);
        task.execute();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void assignViews() {
        recyclerView = findViewById(R.id.mal_recyclerview);
        recyclerView.setAlpha(0f);
        recyclerView.setTranslationY(20);
    }

    private void initViews() {
        btnBack = findViewById(R.id.btnBack);
        adapter = new MaterialAboutListAdapter(getViewTypeManager());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }
    }

    @NonNull
    protected ViewTypeManager getViewTypeManager() {
        return new DefaultViewTypeManager();
    }

    @NonNull
    protected MaterialAboutList getList() {
        return list;
    }

    protected boolean shouldAnimate() {
        return true;
    }

    protected void refreshMaterialAboutList() {
        setMaterialAboutList(list);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void onTaskFinished(@Nullable MaterialAboutList materialAboutList) {
        if (materialAboutList != null) {
            list = materialAboutList;
            adapter.setData(list.getCards());

            if (shouldAnimate()) {
                recyclerView.animate()
                        .alpha(1f)
                        .translationY(0f)
                        .setDuration(600)
                        .setInterpolator(new FastOutSlowInInterpolator()).start();
            } else {
                recyclerView.setAlpha(1f);
                recyclerView.setTranslationY(0f);
            }
        } else {
            finish();//?? why we remain here anyway?
        }
    }

    protected void setMaterialAboutList(MaterialAboutList materialAboutList) {
        list = materialAboutList;
        adapter.setData(list.getCards());
    }

    private static class ListTask extends AsyncTask<String, String, MaterialAboutList> {

        private WeakReference<MaterialAboutActivity> context;

        ListTask(MaterialAboutActivity context) {
            this.context = new WeakReference<>(context);
        }

        @Override
        protected MaterialAboutList doInBackground(String... params) {
            return isCancelled() || context.get() == null ? null : context.get().getMaterialAboutList(context.get());
        }

        @Override
        protected void onPostExecute(MaterialAboutList materialAboutList) {
            super.onPostExecute(materialAboutList);
            if (context.get() != null) {
                if (!context.get().isFinishing()) {
                    context.get().onTaskFinished(materialAboutList);
                }
            }
            context = null;
        }
    }
}
