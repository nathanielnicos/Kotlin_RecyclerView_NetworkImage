package id.nns.recyclerview_img_network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kara (
    var name: String?,
    var det: String?,
    var url: String?
) : Parcelable