package com.example.homeact

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences


class PreferansesMeneger(context:Context) {
    private val sharePreferance:SharedPreferences
    init {
        sharePreferance = context.getSharedPreferences("Fields_KEY", Context.MODE_PRIVATE)

    }


    @SuppressLint("SuspiciousIndentation")
    fun putUsername(username:String){
        val editor = sharePreferance.edit()
            editor.putString("userName_KEY,$username",username)
        editor.apply()


    }
    fun getUsername(username:String) :String?{

      return sharePreferance.getString("userName_KEY,$username",null)
    }
    fun putPassword(password:String){
        val editor = sharePreferance.edit()
        editor.putString("password_KEY,$password",password)
        editor.apply()
    }
    fun getPassword(password: String) :String?{
        return sharePreferance.getString("password_KEY,$password",null)
    }


}