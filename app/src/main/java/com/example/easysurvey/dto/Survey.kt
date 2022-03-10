package com.example.easysurvey.dto
//may have to fix the import
import com.google.gson.annotations.SerializedName

//change the names if you guys don't like it.. also @serialized allows to get lower case information
data class Survey (@SerializedName("Survey1")var Survey1 : String, @SerializedName("Survey2")var Survey2 : String){
    override fun toString() : String{
        return "$Survey1 $Survey2"
    }
}