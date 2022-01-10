package com.example.hiltwmvvm.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.hiltwmvvm.data.model.MovieData
import com.example.hiltwmvvm.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class MoviePagingSource(
    private val movieApi: MovieApi
) : PagingSource<Int, MovieData>() {

    private val constants = Constants

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieData> {

        val page = params.key ?: constants.STARTING_PAGE
        return try {
            withContext(Dispatchers.IO) {
                if (page > 1) {
                    delay(1000)
                }
                val response = movieApi.getPopularList(constants.API_KEY, page)
                LoadResult.Page(
                    data = response.results,
                    prevKey = null,
                    nextKey =
                    if (response.results.isEmpty() || page == 3) null else page + 1
                )
            }
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MovieData>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}