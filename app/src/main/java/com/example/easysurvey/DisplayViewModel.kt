package com.example.easysurvey



import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DisplayViewModel : ViewModel() {


    var surveys : MutableLiveData<List<Survey>> = MutableLiveData<List<Survey>>()
    var surveyService : SurveyService = SurveyService()


    fun fetchSurveys() {
        viewModelScope.launch{
            var innerCountries = surveyService.fetchSurveys()
            surveys.postValue(innerSurveys)
        }
    }
}