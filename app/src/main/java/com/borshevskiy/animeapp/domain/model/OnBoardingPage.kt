package com.borshevskiy.animeapp.domain.model

import androidx.annotation.DrawableRes
import com.borshevskiy.animeapp.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First: OnBoardingPage(R.drawable.greetings,
        "Greetings", "Are you an Anime fan? Because if you are then we have a great news for you!")
    object Second: OnBoardingPage(R.drawable.explore,
        "Explore", "Find your favorite heroes and learn some of the things that you didn't know about.")
    object Third: OnBoardingPage(R.drawable.power,
        "Power", "Check out your hero's power and see how much are they strong comparing to others.")
}
