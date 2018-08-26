package br.com.testehihealth.testmaps;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public static double latitude;
    public static double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Intent intent = getIntent();

        if (intent!=null){
            Bundle bundle = intent.getExtras();
            if (bundle!=null){
                latitude = bundle.getDouble("latitude");
                longitude = bundle.getDouble("longitude");

            }
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng local = new LatLng(latitude,  longitude);
        mMap.addMarker(new MarkerOptions().position(local).title("Sua localização"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(local));
        Toast.makeText(this, String.valueOf(longitude), Toast.LENGTH_LONG).show();

    }
}
