package com.example.compose_quadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_quadrant.ui.theme.Compose_QuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_QuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeFramer(
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeFramer(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = modifier.weight(1f)

        ) {
            ComposeCardTL(Modifier.weight(1f))
            ComposeCardTR(Modifier.weight(1f))
        }
        Row(
            modifier = modifier.weight(1f),

            ) {
            ComposeCardBL(Modifier.weight(1f))
            ComposeCardBR(Modifier.weight(1f))
        }
    }

}

@Composable
fun ComposeCardTL(modifier: Modifier = Modifier) {
    ComposeCard(
        modifier = modifier,
        title = stringResource(id = R.string.text_composable),
        longDescription = stringResource(id = R.string.text_composable_description),
        backgroundColor = colorResource(id = R.color.first_color)
    )
}

@Composable
fun ComposeCardTR(modifier: Modifier = Modifier) {
    ComposeCard(
        modifier = modifier,
        title = stringResource(id = R.string.image_composable),
        longDescription = stringResource(id = R.string.image_composable_description),
        backgroundColor = colorResource(id = R.color.second_color)
    )
}

@Composable
fun ComposeCardBL(modifier: Modifier = Modifier) {
    ComposeCard(
        modifier = modifier,
        title = stringResource(id = R.string.row_composable),
        longDescription = stringResource(id = R.string.row_composable_description),
        backgroundColor = colorResource(id = R.color.third_color)
    )
}

@Composable
fun ComposeCardBR(modifier: Modifier = Modifier) {
    ComposeCard(
        modifier = modifier,
        title = stringResource(id = R.string.column_composable),
        longDescription = stringResource(id = R.string.column_composable_description),
        backgroundColor = colorResource(id = R.color.fourth_color)
    )
}

@Composable
fun ComposeCard(
    title: String,
    longDescription: String,
    backgroundColor: Color = Color.Green,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.background(backgroundColor)
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
        )
        Text(
            text = longDescription,
            textAlign = TextAlign.Justify,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_QuadrantTheme {
        ComposeFramer()
    }
}