@file:JvmName("FirebaseExt")
package com.source.kotfirebase

import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import com.source.kotfirebase.abs.analytics.Analytics
import com.source.kotfirebase.abs.firestore.Firestore
import com.source.kotfirebase.abs.storage.Storage
fun String.getFirebaseCollection(sync: Boolean = false) = Firestore.getFromCollection(this, sync)

fun String.getFirebaseDocuments(sync: Boolean = false) = Firestore.getFromDocument(this, sync)

inline fun <reified T> String.getFirebaseDocumentsIn(sync: Boolean = false) =
    Firestore.getDocumentResultsIn<T>(this, sync)

fun Context.logBundledEvent(name: String, analyticsFunc: Bundle.() -> Unit) {
    val bundle = Bundle()
    analyticsFunc(bundle)
    Analytics.logBundledEvent(this, name, bundle)
}

fun Context.logEvent(name: String) {
    Analytics.logEvent(this, name)
}