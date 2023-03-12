package uz.gita.quizappkotlin_bek.ui.game

import android.util.Log
import uz.gita.quizappkotlin_bek.model.TestData
import uz.gita.quizappkotlin_bek.repository.AppRepository

class GameModel(category: Int) : GameContract.Model {

    private val MAX_COUNT = 10
    private var repository: AppRepository = AppRepository.getInstance()
    private var test: ArrayList<TestData> = ArrayList();
    private var currentPos = 0
    private var wrongCount = 0
    private var correctCount = 0

    init {
        Log.d("AAA", category.toString())
        Log.d("AAA", repository.getNeedDataByCount(category).toString())
        test.addAll(repository.getNeedDataByCount(category))
    }

    override fun check(userAnswer: String) {
        if (test[currentPos - 1].answer.equals(userAnswer, ignoreCase = true)) {
            correctCount++
            repository.setAnswerDataList(
                currentPos, test[currentPos - 1].image,
                userAnswer, test[currentPos - 1].answer
            )
        } else {
            wrongCount++
            repository.setAnswerDataList(
                currentPos, test[currentPos - 1].image,
                userAnswer, test[currentPos - 1].answer
            )
        }
    }

    override fun getNextTest(): TestData {
        return test[currentPos++]
    }

    override fun isLastQuestion(): Boolean {
        return currentPos < MAX_COUNT
    }

    override fun getCurrentPos(): Int {
        return currentPos
    }

    override fun getCorrectAns(): Int {
        return correctCount
    }

    override fun getWrongAns(): Int {
        return wrongCount
    }

    override fun getSkippedAns(): Int {
        return MAX_COUNT - correctCount - wrongCount
    }

    override fun getTotalCount(): Int {
        return MAX_COUNT
    }
}