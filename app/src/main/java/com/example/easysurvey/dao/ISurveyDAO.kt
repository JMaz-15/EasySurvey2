package com.example.easysurvey.dao

import retrofit2.http.GET


interface ISurveyDAO {

    @GET("")
    fun getAlLResults() : Call<ArrayList<Survey>>
}