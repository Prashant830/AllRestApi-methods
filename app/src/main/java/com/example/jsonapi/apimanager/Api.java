package com.example.jsonapi.apimanager;

import com.example.jsonapi.models.CommentModel;
import com.example.jsonapi.models.PostModel;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface Api {

    @GET("posts")
    Call<List<PostModel>> getPost();

    @GET("posts/{id}/")
    Call<PostModel> getPostOnBasisOfId(@Path("id") int id);

    @GET("posts/{postId}/comments")
    Call<List<CommentModel>> getComment(@Path("postId") int postId);

    //comments?postId=1
    @GET("comments")
    Call<List<CommentModel>> getCommentOnTheBasisOfQuery(@Query("postId") int postId);

    //comments?postId=1&id=4
    @GET("comments")
    Call<List<CommentModel>> getCommentOnTheBasisOfQueryMap(@QueryMap Map<String,Integer> map);

    @POST("posts")
    Call<PostModel> setPost(@Body PostModel post);

    @POST("posts/{postId}/comments")
    Call<CommentModel> setPostAtPath(@Path("postID") int postId, @Body CommentModel comment);

    @PUT("posts/{id}/")
    Call<PostModel> updatePostAtPathId(@Path("id") int id, @Body PostModel post);

    @PATCH("posts/{id}/")
    Call<PostModel> patchPostAtPathId(@Path("id") int id, @Body PostModel post);

}
