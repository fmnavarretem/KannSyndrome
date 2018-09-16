package fmnavarretem.co.kannsyndrome.Model.Persistence

import android.content.Context
import android.content.SharedPreferences
import fmnavarretem.co.kannsyndrome.Model.POJO.Symptom
import fmnavarretem.co.kannsyndrome.Util.Constants
import fmnavarretem.co.kannsyndrome.Util.JSONHelper
import java.util.*
import kotlin.collections.ArrayList

object PreferencesManager {
    private fun getUserSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(Constants.Persistence.USER_PREFERENCES,Context.MODE_PRIVATE)
    }
    fun setSymptoms(symptoms: ArrayList<Symptom>, context: Context){
        val editor: SharedPreferences.Editor = getUserSharedPreferences(context).edit()

        editor.putString(Constants.Persistence.SYMPTOMS, JSONHelper.object2JSON(symptoms))
        editor.apply()
    }
    fun getSymptoms(context: Context): ArrayList<Symptom>? {

        val userSharedPreferences: SharedPreferences = getUserSharedPreferences(context)

        val jsonString: String = userSharedPreferences.getString(Constants.Persistence.SYMPTOMS, Constants.Persistence.USER_NOT_FOUND)

        if (jsonString.equals(Constants.Persistence.USER_NOT_FOUND)){
            return null
        }


        return (JSONHelper.json2object(jsonString,Array<Symptom>::class.java) as Array<Symptom>).asList() as ArrayList<Symptom>
    }
}