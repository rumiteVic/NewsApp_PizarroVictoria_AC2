package com.example.newsapp_pizarrovictoria_ac2.clases

import com.example.newsapp_pizarrovictoria_ac2.R
import com.example.newsapp_pizarrovictoria_ac2.models.Noticias
import com.example.newsapp_pizarrovictoria_ac2.models.TipoNoticia

class DataLoader() {
    fun loadNoticiasInfo() : List <Noticias>{
        return listOf<Noticias>(
            Noticias(imageResourceID = R.drawable.i5 , stringTituloID = R.string.titulo1, stringSubtituloID = R.string.subtitulo1, stringTextID = R.string.texto1, avatarID = R.drawable.a1, stringAutorID = R.string.autor1, tipoNoticia = TipoNoticia.GENSHIN ),
            Noticias(imageResourceID = R.drawable.i4 , stringTituloID = R.string.titulo2, stringSubtituloID = R.string.subtitulo2, stringTextID = R.string.texto2, avatarID = R.drawable.a3, stringAutorID = R.string.autor2, tipoNoticia = TipoNoticia.GENSHIN ),
            Noticias(imageResourceID = R.drawable.i2 , stringTituloID = R.string.titulo3, stringSubtituloID = R.string.subtitulo3, stringTextID = R.string.texto3, avatarID = R.drawable.a1, stringAutorID = R.string.autor1, tipoNoticia = TipoNoticia.GENSHIN ),
            Noticias(imageResourceID = R.drawable.i7 , stringTituloID = R.string.titulo4, stringSubtituloID = R.string.subtitulo4, stringTextID = R.string.texto4, avatarID = R.drawable.a1, stringAutorID = R.string.autor1, tipoNoticia = TipoNoticia.HONKAI ),
            Noticias(imageResourceID = R.drawable.i3 , stringTituloID = R.string.titulo5, stringSubtituloID = R.string.subtitulo5, stringTextID = R.string.texto5, avatarID = R.drawable.a2, stringAutorID = R.string.autor3, tipoNoticia = TipoNoticia.HONKAI ),
            Noticias(imageResourceID = R.drawable.i8 , stringTituloID = R.string.titulo6, stringSubtituloID = R.string.subtitulo6, stringTextID = R.string.texto6, avatarID = R.drawable.a2, stringAutorID = R.string.autor3, tipoNoticia = TipoNoticia.HONKAI ),
            Noticias(imageResourceID = R.drawable.i6 , stringTituloID = R.string.titulo7, stringSubtituloID = R.string.subtitulo7, stringTextID = R.string.texto7, avatarID = R.drawable.a3, stringAutorID = R.string.autor2, tipoNoticia = TipoNoticia.EXTRA ),
            Noticias(imageResourceID = R.drawable.i9 , stringTituloID = R.string.titulo8, stringSubtituloID = R.string.subtitulo8, stringTextID = R.string.texto8, avatarID = R.drawable.a3, stringAutorID = R.string.autor2, tipoNoticia = TipoNoticia.EXTRA ),
            Noticias(imageResourceID = R.drawable.i1 , stringTituloID = R.string.titulo9, stringSubtituloID = R.string.subtitulo9, stringTextID = R.string.texto9, avatarID = R.drawable.a1, stringAutorID = R.string.autor1, tipoNoticia = TipoNoticia.EXTRA ),)
    }
}