package com.example.musicapp.presenter

import androidx.lifecycle.LifecycleCoroutineScope
import com.example.musicapp.model.GeneralResponse
import com.example.musicapp.model.rest.MusicRepository
import com.example.musicapp.model.utils.DataType
import com.example.musicapp.model.utils.UIState

import kotlinx.coroutines.launch
import javax.inject.Inject

class PopPresenter @Inject constructor(
    private val repository: MusicRepository
) : PopPresenterContract {

    private var view: PopViewContract? = null

    override fun getPopData(coroutineScope: LifecycleCoroutineScope) {
        coroutineScope.launch {
            repository.gender.collect {
                when(it){
                    is UIState.ERROR -> { view?.error(it.e) }
                    is UIState.SUCCESS -> { view?.success(it.response) }
                    is UIState.LOADING -> { view?.loading() }
                }
            }
        }
        repository.getData(DataType.POP)
    }

    override fun initPresenter(view: PopViewContract) {
        this.view = view
    }

    override fun destroyPresenter() {
        view = null
    }
}

interface PopPresenterContract {
    fun getPopData(coroutineScope: LifecycleCoroutineScope)
    fun initPresenter(view: PopViewContract)
    fun destroyPresenter()
}

interface PopViewContract{
    fun success(response: GeneralResponse)
    fun error(ex: Exception)
    fun loading()
}