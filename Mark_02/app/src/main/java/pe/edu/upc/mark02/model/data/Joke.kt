package pe.edu.upc.mark02.model.data

import com.google.gson.annotations.SerializedName

data class Joke(
    @SerializedName("joke")//aqui se le asigna el nombre que tiene en el endpoint
    val text: String
)
