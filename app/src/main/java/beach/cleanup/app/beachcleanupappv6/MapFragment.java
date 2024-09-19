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
// Set strings for pollutionstatus of both markers.
            String pollutionStatusOrientalBay = "High";
            String pollutionStatusLyallBay = "Low";

// Add Marker and Marker settings for Oriental Bay - Polution status string in Snippet
            LatLng orientalbay = new LatLng(-41.2916,  174.7929);
            Marker orientalbaymarker = myMap.addMarker(new MarkerOptions()
                    .position(orientalbay)
                    .title("Oriental Bay")
                    .snippet(("Pollution Status: " + pollutionStatusOrientalBay)));
// Sets the information in the marker to remain as the Pollution status and Zoom settings
            orientalbaymarker.setTag(pollutionStatusOrientalBay);

            myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(orientalbay, 15));
//  // Add Marker and Marker settings for Lyall Bay - Polution status string in Snippet
            LatLng lyallbay = new LatLng(-41.3291, 174.7953);
            Marker lyallbaymarker= myMap.addMarker(new MarkerOptions()
                    .position(lyallbay)
                    .title("Lyall Bay")
                    .snippet(("Pollution Status: " + pollutionStatusLyallBay)));
// Sets the information in the marker to remain as the Pollution status and Zoom settings
           lyallbaymarker.setTag(pollutionStatusLyallBay);

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
