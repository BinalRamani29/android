package com.example.example

import com.google.gson.annotations.SerializedName


data class Payload(

    @SerializedName("card") var card: Card? = Card()

)