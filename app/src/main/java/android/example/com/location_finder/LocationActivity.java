package android.example.com.location_finder;

import android.app.LoaderManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LocationActivity extends AppCompatActivity {

    private TextView mlongitude;

    private TextView mlattitude;

    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        mlongitude = (TextView) findViewById(R.id.longitudeTextGPS);

        mlattitude = (TextView) findViewById(R.id.latitudeTextGPS);

        locationManager = (LocationManager)getSystemService(getApplicationContext().LOCATION_SERVICE);

        if(isEnabled()){


        }
        else{

            showAlert();
        }


    }

    private boolean isEnabled(){

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled
                (LocationManager.NETWORK_PROVIDER);
    }

    private void showAlert(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.enable_loc).setMessage("Your Locations Settings is set to 'Off'.\nPlease Enable " +
                        "Location to " + "use this app");

        builder.setPositiveButton("Location Settings", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
