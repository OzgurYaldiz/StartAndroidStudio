package com.example.artcollection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.artcollection.ui.theme.ArtCollectionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtCollectionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ViewApp()
                }
            }
        }
    }
}


@Composable
fun ViewApp() {
    var step by remember {
        mutableStateOf(1)
    }
    Scaffold (containerColor = MaterialTheme.colorScheme.primaryContainer){
            innerPadding->
        Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(MaterialTheme.colorScheme.tertiaryContainer),
            color= MaterialTheme.colorScheme.primaryContainer
        ){

            when(step){
                1-> LayOutDesign(
                    drawableResourceId =R.drawable.robot1 ,
                    artWorkTitleResourceId = R.string.ishock_made_painter_robot_1,
                    artistYearResourceId = R.string.ishock_2024_1,
                    stepId = "Step 1",
                    onClickMinus = {step=1},
                    onClickPlus = {step++}
                )
                2-> LayOutDesign(
                    drawableResourceId =R.drawable.robot2 ,
                    artWorkTitleResourceId = R.string.ishock_made_painter_robot_2,
                    artistYearResourceId = R.string.ishock_2024_2,
                    stepId ="Step 2",
                    onClickMinus = {step--},
                    onClickPlus = {step++}
                )
                3-> LayOutDesign(
                    drawableResourceId =R.drawable.robot3,
                    artWorkTitleResourceId =R.string.ishock_made_painter_robot_3 ,
                    artistYearResourceId = R.string.ishock_2024_3,
                    stepId ="Step 3" ,
                    onClickMinus = {step--},
                    onClickPlus = {step=3}
                )

            }
        }


    }

}

@Composable
fun LayOutDesign(drawableResourceId:Int,
           artWorkTitleResourceId:Int,
           artistYearResourceId:Int,
           stepId:String,
           onClickMinus:()->Unit,
           onClickPlus:()->Unit,
           modifier: Modifier = Modifier.fillMaxSize()) {

    Column (horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier=Modifier.fillMaxSize()){
        Box(modifier = Modifier.weight(5f)){
            Image(painter = painterResource(drawableResourceId) , contentDescription =stepId )
        }
        Text(text = stringResource(artWorkTitleResourceId), fontSize = 16.sp)
        Text(text = stringResource(artistYearResourceId), fontSize = 14.sp, fontWeight = FontWeight.Bold)

        Row (modifier=Modifier.weight(1f)){
            Button(onClick = onClickMinus ) {
                Image(painter = painterResource(R.drawable.previous_24), contentDescription = stepId )
                
            }
            Button(onClick = onClickPlus) {
                Image(painter = painterResource(R.drawable.next_24), contentDescription = stepId )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtCollectionTheme {
        ViewApp()
    }
}