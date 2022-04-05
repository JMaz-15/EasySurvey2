package com.example.easysurvey.dao

import com.example.easysurvey.dto.Survey
import retrofit2.http.GET

//dont forget to add an import for it
interface IEasySurveyDAO {
    //dont forget json from url
    @GET("")
    //change list if this isn't name of it
    fun getAllSurveys(): Call<List<Survey>>
}

