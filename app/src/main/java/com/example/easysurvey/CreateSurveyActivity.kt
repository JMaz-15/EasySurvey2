package com.example.easysurvey


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.easysurvey.ui.theme.EasySurveyTheme
import androidx.fragment.app.Fragment


class CreateSurveyActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        setContent {
            EasySurveyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SurveySetup("create")
                }
            }
        }

    }

    @Composable
    fun SurveySetup(name: String) {
        var surveyName by remember { mutableStateOf("Enter Survey Name") }
        var question by remember { mutableStateOf("") }
        val context = LocalContext.current
        Column {

            OutlinedTextField(
                value = surveyName,
                onValueChange = { surveyName = it },
                label = { Text(text = stringResource(R.string.surveyName)) }
            )

            val addQuestion: Button = findViewById(R.id.btnAddQuestion)
            addQuestion.setOnClickListener {
                supportFragmentManager.beginTransaction()
                    .add(R.id.addQuestionContainer, AddQuestionFragment())
                    .commitNow()

                val mcQuestion: Button = findViewById(R.id.btnMultipleChoice)
                mcQuestion.setOnClickListener {
                    R.id.textView2.isVisible;

                }


            }



        }
        Column {

            Button(
                onClick =
                {
                    Toast.makeText(context, "$surveyName $question", Toast.LENGTH_LONG).show()
                    //Save the user created survey - will need to appear on the 'Take Survey' and 'Search' screens
                },
                content = { Text(text = "SUBMIT") }
            )
            Button(
                onClick =
                {
                    //Prompt user: "Clear current survey and return to homepage? Yes/No"
                    //if 'No', exit prompt
                    //if 'Yes', Clear all entered data and return to homepage
                },
                content = { Text(text = "CANCEL") }
            )

        }
    }


}




@Preview(showBackground = true)
@Composable
fun DefPreview() {
    EasySurveyTheme {
    }
}
