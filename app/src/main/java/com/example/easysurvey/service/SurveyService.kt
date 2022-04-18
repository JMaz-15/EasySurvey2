package com.example.easysurvey.service

import com.example.easysurvey.RetrofitClientInstance

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

class SurveyService {

    suspend fun fetchSurveys() : List<Survey>? {
        return withContext(Dispatchers.IO) {
            val service = RetrofitClientInstance.retrofitInstance?.create(ISurveyDAO::class.java)
            val countries = async {service?.getAlLCountries()}
            var result = surveys.await()?.awaitResponse()?.body()
            return@withContext result
        }
    }
}