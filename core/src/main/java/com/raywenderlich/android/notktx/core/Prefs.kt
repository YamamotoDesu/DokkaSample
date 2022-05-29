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

import android.annotation.SuppressLint
import android.content.SharedPreferences

// DONE:3 Add documentation for this extension function
/**
 * An extension function on [SharedPreferences] receiver that uses
 * <b>[commit][SharedPreferences.Editor.commit]</b> to persist the changes.
 *
 * It creates and uses an [Editor][SharedPreferences.Editor] object to allow editing the
 * SharedPreferences instance by calling the provided [customAction] on the editor instance.
 *
 * <b>Sample usage</b>
 *
 * ```
 * yourPrefsInstance.editAndCommit {
 *     putString("key", value)
 * }
 * ```
 *
 * @receiver [SharedPreferences]
 * @param[customAction] Custom action to be executed on the created [editor][SharedPreferences.Editor]
 * receiver
 * @see SharedPreferences.editAndApply
 */
@SuppressLint("ApplySharedPref")
inline fun SharedPreferences.editAndCommit(customAction: SharedPreferences.Editor.() -> Unit) {
  val prefsEditor = edit()
  customAction.invoke(prefsEditor)
  prefsEditor.commit()
}

/**
 * An extension function on [SharedPreferences] receiver that uses
 * <b>[apply][SharedPreferences.Editor.apply]</b> to persist the changes.
 *
 * It creates and uses an [Editor][SharedPreferences.Editor] object to allow editing the
 * SharedPreferences instance by calling the provided [customAction] on the editor instance.
 *
 * <b>Sample usage</b>
 *
 * ```
 * yourPrefsInstance.editAndApply {
 *     putInt("key", value)
 * }
 * ```
 *
 * @receiver [SharedPreferences]
 * @param[customAction] Custom action to be executed on the created [editor][SharedPreferences.Editor]
 * receiver
 * @see SharedPreferences.editAndCommit
 */
inline fun SharedPreferences.editAndApply(customAction: SharedPreferences.Editor.() -> Unit) {
  val prefsEditor = edit()
  customAction.invoke(prefsEditor)
  prefsEditor.apply()
}