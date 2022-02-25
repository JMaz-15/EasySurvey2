package com.example.easysurvey

import android.os.Bundle
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

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        setContent {
            EasySurveyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    SurveySetup("create")
                }
            }
        }
    }
}

@Composable
fun SurveySetup(name:String)
{
    var surveyName by remember { mutableStateOf("Enter Survey Name")}
    var question by remember { mutableStateOf("Enter a question")}
    val context = LocalContext.current
    Column{

        OutlinedTextField(
            value = surveyName,
            onValueChange = { surveyName = it },
            label = { Text(stringResource(R.string.surveyName)) }
            )
        OutlinedTextField(
            value = question,
            onValueChange = { question = it },
            label = { Text(text = stringResource(R.string.Question))}
            )

        Text(text = "Select Response Type:")

    Row{
            Button(
                onClick =
                {
                //populate a field for the user to enter a multiple choice answer, and an option to add additional answer choices
                //save the answer options, store them as radio buttons to populate on the 'Take Survey' page
                },
                content = { Text(text = "Multiple Choice")}
                  )
            Button(
                onClick =
                {
                    //save response selection for the question to populate an editable text field on the 'Take Survey' page
                    // ??? populate editable text field for the user to enter the correct response, save the response
                },
                content = { Text(text = "Typed Response")}
                  )

       }

         }
    Column {
        Button(
            onClick =
            {
                //Add Question: save and clear the previously created question/options/correct answer
                //The only info that should remain on screen is the 'Survey Name'
            },
            content = { Text(text = "ADD A QUESTION") }
        )
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







@Preview(showBackground = true)
@Composable
fun DefPreview() {
    EasySurveyTheme {
    }
}

