package fmnavarretem.co.kannsyndrome.Util

import com.google.gson.Gson

object JSONHelper{
    fun object2JSON(currentObject: Any): String{
        return Gson().toJson(currentObject)
    }

    fun json2object(currentObject: String, type: Class<out Any>): Any?{
        return Gson().fromJson(currentObject,type)
    }
}