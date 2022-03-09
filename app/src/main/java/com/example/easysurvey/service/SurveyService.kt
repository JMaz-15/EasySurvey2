package com.example.easysurvey.service

import com.example.easysurvey.RetrofitClientInstance
import com.example.easysurvey.dao.ISurveyDao
import com.example.easysurvey.dto.Survey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

class SurveyService {

    suspend fun fetchSurveys() : List<Survey>? {
        return withContext(Dispatchers.IO) {
            val service = RetrofitClientInstance.retrofitInstance?.create(ISurveyDao::class.java)
            val surveys = async {service?.getAllSurveys()}
            var result = surveys.await()?.awaitResponse()?.body()
            return@withContext result
        }
    }
}