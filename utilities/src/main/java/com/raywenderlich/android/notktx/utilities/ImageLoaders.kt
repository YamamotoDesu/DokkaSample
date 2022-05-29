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

package com.raywenderlich.android.notktx.utilities

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

/**
 * <b>Deprecated</b>: Use loadImageFromUrlV2 instead
 *
 * An extension function on [ImageView] receiver to load an image from some remote url.
 *
 * This function uses <b>Picasso</b> which is a 3rd party library to handle all the networking and
 * caching side of things.
 *
 * <b>Sample Usage</b>
 *
 * ```
 * yourImageView.loadImageFromUrl(url = "https://someurl.com/someImage")
 * ```
 *
 * @receiver [ImageView]
 * @param url Url to load image from
 * @see Picasso
 * @see loadImageFromUrlV2
 */
@Deprecated(
  message = "Moving to Glide", replaceWith = ReplaceWith("loadImageFromUrlV2"),
  level = DeprecationLevel.WARNING
)
fun ImageView.loadImageFromUrl(url: String) {
  Picasso.get().load(url).into(this)
}

// DONE:11 Add loadImageFromUrlV2 function and deprecate loadImageFromUrl pointing to this
//  function as the alternate one to use
/**
 * An extension function on [ImageView] receiver to load an image from some remote url.
 *
 * This function uses <b>Glide</b> which is a 3rd party library to handle all the networking and
 * caching side of things. Glide handles the loading w.r.t. the lifecycle of the view for you.
 *
 * <b>Sample Usage</b>
 *
 * ```
 * yourImageView.loadImageFromUrlV2(url = "https://someurl.com/someImage")
 * ```
 *
 * @receiver [ImageView]
 * @param url Url to load image from
 * @since v1.0.2
 * @see Glide
 */
fun ImageView.loadImageFromUrlV2(url: String) {
  Glide.with(this).load(url).centerCrop().into(this)
}

/**
 * An extension function on [ImageView] receiver to load an image from remote url and crop it in
 * <b>Round</b> shape
 *
 * This function uses Glide which is a 3rd party library to handle all the networking and
 * caching side of things. It handles the loading w.r.t lifecycle of the view and crops the
 * loaded image in Round shape.
 *
 * <b>Sample Usage</b>
 *
 * ```
 * yourImageView.loadRoundImageFromUrl(url = "https://someurl.com/someImage")
 * ```
 *
 * @receiver [ImageView]
 * @param url Url to load image from
 * @see Glide
 */
fun ImageView.loadRoundImageFromUrl(url: String) {
  Glide.with(this).load(url).fitCenter().circleCrop().into(this)
}
