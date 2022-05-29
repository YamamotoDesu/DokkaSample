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
import android.content.Intent
import android.net.Uri

/**
 * An extension function on [Context] receiver to open a given url with [Intent.ACTION_VIEW] type
 * intent.
 *
 * @param[url] Url string to open in the intent
 * @receiver [Context]
 * @see Context.startActivity
 */
fun Context.openUrl(url: String) {
  val intent = Intent(Intent.ACTION_VIEW)
  intent.data = Uri.parse(url)
  intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
  startActivity(intent)
}

/**
 * Returns an [Intent] to compose email.
 *
 * It accepts parameters to pre fill the intent with addresses, subject and body.
 *
 * @param addresses Array of email addresses to be added in the <b>mailto:</b>
 * @param subject Subject of the email
 * @param body Body of the email
 *
 * @receiver [Context]
 * @return An [Intent] with addresses, subject and body extras set.
 */
fun Context.getIntentToComposeEmail(addresses: Array<String>, subject: String, body: String):
    Intent {
  val intent = Intent(Intent.ACTION_SENDTO)
  intent.data = Uri.parse("mailto:")
  intent.putExtra(Intent.EXTRA_EMAIL, addresses)
  intent.putExtra(Intent.EXTRA_SUBJECT, subject)
  intent.putExtra(Intent.EXTRA_TEXT, body)
  return intent
}