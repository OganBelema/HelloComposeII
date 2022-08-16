package com.oganbelema.hellocomposeii

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oganbelema.hellocomposeii.ui.theme.HelloComposeIITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloComposeIITheme {
                MyApp()
            }
        }
    }
}

@Composable
private fun MyApp() {
    var moneyCounter by remember {
        mutableStateOf(0)
    }

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF546E7A)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "€$moneyCounter", style = TextStyle(
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            ))
            Spacer(modifier = Modifier.height(130.dp))
            CreateCircle(moneyCounter) { newValue ->
                moneyCounter = newValue
            }
        }

    }
}

@Preview
@Composable
private fun CreateCircle(moneyCounter: Int, updateMoneyCounter: (Int) -> Unit ) {
    Card( modifier = Modifier
        .padding(4.dp)
        .size(105.dp)
        .clickable {
           updateMoneyCounter(moneyCounter + 1)
        },
    shape = CircleShape,
    elevation = 6.dp) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "Tap")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HelloComposeIITheme {
        MyApp()
    }
}