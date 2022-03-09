package com.example.easysurvey.dao

import com.example.easysurvey.dto.Survey
import retrofit2.Call
import retrofit2.http.GET

interface ISurveyDao {

    @GET("example/website")
    fun getAllSurveys() : Call<ArrayList<Survey>>
}