package com.fyrl29074.network.model

import com.google.gson.annotations.SerializedName

data class ServerResponse(
    @SerializedName("products")
    val products: List<ProductDto>
)
