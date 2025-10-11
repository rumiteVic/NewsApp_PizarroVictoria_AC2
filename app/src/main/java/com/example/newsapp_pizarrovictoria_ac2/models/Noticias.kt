package com.example.newsapp_pizarrovictoria_ac2.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

enum class TipoNoticia{GENSHIN, HONKAI, EXTRA}

data class Noticias(
    @DrawableRes val imageResourceID: Int,
    @StringRes val stringTituloID: Int,
    @StringRes val stringSubtituloID: Int,
    @StringRes val stringTextID: Int,
    @DrawableRes val avatarID: Int,
    @StringRes val stringAutorID: Int,
    val tipoNoticia: TipoNoticia
)
