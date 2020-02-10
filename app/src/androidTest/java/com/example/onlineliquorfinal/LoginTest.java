package com.example.onlineliquorfinal;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class LoginTest {
    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void checkLogin() throws Exception
    {
        onView(withId(R.id.username))
                .perform(typeText("suve123"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.password))
                .perform(typeText("suve123"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.btn_login))
                .perform(click());

    }
}
