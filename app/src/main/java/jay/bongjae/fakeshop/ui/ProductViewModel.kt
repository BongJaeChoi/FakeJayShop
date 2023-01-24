package jay.bongjae.fakeshop.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jay.bongjae.data.repository.ProductRepository
import jay.bongjae.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _productUiState = MutableStateFlow<ProductUiState>(ProductUiState.Loading)
    val productUiState: StateFlow<ProductUiState> = _productUiState

    init {
        viewModelScope.launch {
            productRepository.getProduct()
                .onStart { _productUiState.value = ProductUiState.Loading }
                .collect {
                    _productUiState.value = ProductUiState.Success(it)

                }
        }
    }

}

sealed interface ProductUiState {
    object Loading : ProductUiState
    data class Success(val products: List<Product>) : ProductUiState
}
