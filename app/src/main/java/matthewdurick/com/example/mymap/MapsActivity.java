package matthewdurick.com.example.mymap;

import androidx.fragment.app.FragmentActivity;

import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.MarkerManager;
import com.google.maps.android.SphericalUtil;

import matthewdurick.com.example.mymap.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); // Changes Map Type to hybrid (Roads and Satellite)

        // Add a marker on Taylor Road
        LatLng person = new LatLng(-27.570668, 153.234747);
        Marker personMark = mMap.addMarker(new MarkerOptions()
                .position(person)
                .title("You Are Here")
                .snippet("long click to drag")
                .draggable(true)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        personMark.setTag("start");

        // Add a marker on LINQ Precinct
        LatLng linq = new LatLng(-27.568670, 153.233669);
        Marker linqMark = mMap.addMarker(new MarkerOptions()
                .position(linq)
                .title("LINQ Precinct"));
        linqMark.setTag("end");

        // Add a marker on the Admin Building
        LatLng admin = new LatLng(-27.57038, 153.23420);
        Marker adminMark = mMap.addMarker(new MarkerOptions()
                .position(admin)
                .title("Admin Building"));
        adminMark.setTag("end");

        /*// Add a marker on the SLC
        LatLng slc = new LatLng(-27.56999, 153.23409);
        Marker slcMark = mMap.addMarker(new MarkerOptions()
                .position(slc)
                .title("SLC"));
        slcMark.setTag("end");

        // Add a marker on the Pavilion
        LatLng pavil = new LatLng(-27.56979, 153.23363);
        Marker pavilMark = mMap.addMarker(new MarkerOptions()
                .position(pavil)
                .title("Pavilion and Cafe 97"));
        pavilMark.setTag("end");

        // Add a marker on the English and Humanities Block
        LatLng enghum = new LatLng(-27.56939, 153.23426);
        Marker enghumMark = mMap.addMarker(new MarkerOptions()
                .position(enghum)
                .title("English and Humanities Block"));
        enghumMark.setTag("end");

        // Add a marker on the Art Block
        LatLng art = new LatLng(-27.56945, 153.23380);
        Marker artMark = mMap.addMarker(new MarkerOptions()
                .position(art)
                .title("Art Block"));
        artMark.setTag("end");

        // Add a marker on the Science Block
        LatLng sci = new LatLng(-27.56958, 153.23322);
        Marker sciMark = mMap.addMarker(new MarkerOptions()
                .position(sci)
                .title("Science Block"));
        sciMark.setTag("end");

        // Add a marker on the Math Block
        LatLng mat = new LatLng(-27.56919, 153.23338);
        Marker matMark = mMap.addMarker(new MarkerOptions()
                .position(mat)
                .title("Math Block"));
        matMark.setTag("end");

        // Add a marker on the Stadium
        LatLng stad = new LatLng(-27.56950, 153.23259);
        Marker stadMark = mMap.addMarker(new MarkerOptions()
                .position(stad)
                .title("Stadium"));
        stadMark.setTag("end");

        // Add a marker on the Performing Arts Block
        LatLng pa = new LatLng(-27.57024, 153.23295);
        Marker paMark = mMap.addMarker(new MarkerOptions()
                .position(pa)
                .title("Performing Arts Block"));
        paMark.setTag("end");

        // Add a marker on the Uniform Shop
        LatLng uni = new LatLng(-27.57037, 153.23384);
        Marker uniMark = mMap.addMarker(new MarkerOptions()
                .position(uni)
                .title("Uniform Shop"));
        uniMark.setTag("end");

        // Add a marker on the Music Rooms
        LatLng mus = new LatLng(-27.56989, 153.23295);
        Marker musMark = mMap.addMarker(new MarkerOptions()
                .position(mus)
                .title("Music Rooms"));
        musMark.setTag("end");

        // Add a marker on the Year 6 Block
        LatLng yr6 = new LatLng(-27.57021, 153.23330);
        Marker yr6Mark = mMap.addMarker(new MarkerOptions()
                .position(yr6)
                .title("Year 6 Block"));
        yr6Mark.setTag("end");*/

        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {

            }
        });
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker){
                Object markertag = marker.getTag(); //creates a variable called markertag that is the tag of the clicked marker

                if (markertag.equals("end")) {
                    Double distance; // Creates a double variable called distance
                    distance = SphericalUtil.computeDistanceBetween(personMark.getPosition(), marker.getPosition()); // Sets distance variable as distance between blue marker location and admin marker
                    int easyDistance = (int) Math.round(distance); // Rounds the distance variable to an int (makes it easier to read in a toast)
                    toastMsg("Distance to " + marker.getTitle() + ": " + easyDistance + "m"); //Brings up toast message that displays the int distance
                    marker.showInfoWindow(); //Show the title of the clicked marker
                    return true;
                }
                else {
                    marker.showInfoWindow(); //Show the title of the clicked marker
                    return true;
                }
            }
        });
        
        mMap.moveCamera(CameraUpdateFactory.newLatLng(person)); // Move the camera to centre over Taylor road marker
        mMap.setMinZoomPreference(18); // the user cannot zoom out lower than 18 and makes 18 the default zoom


    }

    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG); //creates a pop up message
        toast.show(); //displays message

    }


}