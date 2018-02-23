package com.example.emilmammadov.havadurumu;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;


public class Main2Activity extends AppCompatActivity {

    public Activity mContext;
    public static final List<Weather> cityList = new ArrayList <Weather>();
    ListView cityListView;

    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        try{
        mContext = this;

            cityListView = findViewById(R.id.list_view);


            arrayList = new ArrayList<String>();
            Intent i = getIntent();
            arrayList = i.getStringArrayListExtra("send_array");

        Log.e("ArrayList size", arrayList.size()+"");
        for (String donecekArray: arrayList) {
            findWeather(donecekArray);
        }

            //cityList.add(new Weather("Baku"," C", 1));
            //cityList.add(new Weather("Istanbul"," C", 1));

        Log.e("findWeather cikti", cityList.size()+"");



        }catch(Exception e)
        {
            Log.i("bizim baslik", e.toString());
        }

    }


    public void findWeather(String sehir)
    {
        String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=";
        String key = "&appid=5997ce6d7f61942bc6823495d5800015";
        String url = apiUrl+sehir+key;
        Log.e("Girdi url",url);

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.e("Find Weather evvelki","girdi");
                    JSONObject mainObject = response.getJSONObject("main");
                    JSONArray array = response.getJSONArray("weather");
                    Log.e("Find Weather json ilk","girdi");
                    JSONObject object = array.getJSONObject(0);
                    NumberFormat formatter = new DecimalFormat("#0.00");
                    Double tempDouble = mainObject.getDouble("temp") - 273.15;
                    String description = object.getString("description");
                    String city = response.getString("name");
                    Log.e("Find Weather ikinci","girdi");

                    String temp = formatter.format(tempDouble);
                    Log.e(city +"Sehrimiz", temp);
                    switch(description){
                        case "clear sky":
                                cityList.add(new Weather(city, temp+" Celcius", 1));
                                break;
                        case "few clouds":
                            cityList.add(new Weather(city, temp+" Celcius", 2));
                            break;
                        case "scattered clouds":
                            cityList.add(new Weather(city, temp+" Celcius", 3));
                            break;
                        case "broken clouds":
                            cityList.add(new Weather(city, temp+" Celcius", 4));
                            break;
                        case "shower rain":
                            cityList.add(new Weather(city, temp+" Celcius", 5));
                            break;
                        case "rain":
                            cityList.add(new Weather(city, temp+" Celcius", 6));
                            break;
                        case "thunderstorm":
                            cityList.add(new Weather(city, temp+" Celcius", 7));
                            break;
                        case "snow":
                            cityList.add(new Weather(city, temp+" Celcius", 8));
                            break;
                        case "mist":
                            cityList.add(new Weather(city, temp+" Celcius", 9));
                            break;
                        default:
                            cityList.add(new Weather(city, temp+" Celcius", 10));
                            break;


                    }

                    Log.e("CityList size json", cityList.size()+"");
                    CityAdapter cityadapter = new CityAdapter(Main2Activity.this, cityList);
                    cityListView.setAdapter(cityadapter);

                } catch (JSONException e) {
                    Log.e("Hata basligi",e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );


        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jor);


    }

}






