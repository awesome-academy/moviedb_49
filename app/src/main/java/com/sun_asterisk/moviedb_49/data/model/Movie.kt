package com.sun_asterisk.moviedb_49.data.model

data class Movie(
    val id: Int? = null,
    val title: String? = null,
    val posterPathUrl: String? = null,
    val backDropPathUrl: String? = null,
    val voteAverage: Double? = null,
    val overView: String? = null,
    val genres: MutableList<Genres>? = null
) {
    class MovieBuilder {
        private var id: Int? = null
        private var title: String? = null
        private var posterPathUrl: String? = null
        private var backDropPathUrl: String? = null
        private var voteAverage: Double? = null
        private var overView: String? = null
        private var genresList: MutableList<Genres>? = null

        fun id(id: Int) = apply { this.id = id }

        fun title(title: String) = apply { this.title = title }

        fun posterPathUrl(posterPathUrl: String) =
            apply { this.posterPathUrl = posterPathUrl }

        fun backDropPathUrl(backDropPathUrl: String) =
            apply { this.backDropPathUrl = backDropPathUrl }

        fun voteAverage(voteAverage: Double) = apply { this.voteAverage = voteAverage }

        fun overView(overView: String) = apply { this.overView = overView }

        fun genresList(genres: MutableList<Genres>) = apply { this.genresList = genres }

        fun bind() =
            Movie(id, title, posterPathUrl, backDropPathUrl, voteAverage, overView, genresList)
    }
}
