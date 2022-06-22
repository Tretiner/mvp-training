package com.willweeverwin.mvp_training.presenter

import com.willweeverwin.mvp_training.model.UserModel

class UserPresenter {
    private val userModel = UserModel()

    fun registerUser(name: String, mail: String, callback: (String) -> Unit) =
        callback(userModel.registerUser(name, mail))

    fun clearUsers() = userModel.clearUsers()
}