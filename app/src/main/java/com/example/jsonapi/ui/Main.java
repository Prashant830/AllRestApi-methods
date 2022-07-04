package com.example.jsonapi.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.example.jsonapi.apimanager.Api;
import com.example.jsonapi.apimanager.ApiResponse;
import com.example.jsonapi.apimanager.RxApi;
import com.example.jsonapi.models.CommentModel;
import com.example.jsonapi.models.PostModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;
import jsonapi.R;

public class Main extends AppCompatActivity {
    private TextView text;
    Api api = ApiResponse.getApi();
    RxApi rxApi = ApiResponse.getRxApi();
    final static String TAG = "Main";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        text = findViewById(R.id.recycle);
    }
/*
 // for simple api call  ......
    public void openApi(View view) {

        forSimple();
        //forPath();
          //forCommentPath();
         //forCommentQuery();
        //forCommentQueryMap();
        //forPostUsingBody();
        //forPostAtPath();
         //forPutAtPAth();
        //forPatchAtPath();
    }
    private void forPatchAtPath() {
        PostModel post = new PostModel();
           //post.setUserId(null);
        //post.setTitle(null);
        post.setBody("Pk is always ready to learn");
        Call<PostModel> call = api.patchPostAtPathId(3,post);
        call.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                if (response.isSuccessful()) {
                    PostModel post = response.body();
                    showPost(post);

                }
                Toast.makeText(Main.this, response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {
                Toast.makeText(Main.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void forPutAtPAth() {
        PostModel post = new PostModel();
        post.setUserId(12);
        post.setTitle("pkOnline");
        post.setBody("Pk is always ready to learn");

        Call<PostModel> call = api.updatePostAtPathId(5, post);
        call.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                if (response.isSuccessful()) {
                    PostModel post = response.body();
                    ;
                    showPost(post);

                }
                Toast.makeText(Main.this, response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {
                Toast.makeText(Main.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void forPostAtPath() {
        CommentModel comment = new CommentModel();
        comment.setPostId(12);
        comment.setEmail("pk@gmail.com");
        comment.setName("Prashant");
        comment.setBody("Pk is always ready to learn");

        Call<CommentModel> call = api.setPostAtPath(5,comment);
        call.enqueue(new Callback<CommentModel>() {
            @Override
            public void onResponse(Call<CommentModel> call, Response<CommentModel> response) {
                if(response.isSuccessful()){
                        CommentModel comment = response.body();
                        showPostForComment(comment);
                    }
                Toast.makeText(Main.this, response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CommentModel> call, Throwable t) {
                Toast.makeText(Main.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void forPostUsingBody() {
        PostModel post = new PostModel();
        post.setUserId(12);
        post.setTitle("pkOnline");
        post.setBody("Pk is always ready to learn");

        Call<PostModel> call = api.setPost(post);
        call.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                if (response.isSuccessful()){
                    PostModel post = response.body();;
                    showPost(post);

                }
                Toast.makeText(Main.this,response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {
                Toast.makeText(Main.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void forCommentQueryMap() {
        Map<String,Integer> m = new HashMap<>();
        m.put("postId",1);
        m.put("id",4);

        Call<List<CommentModel>> call = api.getCommentOnTheBasisOfQueryMap(m);
        call.enqueue(new Callback<List<CommentModel>>() {
            @Override
            public void onResponse(Call<List<CommentModel>> call, Response<List<CommentModel>> response) {
                if(response.isSuccessful()){
                    for (CommentModel comment : response.body()){
                        showPostForComment(comment);
                    }
                }
                Toast.makeText(Main.this, response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<CommentModel>> call, Throwable t) {
                Toast.makeText(Main.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void forCommentQuery() {
        Call<List<CommentModel>> call = api.getCommentOnTheBasisOfQuery(6);
        call.enqueue(new Callback<List<CommentModel>>() {
            @Override
            public void onResponse(Call<List<CommentModel>> call, Response<List<CommentModel>> response) {
                if(response.isSuccessful()){
                    for (CommentModel comment : response.body()){
                        showPostForComment(comment);
                    }
                }
                Toast.makeText(Main.this, response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<CommentModel>> call, Throwable t) {
                Toast.makeText(Main.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void forCommentPath() {
        Call<List<CommentModel>> call = api.getComment(2);
        call.enqueue(new Callback<List<CommentModel>>() {
            @Override
            public void onResponse(Call<List<CommentModel>> call, Response<List<CommentModel>> response) {
                 if(response.isSuccessful()){
                     for (CommentModel comment : response.body()){
                         showPostForComment(comment);
                     }
                 }
                Toast.makeText(Main.this, response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<CommentModel>> call, Throwable t) {
                Toast.makeText(Main.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void forSimple() {
                Call<List<PostModel>> call = api.getPost();

        call.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {

                if (response.isSuccessful()) {
                    for (PostModel post : response.body()) {
                        showPost(post);
                    }
                }
                Toast.makeText(Main.this, response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Toast.makeText(Main.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void forPath() {
        Call<PostModel> call1 = api.getPostOnBasisOfId(2);
        call1.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                if (response.isSuccessful()){
                    PostModel post = response.body();;
                        showPost(post);

                }
                Toast.makeText(Main.this,response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {
                Toast.makeText(Main.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

     // for simple api call end ......

*/

     /// for observer api calling...

    public void openApi(View view) {
        //forSimpleRx();
        // forPathRx();
       forCommentPathRx();
    }
    private void forSimpleRx() {
        Observable<List<PostModel>> observable = rxApi.getPostRx();
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<PostModel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe: Subscribe Successful");
            }

            @Override
            public void onNext(@NonNull List<PostModel> PostModels) {
                for (PostModel post : PostModels) {
                    showPost(post);
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Toast.makeText(Main.this,e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: Complete Successful");
            }
        });
    }
    private void forPathRx() {
        Observable<PostModel> observable = rxApi.getPostOnBasisOfIdRx(2);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<PostModel>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull PostModel postModels) {
                PostModel post = postModels;
                showPost(post);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    private void forCommentPathRx() {
        Observable<List<CommentModel>> observable = rxApi.getCommentRx(5);
        observable.subscribeOn(Schedulers.io()).filter(new Predicate<List<CommentModel>>() {
            @Override
            public boolean test(List<CommentModel> CommentModels) throws Throwable {
                Log.d(TAG, Thread.currentThread().getName());
                return !CommentModels.isEmpty();
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<CommentModel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<CommentModel> CommentModels) {
                Log.d(TAG, Thread.currentThread().getName());
                for (CommentModel comment : CommentModels) {
                    showPostForComment(comment);
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

          /// for observer api calling...

    public void showPost(PostModel post){
        text.append("UserId - " + post.getUserId() + "\n");
        text.append("Tittle - " + post.getTitle() +"\n");
        text.append("Id - " + post.getId()+"\n");
        text.append("Body - " + post.getBody() + "\n");
        text.append("\n");

    }

    public void showPostForComment(CommentModel post){
        text.append("PostId - " + post.getPostId() + "\n");
        text.append("Name - " + post.getName() +"\n");
        text.append("Id - " + post.getId()+"\n");
        text.append("Body - " + post.getBody() + "\n");
        text.append("E-mail - " + post.getEmail() + "\n");
        text.append("\n");

    }

    public void clearApi(View view) {
        text.setText("");
    }
}