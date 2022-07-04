package com.example.jsonapi.apimanager;

import com.example.jsonapi.models.CommentModel;
import com.example.jsonapi.models.PostModel;

import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.core.Observable;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface RxApi {
    @GET("posts")
    Observable<List<PostModel>> getPostRx();

    @GET("posts/{id}/")
    Observable<PostModel> getPostOnBasisOfIdRx(@Path("id") int id);

    @GET("posts/{postId}/comments")
    Observable<List<CommentModel>> getCommentRx(@Path("postId") int postId);

    //comments?postId=1
    @GET("comments")
    Observable<List<CommentModel>> getCommentOnTheBasisOfQueryRx(@Query("postId") int postId);

    //comments?postId=1&id=4
    @GET("comments")
    Observable<List<CommentModel>> getCommentOnTheBasisOfQueryMapRx(@QueryMap Map<String,Integer> map);

    @POST("posts")
    Observable<PostModel> setPostRx(@Body PostModel post);

    @POST("posts/{postId}/comments")
    Observable<CommentModel> setPostAtPathRx(@Path("postId") int postId, @Body CommentModel comment);

    @PUT("posts/{id}/")
    Observable<PostModel> updatePostAtPathIdRx(@Path("id") int id, @Body PostModel post);

    @PATCH("posts/{id}/")
    Observable<PostModel> patchPostAtPathIdRx(@Path("id") int id, @Body PostModel post);
}
