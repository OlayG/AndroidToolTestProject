package com.example.admin.androidtooltestproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment implements View.OnClickListener {

    String num = null, num1 = null, operator = null;
    TextView tvDisplay;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnClear, btnPlusMinus, btnPercent, btnDivide, btnMultiply, btnMinus, btnAdd, btnEquals, btnPeriod;


    public CalculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        tvDisplay = view.findViewById(R.id.tvDisplay);
        tvDisplay.setText(getString(R.string.Zero));

        btn0 = view.findViewById(R.id.btn0);
        btn0.setOnClickListener(this);
        btn1 = view.findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = view.findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = view.findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = view.findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5 = view.findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn6 = view.findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn7 = view.findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8 = view.findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn9 = view.findViewById(R.id.btn9);
        btn9.setOnClickListener(this);

        btnClear = view.findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        btnPlusMinus = view.findViewById(R.id.btnPlusMinus);
        //btnPlusMinus.setOnClickListener(this);

        btnPercent = view.findViewById(R.id.btnPercent);
        btnPercent.setOnClickListener(this);

        btnDivide = view.findViewById(R.id.btnDivide);
        btnDivide.setOnClickListener(this);
        btnMultiply = view.findViewById(R.id.btnMultiply);
        btnMultiply.setOnClickListener(this);
        btnMinus = view.findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(this);
        btnAdd = view.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        btnEquals = view.findViewById(R.id.btnEquals);
        btnEquals.setOnClickListener(this);
        btnPeriod = view.findViewById(R.id.btnPeriod);
        btnPeriod.setOnClickListener(this);


        return  view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btn0:
                if(num1 == null){
                    num1 = getString(R.string.Zero);
                    tvDisplay.setText(num1);
                } else {
                    num1 += getString(R.string.Zero);
                    tvDisplay.setText(num1);
                }
                break;
            case R.id.btn1:
                if(num1 == null){
                    num1 = getString(R.string.One);
                    tvDisplay.setText(num1);
                } else {
                    num1 += getString(R.string.One);
                    tvDisplay.setText(num1);
                }
                break;
            case R.id.btn2:
                if(num1 == null){
                    num1 = getString(R.string.Two);
                    tvDisplay.setText(num1);
                } else {
                    num1 += getString(R.string.Two);
                    tvDisplay.setText(num1);
                }
                break;
            case R.id.btn3:
                if(num1 == null){
                    num1 = getString(R.string.Three);
                    tvDisplay.setText(num1);
                } else {
                    num1 += getString(R.string.Three);
                    tvDisplay.setText(num1);
                }
                break;
            case R.id.btn4:
                if(num1 == null){
                    num1 = getString(R.string.Four);
                    tvDisplay.setText(num1);
                } else {
                    num1 += getString(R.string.Four);
                    tvDisplay.setText(num1);
                }
                break;
            case R.id.btn5:
                if(num1 == null){
                    num1 = getString(R.string.Five);
                    tvDisplay.setText(num1);
                } else {
                    num1 += getString(R.string.Five);
                    tvDisplay.setText(num1);
                }
                break;
            case R.id.btn6:
                if(num1 == null){
                    num1 = getString(R.string.Six);
                    tvDisplay.setText(num1);
                } else {
                    num1 += getString(R.string.Six);
                    tvDisplay.setText(num1);
                }
                break;
            case R.id.btn7:
                if(num1 == null){
                    num1 = getString(R.string.Seven);
                    tvDisplay.setText(num1);
                } else {
                    num1 += getString(R.string.Seven);
                    tvDisplay.setText(num1);
                }
                break;
            case R.id.btn8:
                if(num1 == null){
                    num1 = getString(R.string.Eight);
                    tvDisplay.setText(num1);
                } else {
                    num1 += getString(R.string.Eight);
                    tvDisplay.setText(num1);
                }
                break;
            case R.id.btn9:
                if(num1 == null){
                    num1 = getString(R.string.Nine);
                    tvDisplay.setText(num1);
                } else {
                    num1 += getString(R.string.Nine);
                    tvDisplay.setText(num1);
                }
                break;
            case R.id.btnPeriod:
                if(num1 == null){
                    num1 = String.valueOf('.');
                    tvDisplay.setText(String.valueOf(0.));
                } else {
                    num1 += getString(R.string.Period);
                    tvDisplay.setText(num1);
                }
                break;
            case R.id.btnClear:
                tvDisplay.setText(R.string.Zero);
                num = null;
                num1 = null;
                operator = null;
                break;
            case R.id.btnPercent:
                num1 = String.valueOf(Double.parseDouble(tvDisplay.getText().toString()) / 100);
                tvDisplay.setText(num1);
                break;
            case R.id.btnDivide:
                if(num1 != null && num != null){
                    doCalculations();
                    operator = getString(R.string.Divide);
                }else if(operator == getString(R.string.Divide)){
                    break;
                }else if(num1 == null && num != null){
                    operator = getString(R.string.Divide);
                } else {
                    num = num1;
                    num1 = null;
                    operator = getString(R.string.Divide);
                }
                break;

            case R.id.btnAdd:
                if(num1 != null && num != null){
                    doCalculations();
                    operator = getString(R.string.Plus);
                }else if(operator == getString(R.string.Plus)){
                    break;
                }else if(num1 == null && num != null){
                    operator = getString(R.string.Plus);
                } else {
                    num = num1;
                    num1 = null;
                    operator = getString(R.string.Plus);
                }
                break;
            case R.id.btnMultiply:
                if(num1 != null && num != null){
                    doCalculations();
                    operator = getString(R.string.Multiply);
                }else if(operator == getString(R.string.Multiply)){
                    break;
                }else if(num1 == null && num != null){
                    operator = getString(R.string.Multiply);
                } else {
                    num = num1;
                    num1 = null;
                    operator = getString(R.string.Multiply);
                }
                break;
            case R.id.btnMinus:
                if(num1 != null && num != null){
                    doCalculations();
                    operator = getString(R.string.Minus);
                }else if(operator == getString(R.string.Minus)){
                    break;
                }else if(num1 == null && num != null){
                    operator = getString(R.string.Minus);
                } else {
                    num = num1;
                    num1 = null;
                    operator = getString(R.string.Minus);
                }
                break;
            case R.id.btnEquals:
                if(num == null || num1 == null)
                    break;
                doCalculations();
                break;
            default:
                break;
        }
    }

    public void doCalculations(){

        if(operator == getString(R.string.Divide)){
            num1 = String.valueOf(Double.parseDouble(num) / Double.parseDouble(tvDisplay.getText().toString()));
            tvDisplay.setText(checkDouble(num1));
            num = num1;
            num1 = null;
        } else if(operator == getString(R.string.Plus)){
            num1 = String.valueOf(Double.parseDouble(num) + Double.parseDouble(tvDisplay.getText().toString()));
            tvDisplay.setText(checkDouble(num1));
            num = num1;
            num1 = null;
        } else if(operator == getString(R.string.Minus)){
            num1 = String.valueOf(Double.parseDouble(num) - Double.parseDouble(tvDisplay.getText().toString()));
            tvDisplay.setText(checkDouble(num1));
            num = num1;
            num1 = null;
        }else if(operator == getString(R.string.Multiply)){
            num1 = String.valueOf(Double.parseDouble(num) * Double.parseDouble(tvDisplay.getText().toString()));
            tvDisplay.setText(checkDouble(num1));
            num = num1;
            num1 = null;
        }
    }

    public String checkDouble(String num){

        if(Double.parseDouble(num) % 1 == 0)
            return String.valueOf(((int) Double.parseDouble(num)));

        return num;
    }
}
