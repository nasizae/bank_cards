package com.example.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {

                Text(
                    text = "Вход",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 100.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                TextFieldColors()
            }
        }
    }
}

@Composable
fun TextFieldColors() {
    var textEmail by remember {
        mutableStateOf("")
    }
    var textPassword by remember {
        mutableStateOf("")
    }
    var Onclick by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(
                    1.dp,
                    color = if (Onclick) Color.Red else Color.Black,
                    RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp)),
            placeholder = {
                Text(text = stringResource(R.string.email)  )
            },
            value = textEmail,
            onValueChange = { textEmail = it })
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
                .border(
                    1.dp,
                    color = if (Onclick) Color.Red else Color.Black,
                    shape = RoundedCornerShape(16.dp)
                ),
            placeholder = {
                Text(text = stringResource(R.string.password))
            },
            value = textPassword,
            onValueChange = { textPassword = it })

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .padding(vertical = 20.dp, horizontal = 20.dp)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            onClick = { Onclick = true }

        ) {
            Text(
                text = stringResource(R.string.sign_in),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

