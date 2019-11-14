package com.example.testapi24.model

class User {
    var email: String? = null

    constructor() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    constructor(email: String?) {

        this.email = email
    }

}