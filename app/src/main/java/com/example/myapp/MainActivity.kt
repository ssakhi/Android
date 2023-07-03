package com.example.myapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CardImage()
                CardContent()
                CardButton()
            }
        }
    }
}

@Composable
private fun CardButton() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Button(onClick = {
        buttonClickedState.value = !buttonClickedState.value
    }) {
        Text(text = "Portfolio")
    }
    if(buttonClickedState.value) {
        PortfolioContainer()
    }else {
        Box{}
    }
}

@Composable
private fun CardContent() {
    Divider(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        thickness = 3.dp,
        color = MaterialTheme.colorScheme.onSurface
    )
    Column() {
        Text(
            text = "Miles P",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Android Compose Programmer",
        )
        Text(
            text = "Y'aready know"
        )
    }
}

@Composable
private fun CardImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(.5.dp, androidx.compose.ui.graphics.Color.LightGray),
        tonalElevation = 9.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            modifier = modifier.size(135.dp),
            contentDescription = "Profile Image",
        )
    }
}

@Composable
fun PortfolioContainer() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(4.dp)
    ){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = androidx.compose.ui.graphics.Color.LightGray)
        ) {
            PortfolioList(data = listOf("Project 1", "Project 2", "Project 3"))
        }
    }
}

@Composable
fun PortfolioList(data: List<String>) {
    LazyColumn{
        items(data) { item ->
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                shape = RectangleShape
            ){
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(16.dp)
                ){
                    CardImage(modifier = Modifier.size(100.dp))
                    Column(modifier = Modifier
                        .padding(7.dp)
                        .align(alignment = Alignment.CenterVertically)
                    ){
                        Text(item, fontWeight = FontWeight.Bold)
                        Text(text = "A great Project")
                    }
                }
            }
        }
    }
}