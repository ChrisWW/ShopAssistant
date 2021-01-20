package com.example.shopassistantproject
/*
val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
val criteria = Criteria()
criteria.isAltitudeRequired = true
criteria.accuracy = Criteria.ACCURACY_FINE
criteria.powerRequirement = Criteria.NO_REQUIREMENT
val provider = locationManager.getBestProvider(criteria, false)
val location = locationManager.getLastKnownLocation(provider.toString())


if(location!=null) {
    Toast.makeText(
        this,
    "Szerokość: ${location.latitude}, Długość: ${location.longitude}",
    Toast.LENGTH_SHORT).show()
}
else{
    Toast.makeText(this, “Brak informacji o położeniu.(", Toast.LENGTH_SHORT).show()")
}


//Zezwolenia, ale to juz jest w mapsactivity tylko requestCode = 0 a nie 1, i bez backgroundlocation
val perms = arrayOf(        Manifest.permission.ACCESS_BACKGROUND_LOCATION,        Manifest.permission.ACCESS_FINE_LOCATION,        Manifest.permission.ACCESS_COARSE_LOCATION)val requestCode = 1if (ActivityCompat.checkSelfPermission(                this,                Manifest.permission.ACCESS_FINE_LOCATION        ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(                this,                Manifest.permission.ACCESS_COARSE_LOCATION        ) != PackageManager.PERMISSION_GRANTED) {    requestPermissions(perms, requestCode)}


// Location LIstener? Nasluchuje zmiany

// Wylapanie za pomoca geofence lokalizacji i broadcasterreceiver


 */