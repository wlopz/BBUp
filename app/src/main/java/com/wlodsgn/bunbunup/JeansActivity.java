package com.wlodsgn.bunbunup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import com.wlodsgn.bunbunup.adapter.CustomListAdapter;
import com.wlodsgn.bunbunup.app.AppController;
import com.wlodsgn.bunbunup.model.Jeans;

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
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

/**
 * Created by WiLo on 2/27/2015.
 */
public class JeansActivity extends ActionBarActivity {

    /**@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeans);




    }**/

    // Log tag
    private static final String TAG = JeansActivity.class.getSimpleName();

    // Jeans json url
    private static final String url = "http://wlodsgn.x10host.com/json/jnslst.json";
    private ProgressDialog pDialog;
    private List<Jeans> jeansList = new ArrayList<Jeans>();
    private ListView listView;
    private CustomListAdapter adapter;
    private static String Titulo="titulo";
    private static String Marca="marca";
    private static String Colour="color";
    private static String Tipo="tipo";
    private static String Referencia="ref";
    private static String bitmap="thumbnailUrl";
    private static String bitmap2="thumbnailUrl2";
    private static String bitmap3="thumbnailUrl3";

    private static String bitmapfull="thumbnailUrlFS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeans);

        //Back button
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.list);
        adapter = new CustomListAdapter(this, jeansList);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // changing action bar color
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#1b1b1b")));

        // Creating volley request obj
        JsonArrayRequest jeansReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Jeans jeans = new Jeans();
                                jeans.setTitulo(obj.getString("titulo"));
                                jeans.setThumbnailUrl(obj.getString("image"));
                                jeans.setThumbnailUrl2(obj.getString("image2"));
                                jeans.setThumbnailUrl3(obj.getString("image3"));
                                jeans.setMarca(obj.getString("marca"));
                                jeans.setColor(obj.getString("color"));
                                jeans.setTipo(obj.getString("tipo"));
                                jeans.setRef(obj.getInt("ref"));

                                // adding jeans to jeans array
                                jeansList.add(jeans);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();

            }
        });

        // Adding request to request queue
        /**AppController.getInstance().addToRequestQueue(JeansReq);**/
        AppController.getInstance().addToRequestQueue(jeansReq);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

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

                bitmap = ((Jeans) jeansList.get(position)).getThumbnailUrl();
                bitmap2 = ((Jeans) jeansList.get(position)).getThumbnailUrl2();
                bitmap3 = ((Jeans) jeansList.get(position)).getThumbnailUrl3();
                bitmapfull = ((Jeans) jeansList.get(position)).getThumbnailUrlFS();
                Intent intent = new Intent(JeansActivity.this, JeansDetailsActivity.class);
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

    /**@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }**/

}
