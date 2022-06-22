package com.willweeverwin.mvp_training.model

data class User(
    val id: Int,
    var name: String,
    var mail: String,
) {
    override fun toString(): String  = "$id  |  $name  |  $mail"
}
