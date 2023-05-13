package com.example.library

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.reflect.Type

class JsonToObjectGenerator<T> {
    fun getListByFile(context: Context, fileName: String, rawType: Type): List<T> {
        val inputStream = context.assets.open(fileName)
        val inputStreamReader = InputStreamReader(inputStream)
        val bufferReader = BufferedReader(inputStreamReader)

        val gson = Gson();
        TypeToken.getParameterized(List::class.java, rawType).type
        val list = gson.fromJson<List<T>>(
            bufferReader,
            TypeToken.getParameterized(List::class.java, rawType).type
        )
        return list
    }

    fun getObjectByFile(context: Context, fileName: String, rawType: Type): T {
        val inputStream = context.assets.open(fileName)
        val inputStreamReader = InputStreamReader(inputStream)
        val bufferReader = BufferedReader(inputStreamReader)

        val gson = Gson();
        val o = gson.fromJson<T>(bufferReader, rawType)
        return o
    }
}