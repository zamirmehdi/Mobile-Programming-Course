package com.example.hw5

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.Validators.and
import android.util.Log
import android.widget.*
import androidx.constraintlayout.motion.widget.Debug.getLocation
import androidx.core.app.ActivityCompat
import androidx.core.location.LocationManagerCompat.isLocationEnabled
import androidx.core.view.isGone
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.OnCompleteListener
import java.net.URL

import android.os.Looper
import android.provider.Settings
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hw5.ListDataClass
import com.example.hw5.RetrofitClient
import com.example.hw5.WeatherItemAdapter
import com.google.android.gms.location.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    lateinit var textView1: AutoCompleteTextView
    lateinit var textView2: AutoCompleteTextView

    private lateinit var weatherAdapter: WeatherItemAdapter
    var list: MutableList<ListDataClass> = mutableListOf()

    var long: Float = 0.0f
    var lat: Float = 0.0f
    var city: City = City(long, lat, "")
    var province: Int = 0

    private lateinit var recyclerView: RecyclerView

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this, arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            ), 44
        )
    }

    private fun isLocationEnabled(): Boolean {
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    private fun isLocationPermitted(): Boolean {
        return ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    private val mLocationCallback: LocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            val mLastLocation = locationResult.lastLocation
            Log.d("abb", mLastLocation!!.latitude.toString())
            Log.d("abb", mLastLocation!!.longitude.toString())
            city = City(
                mLastLocation!!.longitude.toFloat(),
                mLastLocation!!.latitude.toFloat(),
                ""
            )
        }
    }

    @SuppressLint("MissingPermission")
    private fun requestNewLocationData() {
        val mLocationRequest = LocationRequest()
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
        mLocationRequest.setInterval(5)
        mLocationRequest.setFastestInterval(0)
        mLocationRequest.setNumUpdates(1)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationClient.requestLocationUpdates(
            mLocationRequest,
            mLocationCallback,
            Looper.myLooper()
        )
    }

    @SuppressLint("MissingPermission")
    fun getLocation() {
        if (isLocationPermitted()) {
            if (isLocationEnabled()) {
                fusedLocationClient.getLastLocation()
                    .addOnSuccessListener { location: Location ->
//                        val location = task.result
                        if (location == null) {
                            requestNewLocationData()
                        } else {
                            println("testtt")
                            println(location)
                            Log.d("abb", location.latitude.toString())
                            Log.d("abb", location.longitude.toString())
                            long = location.longitude.toFloat()
                            lat = location.latitude.toFloat()
                            city = City(long, lat, "")
                        }

                    }
            } else {
                println("\n\n\nnot enabled\n\n\n")
            }
        } else {
            println("\n\n\nnot permitted\n\n\n")
            requestPermissions()
        }
    }

    fun checkInternetConnection(): Boolean {
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)!!.state == NetworkInfo.State.CONNECTED ||
            connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)!!.state == NetworkInfo.State.CONNECTED
        ) {
            return (true)
        } else {
            return (false)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        weatherAdapter = WeatherItemAdapter(this, list)
        recyclerView.adapter = weatherAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        weatherAdapter.notifyDataSetChanged()

        var currentTime: TextView = findViewById(R.id.textView3)

//        recyclerView = findViewById(R.id.recyclerView)
//        getLocation()

//        weatherAdapter = WeatherItemAdapter(this, list)


        val button: Button = findViewById(R.id.button)
        val chooseBtn: Button = findViewById(R.id.button1)
        val cityTV: TextView = findViewById(R.id.textView4)

        val textView: TextView = findViewById(R.id.textView)
        textView1 = findViewById(R.id.Textview1)
        textView2 = findViewById(R.id.Textview2)

        if (checkInternetConnection()) {
            textView.setText("Internet Connected")
        } else textView.setText("No Internet Connection!")


        var provinces = arrayOf("Tehran", "Mazandaran", "Khorasan Razavi", "Esfahan", "Fars")
        var tehran = arrayOf(
            City(51.421509f, 35.694389f, "Tehran"),
            City(51.645699f, 35.3242f, "Varamin"),
            City(52.064999f, 35.717781f, "Damavand"),
            City(51.059299f, 35.659599f, "Shahriar"),
            City(51.082901f, 35.4846f, "Robat Karim")
        )
        var mazandaran = arrayOf(
            City(53.0586f, 36.5659f, "Sari"),
            City(52.350719f, 36.469608f, "Amol"),
            City(52.678951f, 36.551319f, "Babol"),
            City(51.420399f, 36.654999f, "Chalus"),
            City(52.912441f, 36.641151f, "Juybar")
        )
        var khorasanRazavi = arrayOf(
            City(59.606201f, 36.297001f, "Mashhad"),
            City(57.6678f, 36.2152f, "Sabzevar"),
            City(58.795761f, 36.213291f, "Neyshabur"),
            City(57.681911f, 36.212601f, "Sabzevar"),
            City(58.509548f, 37.105999f, "Quchan")
        )
        var esfahan = arrayOf(
            City(51.677608f, 32.657219f, "Isfahan"),
            City(51.43644f, 33.983082f, "Kashan"),
            City(50.288361f, 33.453701f, "Golpayegan"),
            City(50.314968f, 33.22052f, "Khansar"),
            City(51.52113f, 32.70018f, "Khomeyni Shahr")
        )
        var fars = arrayOf(
            City(52.538799f, 29.6036f, "Shiraz"),
            City(51.654148f, 29.61949f, "Kazerun"),
            City(54.544441f, 28.75194f, "Darab"),
            City(51.52174f, 30.11405f, "Nurabad"),
            City(54.327801f, 29.198799f, "Neyriz")
        )

        button.setOnClickListener {
            getLocation()
            Log.d("abb", "onCreate: ")
//            city = City(long, lat, "")
            println("\nCurrent: ")
            println(city)
            println("\n")
            if (city.lat != 0.0f) {
                val toast =
                    Toast.makeText(this, "Current Location Accessed and Set!", Toast.LENGTH_SHORT)
                toast.show()
            }
            textView1.setText("")
            textView2.setText("Current Location")
        }

        chooseBtn.setOnClickListener {
            if (checkInternetConnection()) {
                textView.setText("Internet Connected")
            } else {
                textView.setText("No Internet Connection!")
                cityTV.setText("")
                currentTime.setText("")
                list.clear()
                weatherAdapter.notifyDataSetChanged()
            }

            var retrofit = RetrofitClient.getInstance()
            var apiInterface = retrofit.create(ApiInterface::class.java)
            lifecycleScope.launchWhenCreated {
                try {
                    list.clear()
                    val response =
                        apiInterface.getWeatherSituations(
                            city.lat,
                            city.lon,
                            "b47feaa980cb851c49992031140374ed"
                        )
                    println("\n\n\n\n\n\n")
                    println(city)
                    if (response.isSuccessful()) {
                        println("success")
                        val formatter = SimpleDateFormat("E, HH:mm", Locale.getDefault())
                        val calendar = Calendar.getInstance()
                        currentTime.setText(formatter.format(calendar.time))

                        if (city.name != "") cityTV.setText(response.body()!!.city.name)
                        else cityTV.setText("Current Location")

//                        var index = 0
                        for (i in response.body()!!.list) {
//                            if (index % 3 == 0) {
                            list.add(i)
//                            }
//                            index++
                        }
                        weatherAdapter.notifyDataSetChanged()
                    } else {
                        Log.d("AA", response.errorBody().toString())
                    }
                } catch (Ex: Exception) {
                    Log.d("AA", Ex.toString())
                }
            }


        }


        var adapter: ArrayAdapter<String?> = ArrayAdapter<String?>(
            this,
            R.layout.dropdown_item,
            provinces
        )
        var adapter2: ArrayAdapter<String?> = ArrayAdapter<String?>(
            this,
            R.layout.dropdown_item,
            arrayOf()
        )
        textView1.setAdapter(adapter)
        textView1.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            run {
                textView2.setText("")
                province = position
                var temp: Array<String> = arrayOf("", "", "", "", "")
                when (position) {
                    0 -> {
                        for (i in tehran) {
                            temp.set(tehran.indexOf(i), i.name)
                        }
                        adapter2 = ArrayAdapter<String?>(
                            this,
                            R.layout.dropdown_item,
                            temp
                        )
                        textView2.setAdapter(adapter2)
                    }
                    4 -> {
                        for (i in esfahan) {
                            temp.set(esfahan.indexOf(i), i.name)
                        }
                        adapter2 = ArrayAdapter<String?>(
                            this,
                            R.layout.dropdown_item,
                            temp
                        )
                        textView2.setAdapter(adapter2)
                    }
                    2 -> {
                        for (i in khorasanRazavi) {
                            temp.set(khorasanRazavi.indexOf(i), i.name)
                        }
                        adapter2 = ArrayAdapter<String?>(
                            this,
                            R.layout.dropdown_item,
                            temp
                        )
                        textView2.setAdapter(adapter2)
                    }
                    4 -> {
                        for (i in fars) {
                            temp.set(fars.indexOf(i), i.name)
                        }
                        adapter2 = ArrayAdapter<String?>(
                            this,
                            R.layout.dropdown_item,
                            temp
                        )
                        textView2.setAdapter(adapter2)
                    }
                    1 -> {
                        for (i in mazandaran) {
                            temp.set(mazandaran.indexOf(i), i.name)
                        }
                        adapter2 = ArrayAdapter<String?>(
                            this,
                            R.layout.dropdown_item,
                            temp
                        )
                        textView2.setAdapter(adapter2)
                    }
                }
                Toast.makeText(
                    applicationContext,
                    "" + textView1.getText().toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
        textView2.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            run {
                when (province) {
                    0 -> city = (tehran.get(position))
                    1 -> city = (mazandaran.get(position))
                    2 -> city = (khorasanRazavi.get(position))
                    3 -> city = (esfahan.get(position))
                    4 -> city = (fars.get(position))
                }
                Toast.makeText(
                    applicationContext,
                    "" + textView2.getText().toString(),
                    Toast.LENGTH_SHORT
                ).show()
                println(city)
            }
        })


    }

}