package com.sky.kotlinstudy.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sky.kotlinstudy.base.mvvm.BaseViewModel
import com.sky.kotlinstudy.ext.setValueToUIThread
import com.sky.kotlinstudy.model.Article
import com.sky.kotlinstudy.model.ArticleList
import com.sky.kotlinstudy.model.Banner
import com.sky.kotlinstudy.model.bean.isSuccessful
import com.sky.kotlinstudy.model.repository.HomeRepository
import com.sky.kotlinstudy.network.NetworkManager
import com.sky.kotlinstudy.network.NetworkApi
import com.sky.kotlinstudy.room.SkyDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import com.sky.kotlinstudy.skyApplication
import kotlinx.coroutines.withContext
import java.lang.Exception

/**
 *
 * @Description:    []
 * @Author:         skyHuang
 * @CreateDate:     2021/4/27 10:30
 */
class HomeViewModel : BaseViewModel() {

    private val _uiState = MutableLiveData<HomeUiModel>()
    val uiState: LiveData<HomeUiModel>
        get() = _uiState

    private var currentPage = 0

    private val _articleList = MutableLiveData<List<Article>>()

    val articleList: LiveData<List<Article>>
        get() = _articleList

    var uiBanners: LiveData<List<Banner>> = HomeRepository.instance.uiBanners

    init {
    }

    override fun initState() {
        getHomeArticleList(false)
    }

    val refreshHome: () -> Unit = {
        getHomeArticleList(true)
    }

    fun getBanner() {
        viewModelScope.launch {
            NetworkManager.instance.getBanner()
        }
    }

    private fun getHomeArticleList(isRefresh: Boolean = false) {
        viewModelScope.launch(Dispatchers.IO) {
            emitArticleUiState(showLoading = isRefresh)
            try {
                emitArticleUiState(showLoading = false)
                val articleList = NetworkApi.API.getHomeArticles(currentPage)
                if (articleList.isSuccessful()) {
                    _articleList.setValueToUIThread(articleList.data.datas)
                }
            } catch (e: Exception) {
                Timber.e("getHomeArticleList failed ${e.printStackTrace()}")
                emitArticleUiState(showLoading = false)
            }
        }
    }

    private fun emitArticleUiState(
        showLoading: Boolean = false,
        showError: String? = null,
        showSuccess: ArticleList? = null,
        showEnd: Boolean = false,
        isRefresh: Boolean = false,
        needLogin: Boolean? = null
    ) {
        val uiModel =
            HomeUiModel(showLoading, showError, showSuccess, showEnd, isRefresh, needLogin)
        _uiState.setValueToUIThread(uiModel)
    }

    data class HomeUiModel(
        val showLoading: Boolean,
        val showError: String?,
        val showSuccess: ArticleList?,
        val showEnd: Boolean, // 加载更多
        val isRefresh: Boolean, // 刷新
        val needLogin: Boolean? = null
    )
}