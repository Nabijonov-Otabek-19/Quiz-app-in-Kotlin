package uz.gita.quizappkotlin_bek.model

data class TestData(
    val question: String,
    val image: Int,
    val variant1: String,
    val variant2: String,
    val variant3: String,
    val variant4: String,
    val answer: String
)
