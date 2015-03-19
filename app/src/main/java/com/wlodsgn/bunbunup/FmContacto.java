package com.wlodsgn.bunbunup;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by WiLo on 2/13/2015.
 */
public class FmContacto extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.lay_contactofragment, container, false);

        //Correo
        final Button btnSendMail = (Button) rootView.findViewById(R.id.btnEnviarMail);
        btnSendMail.setOnClickListener(this);

        //Llamada
        Button startBtn = (Button) rootView.findViewById(R.id.makeCall);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                makeCall();
            }
        });

        return rootView;
    }

    public void onClick(View v){
        //final EditText etDe = (EditText) getView().findViewById(R.id.et_EmailDe);
        final EditText etAsunto = (EditText) getView().findViewById(R.id.et_EmailAsunto);
        final EditText etMensaje = (EditText) getView().findViewById(R.id.et_EmailMensaje);

        //String to = etDe.getText().toString();
        String subject = etAsunto.getText().toString();
        String message = etMensaje.getText().toString();

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL  , new String[]{"bonbonup@hotmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);

        // need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Seleciona un cliente de correo"));
    }

    protected void makeCall() {
        Log.i("Hacer Llamada", "");

        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        phoneIntent.setData(Uri.parse("tel:1-954-696-8503"));

        try {
            startActivity(phoneIntent);
            /*finish();*/
            /*Log.i("Finished making a call...", "");*/
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this.getActivity(),
                    "Call failed, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Contacto contacto) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.contacto, contacto);
        return true;
    }*/

}
