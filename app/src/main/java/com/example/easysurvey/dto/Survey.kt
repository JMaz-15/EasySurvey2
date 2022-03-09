package com.example.easysurvey.dto

import com.google.gson.annotations.SerializedName

data class Survey(@SerializedName("title")var title: String,
                  @SerializedName("question1")var question1: String,
                @SerializedName("numberOfQuestions")var numberOfQuestions: Int){

    override fun toString(): String {
        return title
    }

} //End of DataClass