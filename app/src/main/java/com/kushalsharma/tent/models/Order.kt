package com.kushalsharma.tent.models

data class Order (

        val orderName : String = "",
        val placedBy : User = User(),
        val placedAt : Long = 0L,
        val orderPrice : String = ""

        )