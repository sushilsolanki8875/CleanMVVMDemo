package com.example.cleanmvvmapp.domain.usecases

import com.example.cleanmvvmapp.utils.Resource
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class GetCoinListUseCaseTest {

    private lateinit var getCoinListUseCase: GetCoinListUseCase
    private lateinit var mockCoinRepository: MockCoinRepository
    @Before
    fun setUp() {
        mockCoinRepository = MockCoinRepository()
        getCoinListUseCase = GetCoinListUseCase(mockCoinRepository)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `Get coin list, Success`() = runTest{
        val result = getCoinListUseCase.invoke()
        assertTrue(result is Resource.Success)
    }

    @Test
    fun `Get coin empty list, Success`() = runTest{
        mockCoinRepository.clearCoinList()
        val result = getCoinListUseCase.invoke()
        assertTrue(result is Resource.Success)
        result.data?.let { assertTrue(it.isEmpty()) }
    }

    @Test
    fun `Get coin list, Error`() = runTest{
        mockCoinRepository.setTestErrorCase(true)
        val result = getCoinListUseCase.invoke()
        assertTrue(result is Resource.Error)
    }
}