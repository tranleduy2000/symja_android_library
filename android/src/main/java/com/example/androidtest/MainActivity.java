package com.example.androidtest;

import android.app.Activity;
import android.os.Bundle;

import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IExpr;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IExpr result = new ExprEvaluator().eval("1236126368126321321^215351231023912731");

        System.out.println("result = " + result);
    }
}
