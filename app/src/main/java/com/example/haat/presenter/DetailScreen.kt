package com.example.haat.presenter


import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.Placeholder
import com.bumptech.glide.integration.compose.placeholder
import com.example.haat.Const
import com.example.haat.R
import com.example.haat.presenter.component.HorizontalBannerCard
import com.example.haat.presenter.viewmodel.DetailsPageViewModel


@Composable
fun DetailScreen() {
    val viewmodel: DetailsPageViewModel = hiltViewModel()

    val state = viewmodel.detailsPageUiState.collectAsState().value
    DetailScreenComponent(state)
    LaunchedEffect(Unit) {
        viewmodel.loadDetailsPage()
    }
}

@Composable
fun DetailScreenComponent(detailScreenState: DetailScreenState) {
    val scrollState = rememberScrollState()
    val bannerHeight = 240.dp // 3:2 aspect ratio (approx)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val img=Const.BASE_URL+detailScreenState.venuInfoData?.bannerImage
        Log.d("hhh","BannerImage: $img")
        // 1️⃣ Banner first → drawn behind
        CollapsingBanner(scrollState, bannerHeight, Const.BASE_URL+detailScreenState.venuInfoData?.bannerImage)

        // 2️⃣ Scrollable content
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
        ) {
            // Reserve banner space (so content starts below it)
            Spacer(modifier = Modifier.height(bannerHeight))

            // Header card overlaps the banner
            HeaderCard(
                detailScreenState.venuInfoData?.name ?: "",
                description = detailScreenState.venuInfoData?.type ?: ""
            )

            // Below card content
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 20.dp)
            ) {
                Text(
                    "Available Category",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

// Sample grid items (replace with your real data)
           /* val items = List(10) { index ->
                Triple("Title ${index + 1}", "Subtitle ${index + 1}", "Description ${index + 1}")
            }*/
            val items = detailScreenState.venuInfoList

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                val columns = 2
                val rows = (items.size + columns - 1) / columns

                for (row in 0 until rows) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        for (col in 0 until columns) {
                            val index = row * columns + col
                            if (index < items.size) {
                                HorizontalBannerCard(
                                    imagePainter = painterResource(id = R.drawable.ic_launcher_foreground),
                                    title = items[index].name,
                                    subtitle = items[index].type,
                                    description = items[index].workingHour,
                                    modifier = Modifier
                                        .weight(1f)
                                        .aspectRatio(2f / 3f) // ✅ maintain 2:3 aspect ratio
                                )
                            } else {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }




        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun CollapsingBanner(scrollState: ScrollState, bannerHeight: Dp,bannerImageUrl:String="") {
    val scrollY = scrollState.value.toFloat()
    val collapseRange = with(LocalDensity.current) { bannerHeight.toPx() }

    // Collapse animation values
    val offset = -scrollY.coerceAtMost(collapseRange)
    val alpha = 1f - (scrollY / collapseRange).coerceIn(0f, 1f)
    val scale = 1f - (scrollY / collapseRange * 0.2f).coerceIn(0f, 1f)

    GlideImage(
        model = bannerImageUrl,
      //  painter = painterResource(id = R.drawable.ic_launcher_background), // your banner image
        contentDescription = "Banner",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(3f / 2f)
            .graphicsLayer {
                translationY = offset
                this.alpha = alpha
                scaleX = scale
                scaleY = scale
            },
        failure = placeholder(R.drawable.ic_launcher_background)
        
    )
}

@Composable
fun HeaderCard(title: String = "", description: String = "") {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .padding(horizontal = 30.dp)
            // overlap 20% of card height onto banner
            .offset(y = (-50).dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFF5F5F5))
            .border(1.dp, Color.LightGray, RoundedCornerShape(20.dp))
            .shadow(8.dp, RoundedCornerShape(20.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(title, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


@Preview
@Composable
fun CollapsingHeaderScreenPrev() {
    DetailScreen()
}


@Preview
@Composable
fun HeaderCardPrev() {
    HeaderCard("test", "description")
}


