package com.example.haat.presenter

import android.content.res.Resources
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.haat.R
import com.example.haat.domain.data.HomeData
import com.example.haat.presenter.component.HorizontalBannerCard
import com.example.haat.presenter.viewmodel.HomeViewmodel
import com.example.haat.ui.theme.HaatTheme
import kotlinx.coroutines.flow.collectLatest


@Composable
fun HomeScreen(onNavigation:()->Unit = {}) {
    val viewModel: HomeViewmodel = hiltViewModel()
    LaunchedEffect(Unit) {
        viewModel.loadHomeData()
    }
    HomeScreenComponent(homeScreenState = viewModel.homeScreenState.collectAsState().value,onNavigation)
}


@Composable
fun HomeScreenComponent(homeScreenState: HomeScreenState,onNavigation:()->Unit = {}) {
    Scaffold(
        topBar = {
        }
    ) { paddingValues ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues),
            contentAlignment = Alignment.Center
        )
        {
            if (homeScreenState.isLoading) {
                CircularProgressIndicator()
            } else {
                HomeScreenContent(homeScreenState.homeData)
                {onNavigation()}
            }
        }

    }
}


@Preview
@Composable
fun HomeScreenPrev() {
    HaatTheme {
        HomeScreenComponent(HomeScreenState(isLoading = true))
    }
}


@Preview
@Composable
fun HomeScreenContentPrev() {
    HaatTheme {
        HomeScreenContent()
    }
}


@Composable
fun HomeScreenContent(homeData: HomeData? = null,onItemClick:()->Unit = {}) {
    /*val sampleItems = listOf(
        Triple("Alice", "Designer", "Creative graphic designer"),
        Triple("Bob", "Developer", "Kotlin & Compose enthusiast"),
        Triple("Charlie", "Manager", "Project leader with 10 years exp"),
        Triple("Daisy", "Marketer", "Digital campaigns expert"),
        Triple("Eve", "QA Engineer", "Automation testing specialist"),
        Triple("Frank", "Product Owner", "Leads agile teams effectively"),
        Triple("Grace", "Data Analyst", "Specialist in visualization"),
        Triple("Hank", "DevOps", "CI/CD and cloud automation expert")
    )*/

    val categoryList =homeData?.categories


    // 🔹 State to toggle "Show More / Show Less"
    var showAll by remember { mutableStateOf(false) }

    // 🔹 Control visible list based on toggle
    val visibleItems = if (showAll) categoryList else categoryList?.take(6)


    Log.d("hhh","HomeScreenContent: $homeData")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // 🔹 Horizontal list of cards
        Text(text = "Featured", style = MaterialTheme.typography.titleLarge)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            homeData?.banners?.let {
                items(it) { data ->
                    HorizontalBannerCard(
                        imagePainter = painterResource(id = com.example.haat.R.drawable.ic_launcher_background),
                        title = data.businessName?.en_US ?: "",
                        subtitle = data.businessType ?: "",
                        description = ""
                    )
                }
            }

        }

        // 🔹 Grid layout below
        Text(text = "Category", style = MaterialTheme.typography.titleLarge)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            content = {
                categoryList?.let {
                    items(it) { data ->
                        HorizontalBannerCard(
                            imagePainter = painterResource(id = com.example.haat.R.drawable.ic_launcher_background),
                            title = data.name?:"",
                            subtitle = data.elementType?:"",
                            description = "",
                            modifier = Modifier.clickable{
                                onItemClick.invoke()
                            }
                        )
                    }
                }

            }
        )

        // 🔹 Show More / Show Less Button
        if ((categoryList?.size ?: 0) > 6) {
            Button(
                onClick = { showAll = !showAll },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(if (showAll) "Show Less" else "Show More")
            }
        }
    }


}