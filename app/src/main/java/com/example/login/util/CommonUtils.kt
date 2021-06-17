package com.example.login.util

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.widget.TextView
import java.util.regex.Pattern


class CommonUtils {
    companion object {
        fun isValidPAN(PAN: String): Boolean {
            val pattern: Pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}")
            val matcher = pattern.matcher(PAN)

            if (matcher.matches() && PAN.length == 10) {
                return true;
            }
            return false;
        }

        fun isValidDOB(day: String, month: String, year: String): Boolean {

            if (day.length == 2 && month.length == 2 && year.length == 4) {
                if (day.toInt() in 1..31) {
                    if (month.toInt() in 1..12) {
                        if (year.toInt() != 0) {
                            if (month.toInt() == 1 && day.toInt() in 1..31) {
                                return true
                            } else if (month.toInt() == 2 && day.toInt() in 1..29 && year.toInt() % 4 == 0) {
                                return true
                            } else if (month.toInt() == 2 && day.toInt() in 1..28 && year.toInt() % 4 != 0) {
                                return true
                            } else if (month.toInt() == 3 && day.toInt() in 1..31) {
                                return true
                            } else if (month.toInt() == 4 && day.toInt() in 1..30) {
                                return true
                            } else if (month.toInt() == 5 && day.toInt() in 1..31) {
                                return true
                            } else if (month.toInt() == 6 && day.toInt() in 1..30) {
                                return true
                            } else if (month.toInt() == 7 && day.toInt() in 1..31) {
                                return true
                            } else if (month.toInt() == 8 && day.toInt() in 1..31) {
                                return true
                            } else if (month.toInt() == 9 && day.toInt() in 1..30) {
                                return true
                            } else if (month.toInt() == 10 && day.toInt() in 1..31) {
                                return true
                            } else if (month.toInt() == 11 && day.toInt() in 1..30) {
                                return true
                            } else if (month.toInt() == 12 && day.toInt() in 1..31) {
                                return true
                            }
                        }
                    }
                }
            }
            return false;
        }

        fun setHighLightedText(tv: TextView, textToHighlight: String) {
            val tvt = tv.text.toString()
            var ofe = tvt.indexOf(textToHighlight, 0)
            val wordToSpan: Spannable = SpannableString(tv.text)
            var ofs = 0
            while (ofs < tvt.length && ofe != -1) {
                ofe = tvt.indexOf(textToHighlight, ofs)
                if (ofe == -1) break else {
                    // you can change or add more span as per your need
                    wordToSpan.setSpan(
                        RelativeSizeSpan(1f),
                        ofe,
                        ofe + textToHighlight.length,
                        0
                    ) // set size
                    wordToSpan.setSpan(
                        ForegroundColorSpan(Color.BLUE),
                        ofe,
                        ofe + textToHighlight.length,
                        0
                    ) // set color
                    tv.setText(wordToSpan, TextView.BufferType.SPANNABLE)
                }
                ofs = ofe + 1
            }
        }
    }
}