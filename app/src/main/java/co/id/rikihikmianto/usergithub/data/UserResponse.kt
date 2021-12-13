package co.id.rikihikmianto.usergithub.data

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @field:SerializedName("items")
    val items: ArrayList<User>
)

data class User(
    @field:SerializedName("login")
    val username: String,
    @field:SerializedName("html_url")
    val url: String,
    @field:SerializedName("avatar_url")
    val avatar: String
)

data class DetailUser(
    @field:SerializedName("login")
    val username: String,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("avatar_url")
    val avatar: String,
    @field:SerializedName("followers_url")
    val followers_url: String,
    @field:SerializedName("following_url")
    val following_url: String,
    @field:SerializedName("followers")
    val followers: Int,
    @field:SerializedName("following")
    val following: Int,
    @field:SerializedName("public_repos")
    val repo: Int,
    @field:SerializedName("location")
    val location: String,
    @field:SerializedName("company")
    val company: String,
)
