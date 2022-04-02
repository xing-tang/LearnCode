//package com.open.livedata
//
//import androidx.lifecycle.LiveData
//import java.math.BigDecimal
//
///**
// * StockLiveData
// *
// * @Description: xxx
// * @Author: xing.tang
// */
//class StockLiveData(symbol: String) : LiveData<BigDecimal>() {
//
//    private val stockManager = StockManager(symbol)
//
//    private val listener = { price: BigDecimal ->
//        value = price	//监听到股价变化，
//    }
//
//    override fun onActive() {
//        stockManager.requestPriceUpdates(listener)
//    }
//
//    override fun onInactive() {
//        stockManager.removeUpdates(listener)
//    }
//}
