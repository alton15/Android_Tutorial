package com.example.usegooglemap_tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button btn_seoul, btn_daejeon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(MainActivity.this);

        btn_seoul = findViewById(R.id.btn_seoul);
        btn_daejeon = findViewById(R.id.btn_daejeon);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        btn_seoul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap = googleMap;

                LatLng SEOUL = new LatLng(37.56, 126.97);

                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(SEOUL);
                markerOptions.title("서울");
                markerOptions.snippet("한국의 수도");
                mMap.addMarker(markerOptions);

                mMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
            }
        });

        btn_daejeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap = googleMap;

                LatLng DAEJEON = new LatLng(36.35, 127.38);

                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(DAEJEON);
                markerOptions.title("대전");
                markerOptions.snippet("한국의 중심");
                mMap.addMarker(markerOptions);

                mMap.moveCamera(CameraUpdateFactory.newLatLng(DAEJEON));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
            }
        });

    }
}
