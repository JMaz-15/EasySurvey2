package com.example.easysurvey.ui.theme

object RetrofitClientIstance {
    private var retrofit: Retrofit? = null
    //add the url here
    private val BASE_URL = ""

    val retrofitInstance : Retrofit?
        get(){
            //has this object been created yet?
            if (retrofit == null)
            {
                //create it
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}