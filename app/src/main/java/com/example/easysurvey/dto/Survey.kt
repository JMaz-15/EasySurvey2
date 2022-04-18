package com.example.easysurvey.dto


import com.google.gson.annotations.SerializedName

class SurveyService {
}
data class Survey (@SerializedName("Code") var code : String, @SerializedName("Name") var name: String)
{
    override fun toString(): String
    {
        return "$name $code"
    }
}
//edit to return survey results