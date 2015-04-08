package com.wlodsgn.bunbunup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by WILO on 3/24/2015.
 */
public class CntctoDtlsActvty extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cntctodtlsactvty);
        final Button btnSendMail = (Button) findViewById(R.id.btnEnviarMail2);
        btnSendMail.setOnClickListener(this);

        //Back button
        ActionBar actionBar = getSupportActionBar();


        // enabling action bar app icon and behaving it as toggle button
        actionBar.setLogo(R.drawable.ic_main);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);


    }

    public void onClick(View vw){
        //final EditText etDe = (EditText) getView().findViewById(R.id.et_EmailDe);
        final EditText etAsunto2 = (EditText) findViewById(R.id.et_EmailAsunto2);
        final EditText etMensaje2 = (EditText) findViewById(R.id.et_EmailMensaje2);

        //String to = etDe.getText().toString();
        String subject = etAsunto2.getText().toString();
        String message = etMensaje2.getText().toString();

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL  , new String[]{"bonbonup@hotmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);

        // need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Seleciona un cliente de correo"));
    }

    /*@Override
    public boolean onCreateOptionsMenu(Contacto contacto) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.contacto, contacto);
        return true;
    }*/

}
