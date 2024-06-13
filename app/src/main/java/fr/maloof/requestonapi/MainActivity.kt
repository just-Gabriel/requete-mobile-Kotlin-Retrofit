package fr.maloof.requestonapi



import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Objects

class MainActivity : AppCompatActivity() {


    // URL de l'API mais le bon!!!!!!!!
    //private val BASE_URL = "http://localhost:8000/api/"



    private val TAG: String = "CHECK_RESPONSE"
    private lateinit var recyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // ******************   OUBLI PAS D' APPELER LES FONCTIONSSSSSSS *******************


        getAllExperiences()
        // deleteExperience(1)
        //createExperience()



    }

    private fun getAllExperiences() {

        val url = "http://192.168.1.3:8000/api/"

        val api = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyRetrofit::class.java)

        api.getExperiences().enqueue(object : Callback<List<Experience>> {
            override fun onResponse(
                call: Call<List<Experience>>,
                response: retrofit2.Response<List<Experience>>
            ) {
                if (response.isSuccessful) {
                    Log.i(TAG, response.body().toString())
                    response.body()?.let { experiences ->
                        recyclerView.adapter = ExperienceAdapter(experiences)
                    }
                } else {
                    Log.i(TAG, "onResponse: Response not successful")
                }
            }

            override fun onFailure(call: Call<List<Experience>>, t: Throwable) {
                Log.i(TAG, "onFailure: ${t.message}")
            }
        })
    }

    private fun createExperience(experience: Experience) {
        val url = "http://192.168.1.3:8000/api/"
        val api = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyRetrofit::class.java)

        api.createExperience(experience).enqueue(object : Callback<Experience> {
            override fun onResponse(call: Call<Experience>, response: retrofit2.Response<Experience>) {
                if (response.isSuccessful) {
                    Log.i(TAG, "onResponse: Experience created successfully")
                } else {
                    Log.i(TAG, "onResponse: Failed to create experience")
                }
            }

            override fun onFailure(call: Call<Experience>, t: Throwable) {
                Log.i(TAG, "onFailure: ${t.message}")
            }
        })
    }

    private fun deleteExperience(id: Int) {
        val url = "http://192.168.1.3:8000/api/"
        val api = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyRetrofit::class.java)

        api.deleteExperience(id).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: retrofit2.Response<Void>) {
                if (response.isSuccessful) {
                    Log.i(TAG, "onResponse: Experience deleted successfully")
                } else {
                    Log.i(TAG, "onResponse: Failed to delete experience")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.i(TAG, "onFailure: ${t.message}")
            }
        })
    }
}
