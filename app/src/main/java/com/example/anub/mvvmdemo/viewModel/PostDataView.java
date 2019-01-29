package com.example.anub.mvvmdemo.viewModel;

import com.example.anub.mvvmdemo.model.PostResponse;

import java.util.List;

public interface PostDataView extends BaseView{


    void showPosts(List<PostResponse> posts);

}
