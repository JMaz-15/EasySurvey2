package com.example.easysurvey.dto
import com.google.gson.annotations.SerializedName

data class Survey (@SerializedName("Survey1")var Survey1 : String, @SerializedName("Survey2")var Survey2 : String){
    override fun toString() : String{
        return "$Survey1 $Survey2"
    }
}