package beach.cleanup.app.beachcleanupappv6;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.annotation.SuppressLint;
import android.os.Bundle;
import beach.cleanup.app.beachcleanupappv6.databinding.ActivityMainBinding;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @SuppressLint("NonConstantResourceId")
    @Override

    // Sets Layout for contentView to be the Navigation Bar

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Makes intial fragment that is displayed to the user in the background the Home page
        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setBackground(null);

        // When logos are pressed in the navigation bar it switches the fragment.

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.home) {
                replaceFragment(new HomeFragment());
                return true;
            }else if (item.getItemId() == R.id.map) {
                replaceFragment(new MapFragment());
                return true;

            }else if (item.getItemId() == R.id.info) {
                replaceFragment(new InformationFragment());
                return true;
            }
            return false;
        });
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

}