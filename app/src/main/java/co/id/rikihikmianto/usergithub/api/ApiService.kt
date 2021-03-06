package co.id.rikihikmianto.usergithub.api

import co.id.rikihikmianto.usergithub.data.DetailUser
import co.id.rikihikmianto.usergithub.data.User
import co.id.rikihikmianto.usergithub.data.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearch(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getDetailUser(
        @Path("username") username: String?
    ): Call<DetailUser>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(
        @Path("username") username: String
    ):Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(
        @Path("username") username: String
    ):Call<ArrayList<User>>
}