package com.example.a2mee.myrenata.com.net.activety;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.a2mee.myrenata.R;
import com.example.a2mee.myrenata.com.net.adapiter.Config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.a2mee.myrenata.com.net.adapiter.Config.password_SHARED_PREF;

public class MainActivity extends Activity {
    final List<Username_list> Usernamelist = new ArrayList<>();
    String userid;
    Button Logout;
    String User_AxesList_Url = Config.BASE_URL + "user/permissions/";
    Namea_LIST_dapter NAMEadapter;
    // String userid = getIntent().getExtras().getString("ID");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Logout = findViewById(R.id.scrollView2);
        SharedPreferences sharedPreferences = getSharedPreferences(Config.mylogin_PREF_NAME, Context.MODE_PRIVATE);
        userid = sharedPreferences.getString(password_SHARED_PREF, null);
        System.out.print(userid);
        GetDataFromList();
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Logout!!!", Toast.LENGTH_SHORT).show();
                SharedPreferences sharedPreferences = getSharedPreferences(Config.mylogin_PREF_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(Config.password_SHARED_PREF);
                //editor.remove(configlogin.USER_SHARED_PREF);
                editor.clear();
                editor.commit();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void GetDataFromList() {
        final RecyclerView recyclerView = findViewById(R.id.mainlistsView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
//        JSONObject userdatadata = new JSONObject();
        RequestQueue materiallist = Volley.newRequestQueue(getApplicationContext());
        User_AxesList_Url = User_AxesList_Url + userid;
        JsonObjectRequest MaterialIssueRequestdate = new JsonObjectRequest(Request.Method.GET, User_AxesList_Url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.print(response);
                try {
                    JSONObject jsonArray = response;
                    JSONArray ncc = jsonArray.getJSONArray("permissions");
                    {
                        for (int i = 0; i < ncc.length(); i++) {
                            JSONObject jsonObjectss = ncc.getJSONObject(i);
                            Username_list name = new Username_list
                                    (jsonObjectss.getString("permission"),
                                            jsonObjectss.getString("permissionValue"),
                                            jsonObjectss.getString("type"));
                            if ((jsonObjectss.getString("permission")).equals("GRN Inspection")) {
                                Usernamelist.add(name);
                            }
                            if ((jsonObjectss.getString("permission")).equals("Quarantine Store")) {
                                Usernamelist.add(name);
                            }
                            if ((jsonObjectss.getString("permission")).equals("Final Inspection")) {
                                Usernamelist.add(name);
                            }
                            if ((jsonObjectss.getString("permission")).equals("Assembly Inspection")) {
                                Usernamelist.add(name);
                            }
                            if ((jsonObjectss.getString("permission")).equals("Send to FG")) {
                                Usernamelist.add(name);
                            }
                            if ((jsonObjectss.getString("permission")).equals("Dispatch Operator")) {
                                Usernamelist.add(name);
                            }
                            if ((jsonObjectss.getString("permission")).equals("Packaging")) {
                                Usernamelist.add(name);
                            }
                            if ((jsonObjectss.getString("permission")).equals("Store Operator")) {
                                Usernamelist.add(name);

                            }
                            if ((jsonObjectss.getString("permission")).equals("Production")) {
                                Usernamelist.add(name);
                            }
                              /*  if ((jsonObjectss.getString("permission")).equals("Quarantine Store")){
                                    Usernamelist.add(name);
                                }*/
                            // Usernamelist.size();
                            // System.out.println(Usernamelist.get(i));

                            //   Usernamelist.add(name);

                        }
                        NAMEadapter = new Namea_LIST_dapter(Usernamelist, MainActivity.this);
                        recyclerView.setAdapter(NAMEadapter);
                        NAMEadapter.notifyDataSetChanged();
                        //lv.setDivider(new ColorDrawable(Color.parseColor("#FF4A4D93")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    Toast.makeText(getApplicationContext(), "TimeoutError !!!", Toast.LENGTH_LONG).show();

                } else if (error instanceof AuthFailureError) {

                    Toast.makeText(getApplicationContext(), "AuthFailureError !!!", Toast.LENGTH_LONG).show();
                    //TODO
                } else if (error instanceof ServerError) {
                    Toast.makeText(getApplicationContext(), "ServerError !!!", Toast.LENGTH_LONG).show();
                    //TODO
                } else if (error instanceof NetworkError) {
                    Toast.makeText(getApplicationContext(), "NetworkError !!!", Toast.LENGTH_LONG).show();
                    //TODO
                } else if (error instanceof ParseError) {
                    Toast.makeText(getApplicationContext(), "ParseError !!!", Toast.LENGTH_LONG).show();
                    //TODO
                }
                /*Log.d("@#@#", error.getMessage());*/
                Toast.makeText(MainActivity.this, "YOU DON'T HAVE ANY Permission !!!", Toast.LENGTH_SHORT).show();

            }
        });

        materiallist.add(MaterialIssueRequestdate);
    }
}

