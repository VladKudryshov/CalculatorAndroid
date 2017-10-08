package com.git.vladkudryshov.calculatorandroid;

import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class RobolectricTest {

    private ActivityController<CalculatorActivity> activityController;

    @Before
    public void onInit() {
        activityController = Robolectric.buildActivity(CalculatorActivity.class);
    }

    @Test
    public void testCalculatorActivity() {
        activityController.create();
        activityController.start();
        activityController.resume();

        final CalculatorActivity mainActivity = activityController.get();
        final EditText expressionEditText = (EditText) mainActivity.findViewById(R.id.expression_edit_text);
        final TextView resultTextView = (TextView) mainActivity.findViewById(R.id.result_text_view);

        expressionEditText.setText("(2+2)*2");
        mainActivity.findViewById(R.id.calculate_button).performClick();
        assertEquals(resultTextView.getText().toString(), "Result calculate: 8.0");

        activityController.pause();
        activityController.stop();
        activityController.destroy();
    }

}
