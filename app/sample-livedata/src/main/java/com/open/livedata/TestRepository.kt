//package com.open.livedata
//
//import androidx.lifecycle.LiveData
//
///**
// * TestRepository
// *
// * @Description: xxx
// * @Author: xing.tang
// */
//class UserRepository {
//
//    // DON'T DO THIS! LiveData objects should not live in the repository.
//    fun getUsers(): LiveData<List<String>> {
//        ...
//    }
//
//    fun getNewPremiumUsers(): LiveData<List<String>> {
//        return TransformationsLiveData.map(getUsers()) { users ->
//            // This is an expensive call being made on the main thread and may
//            // cause noticeable jank in the UI!
//            users
//                .filter { user ->
//                    user.isPremium
//                }
//                .filter { user ->
//                    val lastSyncedTime = dao.getLastSyncedTime()
//                    user.timeCreated > lastSyncedTime
//                }
//        }
//    }