package com.sun_asterisk.moviedb_49.data.model

data class Movie(
    val id: Int?,
    val title: String?,
    val posterPathUrl: String?,
    val backDropPathUrl: String?,
    val voteAverage: Double?,
    val overView: String?
) {
    class MovieBuilder {
        private var id: Int? = null
        private var title: String? = null
        private var posterPathUrl: String? = null
        private var backDropPathUrl: String? = null
        private var voteAverage: Double? = null
        private var overView: String? = null

        fun id(id: Int) = apply { this.id = id }

        fun title(title: String) = apply { this.title = title }

        fun posterPathUrl(posterPathUrl: String) =
            apply { this.posterPathUrl = posterPathUrl }

        fun backDropPathUrl(backDropPathUrl: String) =
            apply { this.backDropPathUrl = backDropPathUrl }

        fun voteAverage(voteAverage: Double) = apply { this.voteAverage = voteAverage }

        fun overView(overView: String) = apply { this.overView = overView }

        fun bind() = Movie(id, title, posterPathUrl, backDropPathUrl, voteAverage, overView)
    }
}
