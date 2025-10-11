package com.example.newsapp_pizarrovictoria_ac2


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Surface
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp_pizarrovictoria_ac2.clases.DataLoader
import com.example.newsapp_pizarrovictoria_ac2.models.Noticias
import com.example.newsapp_pizarrovictoria_ac2.models.TipoNoticia
import com.example.newsapp_pizarrovictoria_ac2.ui.theme.NewsApp_PizarroVictoria_AC2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsApp_PizarroVictoria_AC2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NoticiasApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun NoticiasApp(modifier: Modifier){
    val layoutDirection = LocalLayoutDirection.current
    Surface(modifier = modifier
        .fillMaxSize()
        .statusBarsPadding()
        .padding(
            start = WindowInsets.safeDrawing
                .asPaddingValues()
                .calculateStartPadding(layoutDirection),
            end = WindowInsets.safeDrawing
                .asPaddingValues()
                .calculateEndPadding(layoutDirection)
        )){
        FiltrarNoticias(infoNoticias = DataLoader().loadNoticiasInfo(), modifier)
    }
}
@Composable
fun FiltrarNoticias(infoNoticias: List<Noticias>, modifier: Modifier = Modifier) {

    var categoriaActual by remember { mutableStateOf(TipoNoticia.GENSHIN) }
    val noticiasFiltradas = infoNoticias.filter { it.tipoNoticia == categoriaActual }
    LazyColumn(modifier = modifier) {
        item{
            Row (horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth().background(color = Color.Blue)){
                Text(
                    text = categoriaActual.toString(),
                    textAlign = TextAlign.Center,
                    fontSize = 28.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
            items(items = noticiasFiltradas){
                itemEnListaNoticia -> NoticiasCard(infoNoticias = itemEnListaNoticia, modifier = Modifier.padding(all = 16.dp))
            }
        item{
            Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth().padding(all = 16.dp)){
                Button(onClick = {
                    categoriaActual = when (categoriaActual) {
                        TipoNoticia.HONKAI -> TipoNoticia.GENSHIN
                        TipoNoticia.EXTRA -> TipoNoticia.HONKAI
                        TipoNoticia.GENSHIN -> TipoNoticia.EXTRA
                    }
                }, modifier = Modifier)
                {
                    Text(
                        text = "◀",
                        fontSize = 16.sp,
                        modifier = Modifier
                    )
                }
                Button(onClick = {
                    categoriaActual = when (categoriaActual) {
                        TipoNoticia.GENSHIN -> TipoNoticia.HONKAI
                        TipoNoticia.HONKAI -> TipoNoticia.EXTRA
                        TipoNoticia.EXTRA -> TipoNoticia.GENSHIN
                    }
                }, modifier = Modifier)
                {
                    Text(
                        text = "▶",
                        fontSize = 16.sp,
                        modifier = Modifier
                    )
                }
            }
        }

        }


}

@Composable
fun NoticiasCard(infoNoticias: Noticias, modifier: Modifier = Modifier){
    Card(modifier = modifier){
        Column{
            Image(painter = painterResource(id = infoNoticias.imageResourceID),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 194.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = stringResource(id = infoNoticias.stringTituloID),
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp))

            Text(text = stringResource(id = infoNoticias.stringSubtituloID),
                fontSize = 20.sp,
                modifier = Modifier.padding(16.dp))

            Text(text = stringResource(id = infoNoticias.stringTextID),
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp))

            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
                Image(painter = painterResource(id = infoNoticias.avatarID),
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
                Text(text = stringResource(id = infoNoticias.stringAutorID),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Preview
@Composable
fun GreetingPreview() {
    NewsApp_PizarroVictoria_AC2Theme {
        NoticiasCard(infoNoticias = Noticias(imageResourceID = R.drawable.i5, stringTituloID = R.string.titulo1, stringSubtituloID = R.string.subtitulo1, stringTextID = R.string.texto1, avatarID = R.drawable.a1, stringAutorID = R.string.autor1, tipoNoticia = TipoNoticia.GENSHIN), Modifier)
    }
}