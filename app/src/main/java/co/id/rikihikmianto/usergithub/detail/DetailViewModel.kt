package co.id.rikihikmianto.usergithub.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.id.rikihikmianto.usergithub.api.ApiClient
import co.id.rikihikmianto.usergithub.data.DetailUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel() {
    val detailUser = MutableLiveData<DetailUser>()

    fun setDetailUser(username: String?) {
        ApiClient.apiService.getDetailUser(username).enqueue(object : Callback<DetailUser> {
            override fun onResponse(call: Call<DetailUser>, response: Response<DetailUser>) {
                if (response.isSuccessful) {
                    detailUser.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<DetailUser>, t: Throwable) {
                Log.d("Failure", t.message.toString())
            }
        })
    }

    fun getDetailUser(): LiveData<DetailUser> {
        return detailUser
    }
}