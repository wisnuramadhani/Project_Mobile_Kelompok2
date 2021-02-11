package com.workshopkotlin.myapplication.utils.validator

import com.wajahatkarim3.easyvalidation.core.rules.BaseRule

class MinValRule(private val minLength: Int): BaseRule {

    override fun getErrorMessage(): String {
        return "Value have to greater than $minLength"
    }

    override fun validate(text: String): Boolean {
        return text.toInt() >= minLength
    }
}