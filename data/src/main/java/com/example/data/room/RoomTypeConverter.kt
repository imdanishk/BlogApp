package com.example.data.room

import androidx.room.TypeConverter
import com.example.domain.model.Owner
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RoomTypeConverter {

    @TypeConverter
    fun ownerToString(owner: Owner): String {
        return Gson().toJson(owner)
    }

    @TypeConverter
    fun stringToOwner(str: String): Owner {
        return Gson().fromJson(str, Owner::class.java)
    }
}

class ListOfStringToStringTypeConverter {

    @TypeConverter
    fun ListOfStringToString(str: List<String>): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun stringToListOfString(str: String): List<String> {
        return Gson().fromJson(str, object:TypeToken<List<String>>() {}.type) // it'll tell us list of string type
    }
}