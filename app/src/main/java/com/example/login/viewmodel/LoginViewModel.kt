package com.example.login.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.login.util.AppConstants
import com.example.login.util.CommonUtils

class LoginViewModel (savedStateHandle: SavedStateHandle) : ViewModel() {

    var btnSelected: ObservableBoolean? = null
    var PAN:ObservableField<String>? = null
    var day:ObservableField<String>? = null
    var month:ObservableField<String>? = null
    var year:ObservableField<String>? = null
    private var savedStateHandle:SavedStateHandle? = null

    init {
        this.savedStateHandle = savedStateHandle
        btnSelected = ObservableBoolean(false)
        PAN = ObservableField(savedStateHandle.get(AppConstants.SaveStateHandle.PANNUMBER)?:"")
        day = ObservableField(savedStateHandle.get(AppConstants.SaveStateHandle.DATE)?:"")
        month = ObservableField(savedStateHandle.get(AppConstants.SaveStateHandle.MONTH)?:"")
        year = ObservableField(savedStateHandle.get(AppConstants.SaveStateHandle.YEAR)?:"")
    }

    fun onPANChanged(s: CharSequence, start: Int, before: Int, count: Int){
        savePANNumber(s.toString())
        btnSelected!!.set(CommonUtils.isValidPAN(s.toString()) && CommonUtils.isValidDOB(day?.get()!!,month?.get()!!,year?.get()!!))
    }

    fun onDayChanged(s: CharSequence, start: Int, before: Int, count: Int){
        saveDate(s.toString())
        btnSelected!!.set(CommonUtils.isValidPAN(PAN?.get()!!) && CommonUtils.isValidDOB(s.toString(),month?.get()!!,year?.get()!!))
    }

    fun onMonthChanged(s: CharSequence, start: Int, before: Int, count: Int){
        saveMonth(s.toString())
        btnSelected!!.set(CommonUtils.isValidPAN(PAN?.get()!!) && CommonUtils.isValidDOB(day?.get()!!,s.toString(),year?.get()!!))
    }

    fun onYearChanged(s: CharSequence, start: Int, before: Int, count: Int){
        saveYear(s.toString())
        btnSelected!!.set(CommonUtils.isValidPAN(PAN?.get()!!) && CommonUtils.isValidDOB(day?.get()!!,month?.get()!!,s.toString()))
    }

    private fun savePANNumber(PAN:String){
        savedStateHandle!!.set(AppConstants.SaveStateHandle.PANNUMBER,PAN)
    }

    private fun saveDate(date:String){
        savedStateHandle!!.set(AppConstants.SaveStateHandle.DATE,date)
    }

    private fun saveMonth(month:String){
        savedStateHandle!!.set(AppConstants.SaveStateHandle.MONTH,month)
    }

    private fun saveYear(year:String){
        savedStateHandle!!.set(AppConstants.SaveStateHandle.YEAR,year)
    }
}