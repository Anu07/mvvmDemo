package com.example.anub.mvvmdemo.view.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.anub.mvvmdemo.R;
import com.example.anub.mvvmdemo.databinding.ActivityMainBinding;
import com.example.anub.mvvmdemo.model.PostResponse;
import com.example.anub.mvvmdemo.room.AppDatabase;
import com.example.anub.mvvmdemo.viewModel.PostDataModelLiveData;
import com.example.anub.mvvmdemo.viewModel.PostDataView;

import java.util.List;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements PostDataView {

    private PostResponse data;
    Realm realm;
    //    RealmController mRealmController;
    private String TAG = MainActivity.class.getName();
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityBinding();
        initViewModel();
//        mRealmController=RealmController.with(MainActivity.this);
    }

    private void observeViewModel(PostDataModelLiveData viewModel) {
        viewModel.getLivePosts().observe(this, posts -> {
            if (posts != null) {
                if(AppDatabase.getInstance(MainActivity.this).getpostDao().getAll().size()==0){
                    AppDatabase
                            .getInstance(MainActivity.this)
                            .getpostDao()
                            .insertAll(posts);
                }
                binding.setData(posts.get(0));
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * Initializing AndroidViewModel
     */

    private void initViewModel() {
        final PostDataModelLiveData viewModel =
                ViewModelProviders.of(this).get(PostDataModelLiveData.class);
        observeViewModel(viewModel);
    }

    private void initActivityBinding() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.headingText.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Testing", Toast.LENGTH_LONG).show();
        });
    }


    /**
     * Saving data to realm for offline support
     *
     * @param data
     */

    private void saveDatatoRealm(List<PostResponse> data) {
        realm = Realm.getDefaultInstance();
//        realm.beginTransaction();
//        realm.insertOrUpdate(data);
//        realm.commitTransaction();
//        Log.i(TAG, "saveDatatoRealm: "+mRealmController.getPosts());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showPosts(List<PostResponse> posts) {
//        saveDatatoRealm(posts);
        Log.i(TAG, "showPosts: "+posts);
        AppDatabase
                .getInstance(MainActivity.this)
                .getpostDao()
                .insertAll(posts);
        binding.setData(posts.get(0));
        Log.i(TAG, "just test: " + AppDatabase
                .getInstance(MainActivity.this)
                .getpostDao()
                .getAll());
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {


    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: " + AppDatabase
                .getInstance(MainActivity.this)
                .getpostDao()
                .getAll());
    }

    @Override
    public void showError(String localizedMessage) {
        Snackbar.make(getWindow().getDecorView(), localizedMessage, Snackbar.LENGTH_LONG).show();
    }
}
