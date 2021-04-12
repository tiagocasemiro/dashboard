import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dashboard.R
import com.dashboard.firaSansFamily

//https://www.behance.net/gallery/85077173/Sector-News
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main()
        }
    }

    @Composable
    fun Main() {
        MaterialTheme {
            Scaffold(
                topBar = {
                    TopBar(R.string.app_name)
                }
            ) {
                RowListText(listOf("Política", "Esporte","Cinema", "Lazer"))
            }
        }
    }

    @Composable
    fun RowListText(messages: List<String>) {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),) {
            items(messages) { message ->
                Text(
                    text = message,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = firaSansFamily,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    }

    @Composable
    fun TopBar(@StringRes title: Int) {
        TopAppBar(
            title = {
                Text(
                    stringResource(id = title),
                    fontFamily = firaSansFamily,
                    fontSize = 30.sp,
                    modifier = Modifier.fillMaxWidth().wrapContentWidth(),
                    fontWeight = FontWeight.Bold
                )
            },
            backgroundColor = colorResource(id = R.color.white),
            contentColor = colorResource(id = R.color.black)
        )
    }

    @Preview
    @Composable
    fun Preview() {
        Main()
    }

}