package com.example.tiendaropa.data

import com.example.tiendaropa.model.User

object UserData {
    
    val users = mutableListOf(
        User(
            id = 1,
            name = "Admin",
            email = "admin@tiendaropa.com",
            rut = "12345678-9",
            password = "admin123"
        ),
        User(
            id = 2,
            name = "Juan Pérez",
            email = "juan@email.com",
            rut = "11111111-1",
            password = "123456"
        )
    )
    
    fun addUser(user: User) {
        users.add(user)
    }
    
    fun getUserByEmail(email: String): User? {
        return users.find { it.email == email }
    }
    
    fun validateUser(email: String, password: String): User? {
        return users.find { it.email == email && it.password == password }
    }
}
