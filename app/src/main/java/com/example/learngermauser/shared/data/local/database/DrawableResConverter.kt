package com.example.learngermauser.shared.data.local.database

import androidx.annotation.DrawableRes
import androidx.room.TypeConverter

class DrawableResConverter {
    @TypeConverter
    fun fromDrawableRes(@DrawableRes value: Int): String {
        return value.toString()
    }

    @TypeConverter
    fun toDrawableRes(value: String): Int {
        return value.toInt()
    }
}
