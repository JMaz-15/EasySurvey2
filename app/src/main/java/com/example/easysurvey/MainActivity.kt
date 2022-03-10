package com.example.easysurvey

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.easysurvey.ui.theme.EasySurveyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EasySurveyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    homepageButtons()
                }
            }
        }
    }
}

@Composable
fun homepageButtons() {
    val text = "You clicked this button"
    val duration = Toast.LENGTH_LONG
    val context = LocalContext.current
    Column(
        Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween)
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .padding(vertical = 30.dp, horizontal = 30.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = TextStyle(fontSize = 40.sp)
                )
                Text(
                    text = stringResource(id = R.string.app_description),
                    style = TextStyle(fontSize = 13.sp)
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ){
            Button(onClick = {
                Toast.makeText(context, text, duration).show()
            },
                shape = RoundedCornerShape(20.dp)
            ) {
                Image(
                    painterResource(id = R.drawable.ic_baseline_create_24),
                    contentDescription = "Pencil icon",
                    modifier = Modifier.size(20.dp)
                )
                Text(text = "Take a Survey", Modifier.padding(start = 10.dp))
            }

            Button(onClick = {
                Toast.makeText(context, text, duration).show()
            },
                shape = RoundedCornerShape(20.dp)
            ) {
                Image(
                    painterResource(id = R.drawable.ic_baseline_add_circle_24),
                    contentDescription = "Add icon",
                    modifier = Modifier.size(20.dp)
                )
                Text(text = "Create a Survey", Modifier.padding(start = 10.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun defaultPreview() {
    EasySurveyTheme {
    }
}