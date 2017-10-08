package com.git.vladkudryshov.calculatorandroid;

import android.widget.EditText;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.*;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MockitoTest {

    private IActivity mMockActivity;
    private IActivity mSpyActivity;
    private EditText mExpressionEditText;

    @Before
    public void setUp() {
        final CalculatorActivity mMainActivity = Robolectric.setupActivity(CalculatorActivity.class);
        mMockActivity = mock(CalculatorActivity.class);
        mSpyActivity = spy(CalculatorActivity.class);
        mExpressionEditText = (EditText) mMainActivity.findViewById(R.id.expression_edit_text);
    }

    @Test
    public void MockTest() {
        when(mMockActivity.isEmpty(Matchers.anyInt())).thenReturn(false);
        mExpressionEditText.setText("123");
        final int length = mExpressionEditText.getText().length();
        assertEquals(mMockActivity.isEmpty(length), false);
    }

    @Test
    public void SpyTest() {
        when(mSpyActivity.isEmpty(Matchers.anyInt())).thenReturn(false);
        mExpressionEditText.setText("");
        final int length = mExpressionEditText.getText().length();
        assertEquals(mSpyActivity.isEmpty(length), false);
    }

}
