package com.example.cleanmvvmapp.presentation.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanmvvmapp.domain.usecases.GetCoinListUseCase
import com.example.cleanmvvmapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinListUseCase: GetCoinListUseCase
): ViewModel() {


    private val _state =  MutableStateFlow(CoinListScreenState())
    val state: StateFlow<CoinListScreenState> = _state.asStateFlow()

    init {
        getCoinList()
    }

    private fun getCoinList(){
        _state.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
            when(val result = getCoinListUseCase()){
                is Resource.Success -> {
                    _state.update {
                        it.copy(isLoading = false, coinList = result.data?: emptyList())
                    }
                }

                is Resource.Error -> {
                    _state.update {
                        it.copy(isLoading = false, errorMessage = "Unable load ur data")
                    }
                }
                is Resource.Loading -> {}
            }
        }
    }
}