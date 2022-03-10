package com.example.easysurvey.service

import com.example.easysurvey.dao.IEasySurveyDAO
import com.example.easysurvey.dto.Survey
import com.example.easysurvey.ui.theme.RetrofitClientIstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class SurveyService {
    suspend fun fetchSurveys(): List<Survey>? {
        return withContext(Dispatchers.IO) {
            val retrofit = RetrofitClientIstance.retrofitInstance?.create(IEasySurveyDAO::class.java)
            //start of the async and await
            val easySurveys = async { retrofit?.getAllSurveys() }
            val result = easySurveys.await()?.awaitResponse()?.body()
            return@withContext result
        }
    }
}