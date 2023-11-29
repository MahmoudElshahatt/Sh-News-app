package com.shahtott.sh_news_app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.shahtott.sh_news_app.ui.domain.useCase.AppEntryUseCase
import com.shahtott.sh_news_app.ui.presentation.onboarding.OnBoardingContent
import com.shahtott.sh_news_app.ui.presentation.onboarding.OnBoardingScreen
import com.shahtott.sh_news_app.ui.theme.ShNewsappTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()

        //Compose UI
        setContent {
            ShNewsappTheme {
                Surface {

                }
            }
        }
    }
}
