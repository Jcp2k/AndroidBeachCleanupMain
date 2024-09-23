package beach.cleanup.app.beachcleanupappv6;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        // Inflate the fragment layout
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Find the button in the inflated layout
        Button btnLogout = view.findViewById(R.id.logout_button);
        Button btnViewmap = view.findViewById(R.id.viewmap_button);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Loop for log out button click
                for (int i = 0; i < 3; i++) {


                    // Perform different logout-related tasks.


                    switch (i) {
                        case 0:
                            // Task 1: Clear shared preferences for Password and Email
                            if (getActivity() != null) {
                                getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE).edit().clear().apply();
                            }
                            break;
                        case 1:
                            // Task 2: Clear cached data
                            // Clear cache or other resources here
                            break;
                        case 2:
                            // Task 3: Redirect to login activity
                            if (getActivity() != null) {
                                Intent intent = new Intent(getActivity(), LoginActivity.class);
                                startActivity(intent);
                                getActivity().finish(); // Close the current activity
                            }
                            break;
                    }
                }
            }
        });

        return view;
    }
}
