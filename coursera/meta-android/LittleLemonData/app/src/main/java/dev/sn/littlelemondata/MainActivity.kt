package dev.sn.littlelemondata

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.MutableCreationExtras
import dev.sn.littlelemondata.data.repository.MenuRepositoryImpl
import dev.sn.littlelemondata.data.source.remote.Api
import dev.sn.littlelemondata.domain.model.MenuItem
import dev.sn.littlelemondata.domain.repository.MenuRepository
import dev.sn.littlelemondata.presentation.MenuViewModel
import dev.sn.littlelemondata.ui.theme.LittleLemonDataTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.sn.littlelemondata.presentation.MenuScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val repository: MenuRepository = (application as App).menuRepository
            val viewModel: MenuViewModel = viewModel(
                factory = MenuViewModel.Factory,
                extras = MutableCreationExtras().apply {
                    set(
                        MenuViewModel.REPOSITORY_KEY,
                        repository
                    )
                }
            )

            LittleLemonDataTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MenuScreen(
                        viewModel = viewModel,
                        paddingValues = innerPadding
                    )
                }
            }
        }
    }
}

