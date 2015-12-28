package com.afiinfotech.solverandroidappointmentsystem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.afiinfotech.solverandroidappointmentsystem.Fragment.NumberDailerFragment;
import com.afiinfotech.solverandroidappointmentsystem.Fragment.VerifyNumberFragment;

public class MainActivity extends AppCompatActivity implements NumberDailerFragment.DailerCallBack , VerifyNumberFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if ( savedInstanceState == null ) {
            NumberDailerFragment mainActivityFragment = new NumberDailerFragment();
            mainActivityFragment.setDailerCallBack(this);
            replaceFragment(mainActivityFragment, "DialerFragme", true);
        }

    }

    private void replaceFragment(Fragment fragment , String tag , boolean needAnimation) {
        if ( needAnimation ) {
            getSupportFragmentManager().
                    beginTransaction()
                    .replace(R.id.container , fragment , tag)
                    .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
                    .commit();
        }
        else {
            getSupportFragmentManager().
                    beginTransaction()
                    .replace(R.id.container, fragment, tag)
                    .commit();

        }
    }

    /**
     * On done selection from dilaer fragment
     * @param number
     */
    @Override
    public void onDoneSelection(String number) {

        VerifyNumberFragment verifyNumberFragment = new VerifyNumberFragment();
        replaceFragment(verifyNumberFragment , "verify" , true);

    }

    @Override
    public void onFragmentInteraction(String code) {

    }
}
