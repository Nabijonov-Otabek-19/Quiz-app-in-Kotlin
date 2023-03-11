package uz.gita.quizappkotlin.model

data class AnswerData(
    private val id: Int,
    private val image: Int,
    private val userAns: String,
    private val correctAns: String
)
