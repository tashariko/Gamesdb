package com.tashariko.gamedb.application


object AppConstants {
    const val DATABASE_NAME = "tashaGames.db"

    const val gameListItemsFields = "fields cover,created_at, first_release_date,name,parent_game,popularity,pulse_count,rating,rating_count,slug,standalone_expansions,status,storyline,summary,time_to_beat,total_rating,total_rating_count,updated_at,url,version_parent,version_title; limit 100; sort popularity desc;"
}