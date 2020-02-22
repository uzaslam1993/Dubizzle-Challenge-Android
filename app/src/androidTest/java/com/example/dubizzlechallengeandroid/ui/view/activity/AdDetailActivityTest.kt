package com.example.dubizzlechallengeandroid.ui.view.activity

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.dubizzlechallengeandroid.R
import com.example.dubizzlechallengeandroid.common.Constants
import com.example.dubizzlechallengeandroid.data.repository.vo.AdVO
import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AdDetailActivityTest {

    @get:Rule
    val mActivityRule =
        ActivityTestRule<AdDetailActivity>(AdDetailActivity::class.java, false, false)

    @Test
    fun onDetailActivityLaunch_textViewsHaveCorrectValues() {
        val intent = Intent()
        intent.putExtra(
            Constants.AD_OBJECT,
            AdVO("sunglasses", "", "15 AED", "20 November 14:15", "")
        )
        mActivityRule.launchActivity(intent)
        onView(withId(R.id.textViewPrice)).check(matches(withText("15 AED")))
        onView(withId(R.id.textViewDate)).check(matches(withText("20 November 14:15")))
        onView(withId(R.id.textViewTitle)).check(matches(withText("sunglasses")))
    }
}