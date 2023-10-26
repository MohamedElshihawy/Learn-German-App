package com.example.learngermauser.shared.presentaion.onBoarding

import androidx.annotation.DrawableRes
import com.example.learngermauser.R

data class OnBoardingPage(
    @DrawableRes val image: Int,
    val title: String,
    val description: String,
)

val pages = listOf(
    OnBoardingPage(
        title = "تعلم الاساسيات.",
        description = "اتقن أساسيات اللغة الألمانية بسهولة. تطبيقنا يقدم مقدمة شاملة لأساسيات اللغة، مما يجعل رحلتك في التعلم ممتعة وفعّالة.",
        image = R.drawable.onboarding_learn_basics,
    ),
    OnBoardingPage(
        title = "بالطريقة التي تناسبك.",
        description = "تعلم اللغة الألمانية بوتيرة خاصة بك، في أي وقت وفي أي مكان يناسبك. تطبيقنا يوفر تعلم مرن، بحيث يمكنك أخذ الدروس في أي وقت يتناسب معك.",
        image = R.drawable.onboarding_at_your_pace,
    ),
    OnBoardingPage(
        title = "مجانا, بدون الحاجة لانشاء حساب.",
        description = "ابدأ مغامرتك في تعلم اللغة الألمانية دون أي تكلفة أو متاعب انشاء حساب.",
        image = R.drawable.ondoarding_no_sign_up,
    ),
)
