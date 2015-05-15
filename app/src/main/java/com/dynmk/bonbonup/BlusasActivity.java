package com.dynmk.bonbonup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import com.dynmk.bonbonup.adapter.BlusasGridAdapter;
import com.dynmk.bonbonup.app.AppController;
import com.dynmk.bonbonup.model.Blusas;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

public class BlusasActivity extends ActionBarActivity {

    // Log tag
    private static final String TAG = BlusasActivity.class.getSimpleName();

    // Blusas json url
    private static final String url = "http://wlodsgn.x10host.com/json/blusaslst.json";
    private ProgressDialog pDialog;
    private List<Blusas> blusasGrid = new ArrayList<Blusas>();
    private GridView gridView;
    private BlusasGridAdapter blusasAdapter;
    private static String Titulo="titulo";
    private static String Marca="marca";
    private static String Colour="color";
    private static String Tipo="tipo";
    private static String Referencia="ref";
    private static String bitmap="thumbnailUrl";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blusas);

        //Back button
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // enabling action bar app icon and behaving it as toggle button
        actionBar.setLogo(R.drawable.ic_main);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        gridView = (GridView) findViewById(R.id.gridView);
        blusasAdapter = new BlusasGridAdapter(this, blusasGrid);
        gridView.setAdapter(blusasAdapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Cargando Productos...");
        pDialog.show();

        // changing action bar color
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#1b1b1b")));



        // Creating volley request obj
        JsonArrayRequest blusasReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Blusas blusas = new Blusas();
                                blusas.setTitulo(obj.getString("titulo"));
                                blusas.setThumbnailUrl(obj.getString("image"));
                                blusas.setMarca(obj.getString("marca"));
                                blusas.setColor(obj.getString("color"));
                                blusas.setTipo(obj.getString("tipo"));
                                blusas.setRef(obj.getInt("ref"));

                                // adding blusas to blusas array
                                blusasGrid.add(blusas);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        blusasAdapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(blusasReq);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String nombre = ((TextView) view.findViewById(R.id.titulo))
                        .getText().toString();
                String brand = ((TextView) view.findViewById(R.id.marca))
                        .getText().toString();
                String color = ((TextView) view.findViewById(R.id.color))
                        .getText().toString();
                String tipo = ((TextView) view.findViewById(R.id.tipo))
                        .getText().toString();
                String ref = ((TextView) view.findViewById(R.id.ref))
                        .getText().toString();

                bitmap = ((Blusas) blusasGrid.get(position)).getThumbnailUrl();
                Intent intent = new Intent(BlusasActivity.this, BlusasDetailsActivity.class);
                intent.putExtra(Titulo, nombre);
                intent.putExtra(Marca, brand);
                intent.putExtra(Colour, color);
                intent.putExtra(Tipo, tipo);
                intent.putExtra(Referencia, ref);
                intent.putExtra("image", bitmap);

                startActivity(intent);
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

}
