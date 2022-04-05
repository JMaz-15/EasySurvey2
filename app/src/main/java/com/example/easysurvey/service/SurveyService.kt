package com.example.easysurvey.service

import com.example.easysurvey.dao.IEasySurveyDAO
import com.example.easysurvey.dto.Survey
import com.example.easysurvey.ui.theme.RetrofitClientInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

interface IPlantService {
    suspend fun fetchSurveys(): List<Survey>?
}

class SurveyService {
    suspend fun fetchSurveys(): List<Survey>? {
        return withContext(Dispatchers.IO) {
            val retrofit = RetrofitClientInstance.retrofitInstance?.create(IEasySurveyDAO::class.java)
            val easySurveys = async { retrofit?.getAllSurveys() }
            val result = easySurveys.await()?.awaitResponse()?.body()
            return@withContext result
        }
    }
}