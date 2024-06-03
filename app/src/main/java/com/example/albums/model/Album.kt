package com.example.albums.model

import kotlinx.serialization.Serializable

@Serializable
data class Album(
    val id: String,
    val name: String,
    val band: String,
    val albumInfo: AlbumInfo,
    val saleInfo: SaleInfo
) {

    fun getPrice() : String {
        if (saleInfo.listPrice == null) {
            return ""
        }
        return "${saleInfo.listPrice.amount} ${saleInfo.listPrice.currency}"
    }

}

@Serializable
data class AlbumInfo(
    val title: String,
    val description: String,
    val imageLinks: ImageLinks? = null,
)

@Serializable
data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String,
) {
    val httpsThumbnail : String
        get() = thumbnail.replace("http", "https")
}


@Serializable
data class SaleInfo(
    val country: String,
    val isEbook: Boolean,
    val listPrice: ListPrice?
) {
    // Notes: This works...
    val getPrice2 : String
        get() = "${listPrice?.amount ?: "N/A"} ${listPrice?.currency ?: "N/A"}"

}




@Serializable
data class ListPrice(
    val amount: Float?,
    val currency: String? = ""
)
