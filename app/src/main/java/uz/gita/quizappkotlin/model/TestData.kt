package uz.gita.quizappkotlin.model

data class TestData(
    val question: String,
    val image: Int,
    val variant1: String,
    val variant2: String,
    val variant3: String,
    val variant4: String,
    val answer: String
)
