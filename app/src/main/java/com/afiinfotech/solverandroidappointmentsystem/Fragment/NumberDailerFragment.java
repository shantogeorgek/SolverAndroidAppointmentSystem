package com.afiinfotech.solverandroidappointmentsystem.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.afiinfotech.solverandroidappointmentsystem.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class NumberDailerFragment extends Fragment {

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnPlus;
    private Button btnHash;
    private Button btnDone;

    private TextView txtNumber;

    private ImageView imgDelete;

    private String numberString = "";

    private DailerCallBack dailerCallBack;

    public interface DailerCallBack {
        void onDoneSelection(String nummber);
    }

    public NumberDailerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        btn0 = (Button) view.findViewById(R.id.btn0);
        btn1 = (Button) view.findViewById(R.id.btn1);
        btn2 = (Button) view.findViewById(R.id.btn2);
        btn3 = (Button) view.findViewById(R.id.btn3);
        btn4 = (Button) view.findViewById(R.id.btn4);
        btn5 = (Button) view.findViewById(R.id.btn5);
        btn6 = (Button) view.findViewById(R.id.btn6);
        btn7 = (Button) view.findViewById(R.id.btn7);
        btn8 = (Button) view.findViewById(R.id.btn8);
        btn9 = (Button) view.findViewById(R.id.btn9);

        btnPlus = (Button) view.findViewById(R.id.btnPlus);
        btnHash = (Button) view.findViewById(R.id.btnHash);
        btnDone = (Button) view.findViewById(R.id.btnDone);

        txtNumber = (TextView) view.findViewById(R.id.txtNumber);

        imgDelete = (ImageView) view.findViewById(R.id.imgDelete);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btn0.setOnClickListener(numberClickListener);
        btn1.setOnClickListener(numberClickListener);
        btn2.setOnClickListener(numberClickListener);
        btn3.setOnClickListener(numberClickListener);
        btn4.setOnClickListener(numberClickListener);
        btn5.setOnClickListener(numberClickListener);
        btn6.setOnClickListener(numberClickListener);
        btn7.setOnClickListener(numberClickListener);
        btn8.setOnClickListener(numberClickListener);
        btn9.setOnClickListener(numberClickListener);

        btnPlus.setOnClickListener(numberClickListener);
        btnHash.setOnClickListener(numberClickListener);

        btn0.setTag("0");
        btn1.setTag("1");
        btn2.setTag("2");
        btn3.setTag("3");
        btn4.setTag("4");
        btn5.setTag("5");
        btn6.setTag("6");
        btn7.setTag("7");
        btn8.setTag("8");
        btn9.setTag("9");

        btnPlus.setTag("+");
        btnHash.setTag("#");

        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processInput("0", true);
            }
        });

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( ! numberString.isEmpty() && dailerCallBack != null)
                    dailerCallBack.onDoneSelection(numberString);
            }
        });
    }

    private View.OnClickListener numberClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {

                String number = (String) v.getTag();
                processInput(number , false);
            }
            catch (Exception e) {
                Log.e("numberClickListener Ex", e.toString());
            }
        }
    };

    /**
     * Process the number input
     * @param number
     * @param isDeletion true if the process is deletion
     */
    private void processInput(String number , boolean isDeletion) {
        if ( isDeletion) {
            if(numberString.isEmpty())
                return;
            else {
                if ( numberString.length() == 1 )
                    numberString = "";
                else
                    numberString = numberString.substring(0 , numberString.length() - 1);
            }
        }
        else {
            numberString += String.valueOf(number);
        }
        txtNumber.setText(numberString);
    }

    public void setDailerCallBack(DailerCallBack dailerCallBack) {
        this.dailerCallBack = dailerCallBack;
    }
}
