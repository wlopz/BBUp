package com.dynmk.bonbonup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import com.dynmk.bonbonup.adapter.LeggingsGridAdapter;
import com.dynmk.bonbonup.app.AppController;
import com.dynmk.bonbonup.model.Leggings;
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

public class LeggingsActivity extends ActionBarActivity {

    // Log tag
    private static final String TAG = LeggingsActivity.class.getSimpleName();

    // Leggings json url
    private static final String url = "http://bonbonup.x10host.com/json/leggingslst.json";
    private ProgressDialog pDialog;
    private List<Leggings> leggingsGrid = new ArrayList<Leggings>();
    private GridView gridView;
    private LeggingsGridAdapter leggingsAdapter;
    private static String Titulo="titulo";
    private static String Marca="marca";
    private static String Colour="color";
    private static String Tipo="tipo";
    private static String Referencia="ref";
    private static String bitmap="thumbnailUrl";
    private static String bitmap2="thumbnailUrl2";
    private static String bitmap3="thumbnailUrl3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leggings);

        //Back button
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // enabling action bar app icon and behaving it as toggle button
        actionBar.setLogo(R.drawable.ic_main);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        gridView = (GridView) findViewById(R.id.gridView);
        leggingsAdapter = new LeggingsGridAdapter(this, leggingsGrid);
        gridView.setAdapter(leggingsAdapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Cargando Productos...");
        pDialog.show();

        // changing action bar color
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#1b1b1b")));



        // Creating volley request obj
        JsonArrayRequest leggingsReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Leggings leggings = new Leggings();
                                leggings.setTitulo(obj.getString("titulo"));
                                leggings.setThumbnailUrl(obj.getString("image"));
                                leggings.setThumbnailUrl2(obj.getString("image2"));
                                leggings.setThumbnailUrl3(obj.getString("image3"));
                                leggings.setMarca(obj.getString("marca"));
                                leggings.setColor(obj.getString("color"));
                                leggings.setTipo(obj.getString("tipo"));
                                leggings.setRef(obj.getInt("ref"));

                                // adding leggings to leggings array
                                leggingsGrid.add(leggings);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        leggingsAdapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(leggingsReq);
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

                bitmap = ((Leggings) leggingsGrid.get(position)).getThumbnailUrl();
                bitmap2 = ((Leggings) leggingsGrid.get(position)).getThumbnailUrl2();
                bitmap3 = ((Leggings) leggingsGrid.get(position)).getThumbnailUrl3();
                Intent intent = new Intent(LeggingsActivity.this, LeggingsDetailsActivity.class);
                intent.putExtra(Titulo, nombre);
                intent.putExtra(Marca, brand);
                intent.putExtra(Colour, color);
                intent.putExtra(Tipo, tipo);
                intent.putExtra(Referencia, ref);
                intent.putExtra("image", bitmap);
                intent.putExtra("image2", bitmap2);
                intent.putExtra("image3", bitmap3);

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
