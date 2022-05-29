/*
 * Copyright (c) 2021 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.notktx.core

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes

// Normal comment syntax is used here instead of KDoc syntax.
fun View.show() {
  visibility = View.VISIBLE
}

/**
 * An extension function on [View] receiver to hide it.
 *
 * This function uses a boolean parameter to decide between setting the view's visibility to
 * [View.GONE] or [View.INVISIBLE] with invisible being the default if no value for the
 * parameter is provided.
 *
 * <b>Sample usage</b>
 *
 * ```
 * coolImageView.hide()
 * // Or
 * coolImageView.hide(gone = true)
 * ```
 *
 * @receiver [View]
 * @param[gone] Pass true if you want the visibility property to change to [View.GONE] instead of
 * the default [View.INVISIBLE]
 * @throws Exception Throws an exception if the view is already in the desired state
 */
fun View.hide(gone: Boolean = false) {
  visibility = if (gone) {
    if (visibility == View.GONE) {
      throw Exception("View is already gone")
    }
    View.GONE
  } else {
    if (visibility == View.INVISIBLE) {
      throw Exception("View is already invisible")
    }
    View.INVISIBLE
  }
}

/**
 * A private function used by other toast creation extension functions in this module.
 * It should not be shown in the public documentation.
 */
private fun showToastInternal(context: Context, message: String, length: Int) {
  Toast.makeText(context, message, length).show()
}

/**
 * An extension function on [ViewGroup] receiver to perform a given action on each view in this
 * view group.
 *
 * @receiver [ViewGroup]
 * @param[actionToPerform] A custom action with a [view][View] as its receiver type
 */
inline fun ViewGroup.forEach(actionToPerform: (view: View) -> Unit) {
  for (i in 0 until childCount) {
    actionToPerform(getChildAt(i))
  }
}

/**
 * An extension function on [Context] receiver to show a [toast][Toast] for a short duration.
 *
 * It creates a toast with the length set to [Toast.LENGTH_SHORT] and calls [show][Toast.show]
 * method on it for you so that you don't forget to actually show the toast.
 *
 * `* wink wink ;) been there forgot that show method *`
 *
 * @receiver [Context]
 * @param[message] Message of type [String] to be shown in the toast
 */
fun Context.showShortToast(message: String) {
  showToastInternal(this, message, Toast.LENGTH_SHORT)
}

/**
 * An extension function on [Context] receiver to show a [toast][Toast] for a short duration.
 *
 * It creates a toast with the length set to [Toast.LENGTH_SHORT] and calls [show][Toast.show]
 * method on it.
 *
 * @receiver [Context]
 * @param[stringResId] Message of type [StringRes] to be shown in the toast
 */
fun Context.showShortToast(@StringRes stringResId: Int) {
  val message = getString(stringResId)
  showToastInternal(this, message, Toast.LENGTH_SHORT)
}

/**
 * An extension function on [Context] receiver to show a [toast][Toast] for a longer duration.
 *
 * It creates a toast with the length set to [Toast.LENGTH_LONG] and calls [show][Toast.show]
 * method on it.
 *
 * @receiver [Context]
 * @param[message] Message of type [String] to be shown in the toast
 */
fun Context.showLongToast(message: String) {
  showToastInternal(this, message, Toast.LENGTH_LONG)
}

/**
 * An extension function on [Context] receiver to show a [toast][Toast] for a longer duration.
 *
 * It creates a toast with the length set to [Toast.LENGTH_LONG] and calls [show][Toast.show]
 * method on it.
 *
 * @receiver [Context]
 * @param[stringResId] Message of type [StringRes] to be shown in the toast
 */
fun Context.showLongToast(@StringRes stringResId: Int) {
  val message = getString(stringResId)
  showToastInternal(this, message, Toast.LENGTH_LONG)
}
