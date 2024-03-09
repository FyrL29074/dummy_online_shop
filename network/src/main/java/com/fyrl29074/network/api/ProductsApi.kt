package com.fyrl29074.network.api

import com.fyrl29074.network.model.ServerResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductsApi {

    @GET("/products")
    suspend fun getProductsBy(
        @Query("skip") skip: Int,
        @Query("limit") limit: Int
    ): ServerResponse
}