package com.example.cleanmvvmapp.presentation.coin_list

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performScrollToIndex
import com.example.cleanmvvmapp.di.AppModule
import com.example.cleanmvvmapp.presentation.core.MainActivity
import com.example.cleanmvvmapp.utils.Constants.MAX_DELAY_UI_TESTING
import com.example.cleanmvvmapp.utils.TestTag
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalTestApi::class)
@HiltAndroidTest
@UninstallModules(AppModule::class)
class CoinListTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val activityComposeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun testLoadingIndicatorDisplayed() {
        activityComposeRule.apply {
            onNodeWithTag(TestTag.COIN_LIST_CIRCULAR_PROGRESS).assertIsDisplayed()
        }
    }

    @Test
    fun testCoinListDisplayed() = runTest {
        activityComposeRule.apply {
            waitUntilNodeCount(hasTestTag(TestTag.COIN_LIST_VIEW), 1, MAX_DELAY_UI_TESTING)
            onNodeWithTag(TestTag.COIN_LIST_VIEW).assertIsDisplayed()
        }
    }

    @Test
    fun testCoinListScrollable() = runTest {
        activityComposeRule.apply {
            waitUntilNodeCount(hasTestTag(TestTag.COIN_LIST_VIEW), 1, MAX_DELAY_UI_TESTING)
            onNodeWithTag(TestTag.COIN_LIST_VIEW)
                .performScrollToIndex(100)
            onNodeWithTag(TestTag.COIN_LIST_VIEW).assertIsDisplayed()
        }
    }

}