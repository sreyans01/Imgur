package com.assign.imgur.utils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.lang.Integer.max
import java.lang.Integer.min

object Utils {

    /**
     * Converts your livedata to a normal variable by removing the observer once a change is observed
     * @param lifecycleOwner - Owner of the lifecycle.
     * @param observer - Observer which is observing.
     */
    fun <T> LiveData<T>.observeOnce(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
        observe(lifecycleOwner, object : Observer<T> {
            override fun onChanged(t: T?) {
                observer.onChanged(t)
                removeObserver(this)
            }
        })
    }

    /**
     * Calculate Levenshtein Distance between two strings which can help use to find similarity between two strings.
     * @param x - String 1 which is to be compared to String 2.
     * @param y - String 2 which is to be compared to String 1.
     * @return - Distance between the two strings in Int
     */
    fun getLevenshteinDistance(X: String, Y: String): Int {
        val m = X.length
        val n = Y.length
        val T = Array(m + 1) { IntArray(n + 1) }
        for (i in 1..m) {
            T[i][0] = i
        }
        for (j in 1..n) {
            T[0][j] = j
        }
        var cost: Int
        for (i in 1..m) {
            for (j in 1..n) {
                cost = if (X[i - 1] == Y[j - 1]) 0 else 1
                T[i][j] = min(min(T[i - 1][j] + 1, T[i][j - 1] + 1),
                    T[i - 1][j - 1] + cost)
            }
        }
        return T[m][n]
    }

    /**
     * Calculate similarity between the two strings.
     * @param x - String 1 which is to be compared to String 2.
     * @param y - String 2 which is to be compared to String 1.
     * @return - Similarity between the two strings in decimal between 0 to 1.
     */
    fun findSimilarity(x: String?, y: String?): Double {
        require(!(x == null || y == null)) { "Strings should not be null" }

        val maxLength = max(x.length, y.length)
        return if (maxLength > 0) {
            (maxLength * 1.0 - getLevenshteinDistance(x, y)) / maxLength * 1.0
        } else 1.0
    }


}