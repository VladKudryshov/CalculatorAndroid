package com.git.vladkudryshov.calculatorandroid;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.git.vladkudryshov.calculatorandroid.logic.algorithm.PolishNotation;
import com.git.vladkudryshov.calculatorandroid.logic.algorithm.ShuntingYard;
import com.git.vladkudryshov.calculatorandroid.logic.model.Expression;
import com.git.vladkudryshov.calculatorandroid.logic.parse.Parser;
import com.git.vladkudryshov.calculatorandroid.logic.validator.Validator;

public class CalculatorActivity extends AppCompatActivity {

    private EditText mExpressionEditText;
    private Button mCalculateButton;
    private Button mClearExpressionButton;
    private TextView mResultTextView;
    private Toast errorMessage;


    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initView();
    }

    private void initView() {
        mExpressionEditText = (EditText) findViewById(R.id.expression_edit_text);
        mCalculateButton = (Button) findViewById(R.id.calculate_button);
        mClearExpressionButton = (Button) findViewById(R.id.clear_expression_button);
        mResultTextView = (TextView) findViewById(R.id.result_text_view);

        mClearExpressionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View pView) {
                mResultTextView.setText("");
            }
        });

        mCalculateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View pView) {
                final String expression = mExpressionEditText.getText().toString();
                final String result = calculate(expression);
                if(result!=null) {
                    showResult(result);
                } else {
                    final Context context = getApplicationContext();
                    errorMessage = Toast.makeText(context, "Please input correct expression", Toast.LENGTH_LONG);
                    errorMessage.show();
                }
            }
        });

    }

    private void showResult(final CharSequence result) {
        mResultTextView.setText("Result calculate: " + result);
    }

    private String calculate(final String expression) {
        final Expression exp = new Expression();
        final String status = Validator.checkErrorsExp(expression);
        if ("Success".equals(status)) {
            final String temp = Parser.splitExpression(expression);
            exp.setStrExp(temp);
            exp.setPostfixExp(ShuntingYard.infixToPostfix(exp.getStrExp()));
            final Double result = PolishNotation.calculateExp(exp.getPostfixExp());
            return result.toString();
        }
        final Context context = getApplicationContext();
        errorMessage = Toast.makeText(context, status, Toast.LENGTH_SHORT);
        errorMessage.show();
        return null;
    }
}
