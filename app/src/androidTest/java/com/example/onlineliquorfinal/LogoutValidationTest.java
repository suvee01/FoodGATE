package com.example.onlineliquorfinal;

import androidx.test.rule.ActivityTestRule;

import com.google.android.gms.maps.model.Dash;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class LogoutValidationTest {

    @Rule
    public ActivityTestRule<DashboardActivity> activity_logoutActivityTestRule = new ActivityTestRule<>(DashboardActivity.class);
    @Test
    public void LogoutValidationTest() {
        onView(withId(R.id.Logout)).perform(click());
    }
}
