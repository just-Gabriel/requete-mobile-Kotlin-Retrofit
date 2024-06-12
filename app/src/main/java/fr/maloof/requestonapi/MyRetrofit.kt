package fr.maloof.requestonapi


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface MyRetrofit {

    @GET("experiences/")
    fun getExperiences(): Call<List<Experience>>

    @POST("Experience/")
    fun createExperience(@Body experience: Experience): Call<Experience>

    @DELETE("Experience/{id}")
    fun deleteExperience(@Path("id") id: Int): Call<Void>
}
