package com.example.cleanmvvmapp.presentation.coin_list.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cleanmvvmapp.R
import com.example.cleanmvvmapp.domain.model.Coin
import com.example.cleanmvvmapp.presentation.coin_list.CoinListViewModel
import com.example.cleanmvvmapp.utils.TestTag.COIN_LIST_CIRCULAR_PROGRESS
import com.example.cleanmvvmapp.utils.TestTag.COIN_LIST_ITEM_STATUS
import com.example.cleanmvvmapp.utils.TestTag.COIN_LIST_ITEM_TITLE
import com.example.cleanmvvmapp.utils.TestTag.COIN_LIST_VIEW

@Composable
fun CoinListScreen(
    coinListViewModel: CoinListViewModel = hiltViewModel()
) {

    val state = coinListViewModel.state.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        if (state.value.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(modifier = Modifier.testTag(COIN_LIST_CIRCULAR_PROGRESS))
            }
        }

        if (state.value.coinList.isNotEmpty()) {

            LazyColumn(Modifier.fillMaxSize().
            testTag(COIN_LIST_VIEW))
            {
                items(state.value.coinList) { item: Coin ->
                    CoinItem(item)
                    HorizontalDivider()
                }
            }

        }

        if (state.value.errorMessage.isNotEmpty()) {
            Text(
                text = stringResource(id = R.string.unable_load_data),
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .align(Alignment.BottomCenter)
            )
        }
    }

}

@Composable
fun CoinItem(
    coin: Coin
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            modifier = Modifier
                .weight(1f).testTag(COIN_LIST_ITEM_TITLE)
        )

        Text(
            text = if (coin.isActive) stringResource(id = R.string.active) else stringResource(id = R.string.inactive),
            style = MaterialTheme.typography.bodySmall,
            color = if (coin.isActive) Color.Green else Color.Red,
            modifier = Modifier.testTag(COIN_LIST_ITEM_STATUS)
        )

    }
}