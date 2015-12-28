package com.afiinfotech.solverandroidappointmentsystem.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.afiinfotech.solverandroidappointmentsystem.R;

public class VerifyNumberFragment extends Fragment {

    private TextView txtIput1;
    private TextView txtIput2;
    private TextView txtIput3;
    private TextView txtIput4;
    private TextView txtIput5;


    private OnFragmentInteractionListener mListener;

    public VerifyNumberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_verify_number, container, false);
        txtIput1 = (TextView) view.findViewById(R.id.txtIput1);
        txtIput2 = (TextView) view.findViewById(R.id.txtIput2);
        txtIput3 = (TextView) view.findViewById(R.id.txtIput3);
        txtIput4 = (TextView) view.findViewById(R.id.txtIput4);
        txtIput5 = (TextView) view.findViewById(R.id.txtIput5);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        txtIput1.setSelected(true);
        txtIput2.setSelected(false);
        txtIput3.setSelected(false);
        txtIput4.setSelected(false);
        txtIput5.setSelected(false);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction("0");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String code);
    }
}
