package com.example.marvelsuperpedia.utils

import java.math.BigInteger
import java.security.MessageDigest
import java.util.*

fun String.md5(): String {
    val messageDigest = MessageDigest.getInstance("MD5")
    return BigInteger(1, messageDigest.digest(toByteArray())).toString(16).padStart(32, '0')
}

fun getTimeStamp() = (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 100L).toString()
