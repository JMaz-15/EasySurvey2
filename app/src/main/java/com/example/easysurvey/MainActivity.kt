package com.example.easysurvey

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.easysurvey.ui.theme.EasySurveyTheme

    class MainActivity : AppCompatActivity() {



        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                EasySurveyTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {




                        val createButton: Button = findViewById(R.id.create)
                        createButton.setOnClickListener{
                            val intentCreate=Intent(this,CreateSurveyActivity::class.java)
                            startActivity(intentCreate)
                        }
                        val buttonTake: Button = findViewById(R.id.take)
                        buttonTake.setOnClickListener{
                            val intentTake = Intent(this,TakeSurveyActivity::class.java)
                            startActivity(intentTake)
                        }
                        val buttonResults: Button=findViewById(R.id.results)
                        buttonResults.setOnClickListener{
                            val intentResults=Intent(this,DisplayResultsActivity::class.java)
                            startActivity(intentResults)
                        }
                    }
                }
            }

        }
    }


@Composable
fun DefaultPreview() {
    EasySurveyTheme {
    }
}