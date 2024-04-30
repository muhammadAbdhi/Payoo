package com.example.payoo.response

import com.google.gson.annotations.SerializedName

data class UserResponse(

	@field:SerializedName("UserResponse")
	val userResponse: List<UserResponseItem?>? = null
)

data class UserResponseItem(

	@field:SerializedName("idUser")
	val idUser: String? = null,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)
