package com.example.lapernih;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class PlaceFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng marones = new LatLng(-6.88707630673583, 107.6535843818256);
            LatLng gajua = new LatLng(-6.875031106189167, 107.61904246833316);
            LatLng incorner = new LatLng(-6.882706652578021, 107.66242491066144);
            LatLng kitaku = new LatLng(-6.894205018585726, 107.63533141066151);
            LatLng kopitruk = new LatLng(-6.89958556998792, 107.64205596833332);
            LatLng tengah = new LatLng(-6.915812476478548, 107.64130779716929);

            googleMap.addMarker(new MarkerOptions().position(marones).title("Marones Coffee"));
            googleMap.addMarker(new MarkerOptions().position(gajua).title("372 Coffee"));
            googleMap.addMarker(new MarkerOptions().position(incorner).title("Incorner Coffee"));
            googleMap.addMarker(new MarkerOptions().position(kitaku).title("Kitaku Coffee"));
            googleMap.addMarker(new MarkerOptions().position(kopitruk).title("Kopitruk"));

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tengah, 13));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_place, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}