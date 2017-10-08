package com.git.vladkudryshov.calculatorandroid;

import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class EspressoTest {

    @Rule
    public final ActivityTestRule<CalculatorActivity> activityTestRule = new ActivityTestRule<>(CalculatorActivity.class);

    @Before
    public void onInit() {
        onView(withId(R.id.expression_edit_text))
                .perform(typeText("2+2*2"));
    }

    @Test
    public void EnabledButtonTest() {
        onView(withId(R.id.expression_edit_text))
                .check(matches(withText("2+2*2")));
        onView(withId(R.id.calculate_button))
                .perform(click());
        onView(withId(R.id.result_text_view))
                .check(matches(withText("Result calculate: 6.0")));
    }

}
