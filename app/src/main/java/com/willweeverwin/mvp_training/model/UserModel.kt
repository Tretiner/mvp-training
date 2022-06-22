package com.willweeverwin.mvp_training.model

// Импровизированная база данных
class UserModel {
    private var id: Int = 0
    private val _userList = mutableListOf<User>()

    val userList: List<User>
        get() = _userList

    fun registerUser(name: String, mail: String): String {
        _userList.add(User(id++, name, mail))
        return _userList.last().toString()
    }

    fun clearUsers() = _userList.clear()
}