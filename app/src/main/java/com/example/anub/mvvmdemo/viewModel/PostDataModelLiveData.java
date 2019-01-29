package com.example.anub.mvvmdemo.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.anub.mvvmdemo.api.APIClient;
import com.example.anub.mvvmdemo.api.ApiInterface;
import com.example.anub.mvvmdemo.model.PostResponse;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostDataModelLiveData extends AndroidViewModel {

    private final ApiInterface mApi;
    private final MutableLiveData<List<PostResponse>> mObResponse = new MutableLiveData<>();

    public PostDataModelLiveData(@NonNull Application application) {
        super(application);
        mApi = APIClient.getRetrofitInstance().create(ApiInterface.class);
//            mObResponse=mApi.getLiveAllPosts().;
        mApi.getAllPosts().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .subscribe(new io.reactivex.Observer<List<PostResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<PostResponse> value) {
                        mObResponse.setValue(value);
                    }

                    @Override
                    public void onError(Throwable e) {


                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    public LiveData<List<PostResponse>> getLivePosts() {
        return mObResponse;
    }
}
