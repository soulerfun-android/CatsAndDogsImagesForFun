package com.example.lelele.domain.entities

data class ImageItem(
    var id: Int = UNDEFINED_ID,
    var url: String
) {
    companion object {
        private const val UNDEFINED_ID = 0
    }
}
