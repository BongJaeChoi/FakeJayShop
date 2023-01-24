package jay.bongjae.fakeshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dagger.hilt.android.AndroidEntryPoint
import jay.bongjae.fakeShop.R
import jay.bongjae.fakeshop.ui.ProductUiState
import jay.bongjae.fakeshop.ui.ProductViewModel
import jay.bongjae.fakeshop.ui.theme.FakeJayShopTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FakeJayShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JayFakeShopApp()
                }
            }
        }
    }
}

@Composable
fun JayFakeShopApp() {
    Greeting(name = "최봉재")
    Products()
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    name: String,
) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Products(
    productViewModel: ProductViewModel = hiltViewModel(),
) {
    val productUiState: ProductUiState by productViewModel.productUiState.collectAsStateWithLifecycle()

    LazyColumn {
        productItem(productUiState)
    }
}

private fun LazyListScope.productItem(productUiState: ProductUiState) {
    when (productUiState) {
        ProductUiState.Loading -> item { Loading() }
        is ProductUiState.Success -> items(
            productUiState.products, key = { item -> item.id },
        ) {
            Row(Modifier.fillMaxWidth()) {
                Text(it.title)
                Spacer(modifier = Modifier.widthIn(8.dp))
                Text("${it.id}")
            }
        }
    }
}

@Composable
fun Loading() {
    CircularProgressIndicator(progress = 0.5f, color = colorResource(id = R.color.purple_500))
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FakeJayShopTheme {
        JayFakeShopApp()
    }
}
