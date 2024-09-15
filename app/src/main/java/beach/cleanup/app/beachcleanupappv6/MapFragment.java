package beach.cleanup.app.beachcleanupappv6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapFragment extends Fragment implements OnMapReadyCallback {
        private GoogleMap myMap;


        @Override
        @Nullable

        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_map, container, false);
        }


        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
            if (mapFragment != null) {
                mapFragment.getMapAsync(this);
            }
        }

        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            myMap = googleMap;
            LatLng orientalbay = new LatLng(-41.2916, 174.7929);
            myMap.addMarker(new MarkerOptions().position(orientalbay).title("Oriental Bay"));
            myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(orientalbay, 15));

            LatLng lyallbay = new LatLng(-41.3291, 174.7953);
            myMap.addMarker(new MarkerOptions().position(lyallbay).title("Lyall Bay"));
            myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lyallbay, 15));

            myMap.getUiSettings().setZoomControlsEnabled(true);



            myMap.setInfoWindowAdapter(new MyInfoWindowAdapter(requireContext()));


            myMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    marker.showInfoWindow();
                    return true;
                }
            });
        }
}
