package com.kushalsharma.tent.models

import android.icu.number.NumberFormatter

data class User
    (
        val uid : String = "",
        val displayName : String? = "",
        val imageUrl : String = "",
        val userAddress : String = "",
        val mphoneNumber : String = "",
        val phoneNumber : String = "",
            )