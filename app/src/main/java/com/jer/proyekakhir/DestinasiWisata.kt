package com.jer.proyekakhir

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class DestinasiWisata(
    var nama_destinasi: String,
    var deskripsi_destinasi: String,
    var gambar_destinasi: String
) : Parcelable
