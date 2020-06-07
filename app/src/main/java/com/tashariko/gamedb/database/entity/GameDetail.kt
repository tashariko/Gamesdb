package com.tashariko.gamedb.database.entity
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "gameDetail")
@Parcelize
data class GameDetail(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("cover")
    val cover: Int?,
    @SerializedName("created_at")
    val createdAt: Int?,
    @SerializedName("first_release_date")
    val firstReleaseDate: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("pulse_count")
    val pulseCount: Int?,
    @SerializedName("rating")
    val rating: Double?,
    @SerializedName("rating_count")
    val ratingCount: Int?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("summary")
    val summary: String?,
    @SerializedName("total_rating")
    val totalRating: Double?,
    @SerializedName("total_rating_count")
    val totalRatingCount: Int?,
    @SerializedName("updated_at")
    val updatedAt: Int?,
    @SerializedName("url")
    val url: String?
) : Parcelable
