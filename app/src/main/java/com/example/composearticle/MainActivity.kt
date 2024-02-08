package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticleImage(
                        getString(R.string.article_title),
                        getString(R.string.first_para),
                        getString(R.string.second_para)
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleText(heading: String, description: String, article: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = heading,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                )

        )
        Text(
            text = article,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
        )
    }
}

@Composable
fun ArticleImage(
    heading: String,
    description: String,
    article: String
) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = "Article Background"
        )
        ArticleText(
            heading = heading,
            description = description,
            article = article
        )
    }

}


@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    val context = LocalContext.current
    ComposeArticleTheme {
        ArticleImage(
            context.getString(R.string.article_title),
            context.getString(R.string.first_para),
            context.getString(R.string.second_para)
        )
    }
}