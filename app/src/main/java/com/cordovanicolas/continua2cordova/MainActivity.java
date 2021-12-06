package com.cordovanicolas.continua2cordova;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements HostNavigation{

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState ==null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new LoginFragment())
                    .commit();
        }}

    /**Aqui va el fragmento de navegacion
     *@param fragment Fragmento a donde vamos a navegar
     *@param addToBackstack Si podemos ir hacia atras o no
     * */
    @Override
    public void navigateTo(Fragment fragment, boolean addToBackstack){
        FragmentTransaction transaction=
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment);

        if(addToBackstack){
            transaction.addToBackStack(null);

        }
        transaction.commit();

    }

}