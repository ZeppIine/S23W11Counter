package kr.ac.kumoh.ce.s20180147.s23w11counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.autoSaver
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.ce.s20180147.s23w11counter.ui.theme.S23W11CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
//                Clicker()
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Center
                ){
                    Counter()
                    Spacer(modifier = Modifier.height(40.dp))
                    Counter()
                }
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit){
    S23W11CounterTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@Composable
fun Clicker(){
//    var txtString by remember { mutableStateOf("눌러주세요")}
    val (txtString, setTxtString) = remember { mutableStateOf("눌러주세요")}
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = txtString,
            fontSize = 70.sp,
        )
        Button(modifier = Modifier
            .fillMaxWidth(),
            onClick = {
//                txtString = "눌렸습니다"
                setTxtString("눌렸습니다")
            }) {
            Text("'눌러'")
        }
    }
}

@Composable
fun Counter() {
    var intCounter by remember { mutableStateOf(0)}
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "$intCounter",
            fontSize = 70.sp,
        )
        Row {
            Button(
                modifier = Modifier
                    .weight(10f),
                onClick = {
                    intCounter++
                }) {
                Text("올라간다ㅏㅏ")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                modifier = Modifier
                    .weight(10f),
                onClick = {
                    intCounter--
                }) {
                Text("내려간다ㅏㅏ")
            }
        }
    }
}