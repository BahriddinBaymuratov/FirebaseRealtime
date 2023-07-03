package com.example.firebaserealtime.networking

import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers("Authorization: key=AAAAe1ZtmEQ:APA91bFM_MBlH3YOw2vow6LWdXk6gh9UHRV2Rf7OV7V2MZ5DLYcogsGuozUQE_O4WACVCIcpxCmUBajZPNM8f836p0tqt32cdrUeJXRde__VxgjhtRVWpS-Cm0Du2eIPYr3WkZTn1B_r")
    @POST("fcm/send")
    fun sendMessage()

}