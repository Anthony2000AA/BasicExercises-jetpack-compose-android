package pe.edu.upc.mark02.factories

import pe.edu.upc.mark02.model.remote.ApiClient
import pe.edu.upc.mark02.model.remote.JokeService

object JokeServiceFactory {

    fun getJokeService(): JokeService {
        return ApiClient.getRetrofit().create(JokeService::class.java)
    }
}