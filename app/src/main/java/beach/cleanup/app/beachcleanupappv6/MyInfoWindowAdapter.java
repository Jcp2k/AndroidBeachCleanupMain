package beach.cleanup.app.beachcleanupappv6;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.content.Context;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class MyInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

// Set the context of the MyInfoWindow adapter.
    Context context;
    public MyInfoWindowAdapter(Context context){
        this.context = context;
    }

    {
    }

// getInfoContents null, not in use.
    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }


   // Call infoWindow to marker from on press in MapFragment, find the title/snipp of the marker and display.
    @Override
    public View getInfoWindow(Marker marker) {
        View infoView = LayoutInflater.from(context).inflate(R.layout.custom_info, null);
        TextView title = infoView.findViewById(R.id.title);
        TextView snipp = infoView.findViewById(R.id.snipp);
        title.setText(marker.getTitle());
        snipp.setText(marker.getSnippet());


    // Store pollution status in Marker itself

        String pollutionStatus =(String) marker.getTag();

        // Switch marker colour depending on pollution status.

        switch (pollutionStatus) {
            case "High":
                infoView.setBackgroundColor(Color.RED);
                break;
            case "Medium":
                infoView.setBackgroundColor(Color.YELLOW);
                break;
            case "Low":
                infoView.setBackgroundColor(Color.GREEN);
                break;
            default:
                infoView.setBackgroundColor(Color.WHITE); // Default color
                break;
        }

        return infoView;
    }
}
