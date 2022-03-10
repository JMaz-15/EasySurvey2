package com.example.easysurvey.ui.theme;
//may need to fix imports
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easysurvey.dao.IEasySurveyDAO;
import com.example.easysurvey.service.SurveyService;
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import kotlinx.coroutines.launch

class MainViewModel (var easysurvey:IEasySurveyDAO =SurveyService()) : ViewModel() {
    val Survey:MutableLiveData<List<Survey>>=MutableLiveData<List<Survey>>()

private lateinit var firestore:FirebaseFirestore

        //only reason not working is because the import is going through for firebase
        init{
        firestore=FirebaseFirestore.getInstance()
        firestore.firestoreSettings=FirebaseFirestoreSettings.Builder().build()
        }

        //add a fetch function here
}