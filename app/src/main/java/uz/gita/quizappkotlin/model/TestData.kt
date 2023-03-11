package uz.gita.quizappkotlin.model

data class TestData(
    private val question: String,
    private val image: Int,
    private val variant1: String,
    private val variant2: String,
    private val variant3: String,
    private val variant4: String,
    private val answer: String
)
