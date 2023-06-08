package com.assign.imgur.utils

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.assign.imgur.R
import java.lang.Integer.max
import java.lang.Integer.min

object Utils {

    fun Long.toTimeAgo(): Double {
        val time = this
        val now = System.currentTimeMillis()

        // convert back to second
        val diff = (now - time).toDouble() / 1000

        return diff
    }

    fun Context.copyToClipboard(text: CharSequence) {
        val clipboard = ContextCompat.getSystemService(this, ClipboardManager::class.java)
        clipboard?.setPrimaryClip(ClipData.newPlainText("", text))
    }

    fun <T> LiveData<T>.observeOnce(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
        observe(lifecycleOwner, object : Observer<T> {
            override fun onChanged(t: T?) {
                observer.onChanged(t)
                removeObserver(this)
            }
        })
    }

    fun replaceFragment(
        context: AppCompatActivity?,
        T: Class<out Fragment>,
        arguments: Bundle?,
        TAG: String,
        containerViewId: Int,
        addToBackStack: Boolean,
    ) {
        replaceFragment(context, T, arguments, TAG, containerViewId, addToBackStack, 0, 0)
    }

    fun replaceFragment(
        context: AppCompatActivity?,
        T: Class<out Fragment>,
        TAG: String,
        containerViewId: Int,
    ) {
        replaceFragment(context, T, null, TAG, containerViewId, false)
    }

    fun replaceFragment(
        context: AppCompatActivity?,
        T: Class<out Fragment>,
        arguments: Bundle?,
        TAG: String,
        containerViewId: Int,
        addToBackStack: Boolean,
        startTransition: Int,
        endTransition: Int,
    ) {
        val fragmentManager = context?.supportFragmentManager
        var fragment = fragmentManager?.findFragmentByTag(TAG)
        if (fragment == null) {
            try {
                fragment = T.newInstance()
                fragment!!.arguments = arguments
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }
        }
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.setCustomAnimations(startTransition, endTransition)
        fragmentTransaction?.replace(containerViewId, fragment!!, TAG)
        if (addToBackStack) {
            fragmentTransaction?.addToBackStack(TAG)
        }
        fragmentTransaction?.commitAllowingStateLoss()
    }

    fun removeFragmentsByTag(context: AppCompatActivity?, vararg fragmentTags: String?): Boolean {
        var isAnyFragmentRemoved = false
        if (context != null) {
            val fragmentManager = context.supportFragmentManager
            for (tag in fragmentTags) {
                val fragment = fragmentManager.findFragmentByTag(tag)
                if (fragment != null) {
                    isAnyFragmentRemoved = true
                    fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss()
                }
            }
        }
        return isAnyFragmentRemoved
    }

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

    fun findSimilarity(x: String?, y: String?): Double {
        require(!(x == null || y == null)) { "Strings should not be null" }

        val maxLength = max(x.length, y.length)
        return if (maxLength > 0) {
            (maxLength * 1.0 - getLevenshteinDistance(x, y)) / maxLength * 1.0
        } else 1.0
    }

//    fun showToast(activity: Activity?, msg: String?, duration: Int) {
//        activity?.runOnUiThread {
//            val inflater = LayoutInflater.from(activity)
//            val layout = inflater.inflate(R.layout.view_toast,
//                activity.findViewById(R.id.custom_toast_container)) as TextView
//            layout.text = msg
//            val toast = Toast(activity)
//            toast.setGravity(Gravity.BOTTOM, 0, 200)
//            toast.duration = duration
//            toast.setView(layout)
//            toast.show()
//        }
//    }
//
//    fun showToast(activity: Activity?, msg: String?) {
//        showToast(activity, msg, Toast.LENGTH_SHORT)
//    }
//
//    fun showToast(activity: Activity?, @StringRes stringRes: Int) {
//        if (activity != null) {
//            showToast(activity, activity.getString(stringRes))
//        }
//    }

}