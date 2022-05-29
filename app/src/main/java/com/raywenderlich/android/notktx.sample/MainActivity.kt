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

package com.raywenderlich.android.notktx.sample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.raywenderlich.android.notktx.core.*
import com.raywenderlich.android.notktx.sample.databinding.ActivityMainBinding
import com.raywenderlich.android.notktx.utilities.loadImageFromUrlV2
import com.raywenderlich.android.notktx.utilities.loadRoundImageFromUrl

/**
 * Main entry point for the sample app.
 *
 * This Activity shows how to use the notktx library. The sample module adds <b>notktx:core</b> and
 * <b>notktx:utilities</b> modules as project dependencies in the gradle.
 *
 * You will need to use [mavenCentral](https://search.maven.org/) to import these modules as
 * libraries in your codebase.
 *
 * @constructor You won't be instantiating any Activity using constructor. So this is of not much
 * use.
 */
class MainActivity : AppCompatActivity() {

  // DONE:15 Add @suppress tag for this property
  /**
   * @suppress
   */
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    // Switch to AppTheme for displaying the activity
    setTheme(R.style.AppTheme)
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    initToastSamples()
    initViewsSamples()
    initPrefsSamples()
    initIntentsSamples()
    initImageLoaderSamples()
  }

  // DONE:1 Replace this with a plain comment
  /*
  Initializes the image loading sample views
  This demonstrates a plain multi line comment
 */
  private fun initImageLoaderSamples() {
    val imageUrl = "https://cdn.pixabay.com/photo/2021/09/08/15/24/couple-6607143_1280.jpg"

    binding.imageLoadingSampleContainer.loadImageBtn.setOnClickListener {
//      binding.imageLoadingSampleContainer.sampleImageIv.loadImageFromUrl(url = imageUrl)
      binding.imageLoadingSampleContainer.sampleImageIv.loadImageFromUrlV2(url = imageUrl)
    }

    binding.imageLoadingSampleContainer.loadRoundImageBtn.setOnClickListener {
      binding.imageLoadingSampleContainer.sampleImageIv.loadRoundImageFromUrl(url = imageUrl)
    }
  }

  // DONE:2 Replace this with a KDoc comment
  /**
   * Initializes the toast related views
   */
  private fun initToastSamples() {
    binding.toastSampleContainer.shortToastBtn.setOnClickListener {
      showShortToast(message = "Message taken from a string literal")
    }

    binding.toastSampleContainer.longToastBtn.setOnClickListener {
      showLongToast(stringResId = R.string.long_toast_message)
    }
  }

  /**
   * Initializes the views related sample code for :notktx:core module
   */
  private fun initViewsSamples() {
    binding.viewsSampleContainer.showDummyTvBtn.setOnClickListener {
      binding.viewsSampleContainer.dummyTv.show()
    }

    binding.viewsSampleContainer.hideDummyTvBtn.setOnClickListener {
      binding.viewsSampleContainer.dummyTv.hide()
    }

    binding.viewsSampleContainer.removeDummyTvBtn.setOnClickListener {
      binding.viewsSampleContainer.dummyTv.hide(gone = true)
    }

    binding.viewsSampleContainer.viewChildrenBtn.setOnClickListener {
      val childListString = StringBuilder()
      binding.mainContainer.forEach { view ->
        childListString.append(getStringIdFromId(view.id))
        childListString.append("\n")
      }

      showLongToast(childListString.toString())
    }
  }

  /**
   * Initializes the prefs sample related views
   */
  private fun initPrefsSamples() {
    val sharedPrefs = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE)

    val existingPrefsValue = sharedPrefs.getString("sample", "Empty prefs")
    binding.prefsSampleContainer.prefsShowcaseTv.text = existingPrefsValue

    binding.prefsSampleContainer.applyPrefsBtn.setOnClickListener {
      val prefsValueToUpdate = binding.prefsSampleContainer.prefsValueEt.text.toString()
      binding.prefsSampleContainer.prefsValueEt.setText("")

      sharedPrefs.editAndApply {
        putString("sample", prefsValueToUpdate)
      }

      binding.prefsSampleContainer.prefsShowcaseTv.text = prefsValueToUpdate
    }

    binding.prefsSampleContainer.commitPrefsBtn.setOnClickListener {
      val prefsValueToUpdate = binding.prefsSampleContainer.prefsValueEt.text.toString()
      binding.prefsSampleContainer.prefsValueEt.setText("")

      sharedPrefs.editAndCommit {
        putString("sample", prefsValueToUpdate)
      }

      binding.prefsSampleContainer.prefsShowcaseTv.text = prefsValueToUpdate
    }
  }

  /**
   * Initializes the intent sample related views
   */
  private fun initIntentsSamples() {
    binding.intentsSampleContainer.emailIntentBtn.setOnClickListener {
      val emailIntent = getIntentToComposeEmail(
          addresses = arrayOf("someemailid@someemail.com", "someemailid2@someemail2.in"),
          subject = "Dummy subject", body = "Dummy body"
      )

      startActivity(emailIntent)
    }

    binding.intentsSampleContainer.urlIntentBtn.setOnClickListener {
      openUrl(url = "https://www.raywenderlich.com/")
    }
  }

  /**
   * @suppress
   */
  private fun getStringIdFromId(id: Int): String? {
    return if (id == View.NO_ID) {
      "no-id"
    } else {
      resources.getResourceName(id)
    }
  }
}
