package com.example.onlineliquorfinal;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class EmailForgetTest {
    @Rule
    public ActivityTestRule<LoginActivity> activity_logoutActivityTestRule = new ActivityTestRule<>(LoginActivity.class);
    @Test
    public void EmailForgetTest() {
        onView(withId(R.id.forgot_password)).perform(click());
    }
}
