package com.open.viewmodel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * User
 *
 * @Description: xxx
 * @Author: xing.tang
 */
@Parcelize
data class Test(
    var name: String = "", var age: Int = 0,
) : Parcelable
