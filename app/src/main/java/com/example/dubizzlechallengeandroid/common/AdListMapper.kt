package com.example.dubizzlechallengeandroid.common

import com.example.dubizzlechallengeandroid.data.dao.backend.dto.ListingResponse
import com.example.dubizzlechallengeandroid.data.repository.vo.AdVO
import java.text.SimpleDateFormat
import java.util.*

object AdListMapper {
    fun toAdVO(listingResponse: ListingResponse) =
        listingResponse.adList.map {
            AdVO(
                it.name,
                it.imageUrlsThumbnails[0],
                it.price,
                convertDate(it.createdAt),
                it.imageUrls[0]
            )
        }

    private fun convertDate(date: String): String {
        val inPattern = "yyyy-MM-dd HH:mm:ss.SSSSSS"
        val outPattern = "dd MMMM yy hh:mm"

        val inFormat = SimpleDateFormat(inPattern, Locale.getDefault())
        val outFormat = SimpleDateFormat(outPattern, Locale.getDefault())

        val inDate = inFormat.parse(date)
        return outFormat.format(inDate!!)
    }

}