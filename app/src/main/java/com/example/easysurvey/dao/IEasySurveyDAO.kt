package com.example.easysurvey.dao

//dont forget to add an import for it
interface IEasySurveyDAO {
    //dont forget json from url
    @GET("")
    //change list if this isn't name of it
    fun getAllSurveys(): Call<List<Survey>>
}

