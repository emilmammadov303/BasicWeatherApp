package com.example.emilmammadov.havadurumu;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class CityAdapter extends BaseAdapter {

    private LayoutInflater cityInflater;
    private List<Weather> cityList;

    public CityAdapter(Activity activity, List<Weather> cityList){
        cityInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.cityList = cityList;
    }

    @Override
    public int getCount() {
        return cityList.size();
    }

    @Override
    public Object getItem(int position) {
        return cityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View lineView;
        lineView = cityInflater.inflate(R.layout.list_row_weather, null);
        TextView textViewCityName = lineView.findViewById(R.id.city);
        TextView textViewTemp = lineView.findViewById(R.id.temp);
        ImageView imageView = lineView.findViewById(R.id.image);

        Weather weather = cityList.get(position);
        textViewCityName.setText(weather.getCityWeather());
        textViewTemp.setText(weather.getTempWeather());
        switch(weather.getImgIdWeather()){
            case 1:
                imageView.setImageResource(R.drawable.clear_sky);
                break;
            case 2:
                imageView.setImageResource(R.drawable.few_clouds);
                break;
            case 3:
                imageView.setImageResource(R.drawable.scattered_clouds);
                break;
            case 4:
                imageView.setImageResource(R.drawable.broken_clouds);
                break;
            case 5:
                imageView.setImageResource(R.drawable.shower_rain);
                break;
            case 6:
                imageView.setImageResource(R.drawable.rain);
                break;
            case 7:
                imageView.setImageResource(R.drawable.thunderstorm);
                break;
            case 8:
                imageView.setImageResource(R.drawable.snow);
                break;
            case 9:
                imageView.setImageResource(R.drawable.mist);
                break;
            case 10:
                imageView.setImageResource(R.drawable.broken_clouds);

        }


        return lineView;
    }
}