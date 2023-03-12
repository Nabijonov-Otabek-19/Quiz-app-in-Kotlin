package uz.gita.quizappkotlin_bek.repository

import uz.gita.quizappkotlin_bek.R
import uz.gita.quizappkotlin_bek.model.AnswerData
import uz.gita.quizappkotlin_bek.model.TestData

class AppRepository private constructor() {
    private val list_flag: ArrayList<TestData> = ArrayList()
    private val list_logo: ArrayList<TestData> = ArrayList()
    private val list_animal: ArrayList<TestData> = ArrayList()
    private val list_food: ArrayList<TestData> = ArrayList()
    private val list_fruit: ArrayList<TestData> = ArrayList()
    private val list_vegetable: ArrayList<TestData> = ArrayList()

    private val answerDataList: ArrayList<AnswerData> = ArrayList()

    companion object {
        private lateinit var instance: AppRepository

        fun getInstance(): AppRepository {
            if (!(::instance.isInitialized))
                instance = AppRepository()

            return instance
        }
    }

    init {
        loadData()
    }

    fun clearAllAnswers() {
        answerDataList.clear()
    }

    fun setAnswerDataList(id: Int, image: Int, userAns: String, corrAns: String) {
        answerDataList.add(AnswerData(id, image, userAns, corrAns))
    }

    fun getAnswerDataList(): List<AnswerData> {
        return answerDataList
    }

    fun getNeedDataByCount(count: Int): ArrayList<TestData> {
        if (count == 1) return list_flag
        else if (count == 2) return list_logo
        else if (count == 3) return list_animal
        else if (count == 4) return list_food
        else if (count == 5) return list_fruit
        else return list_vegetable
    }


    private fun loadData() {
        shuffleListFlag()
        shuffleListLogo()
        shuffleListAnimal()
        shuffleListFood()
        shuffleListFruit()
        shuffleListVegetable()
    }

    private fun shuffleListFlag() {
        list_flag.add(
            TestData(
                "Which country's flag is this?",
                R.drawable.german,
                "Uzbekistan",
                "India",
                "Brazil",
                "German",
                "German"
            )
        )
        list_flag.add(
            TestData(
                "Which country's flag is this?",
                R.drawable.america,
                "Uzbekistan",
                "America",
                "Brazil",
                "German",
                "America"
            )
        )
        list_flag.add(
            TestData(
                "Which country's flag is this?",
                R.drawable.argentina,
                "Argentina",
                "India",
                "Brazil",
                "America",
                "Argentina"
            )
        )
        list_flag.add(
            TestData(
                "Which country's flag is this?",
                R.drawable.britian,
                "Pakistan",
                "India",
                "Great Britian",
                "German",
                "Great Britian"
            )
        )
        list_flag.add(
            TestData(
                "Which country's flag is this?",
                R.drawable.canada,
                "Uzbekistan",
                "Canada",
                "Brazil",
                "German",
                "Canada"
            )
        )
        list_flag.add(
            TestData(
                "Which country's flag is this?",
                R.drawable.india,
                "Uzbekistan",
                "India",
                "Brazil",
                "German",
                "India"
            )
        )
        list_flag.add(
            TestData(
                "Which country's flag is this?",
                R.drawable.japan,
                "Uzbekistan",
                "India",
                "Brazil",
                "Japan",
                "Japan"
            )
        )
        list_flag.add(
            TestData(
                "Which country's flag is this?",
                R.drawable.korea,
                "Korea",
                "India",
                "Brazil",
                "German",
                "Korea"
            )
        )
        list_flag.add(
            TestData(
                "Which country's flag is this?",
                R.drawable.russia,
                "Uzbekistan",
                "India",
                "Russia",
                "German",
                "Russia"
            )
        )
        list_flag.add(
            TestData(
                "Which country's flag is this?",
                R.drawable.ukraina,
                "Ukraina",
                "India",
                "Brazil",
                "German",
                "Ukraina"
            )
        )
        list_flag.shuffle()
    }

    private fun shuffleListLogo() {
        list_logo.add(
            TestData(
                "Name this logo",
                R.drawable.wikipedia,
                "Youtube",
                "Google",
                "Wikipedia",
                "Pinterest",
                "Wikipedia"
            )
        )
        list_logo.add(
            TestData(
                "Name this logo",
                R.drawable.snapchat,
                "Snapchat",
                "Google",
                "Wikipedia",
                "Twitter",
                "Snapchat"
            )
        )
        list_logo.add(
            TestData(
                "Name this logo",
                R.drawable.twitch,
                "Youtube",
                "Vimeo",
                "Wikipedia",
                "Twitch",
                "Twitch"
            )
        )
        list_logo.add(
            TestData(
                "Name this logo",
                R.drawable.pinterest,
                "Github",
                "Google",
                "Pinterest",
                "LinkedIn",
                "Pinterest"
            )
        )
        list_logo.add(
            TestData(
                "Name this logo",
                R.drawable.twitter,
                "Youtube",
                "Twitter",
                "Dropbox",
                "Pinterest",
                "Twitter"
            )
        )
        list_logo.add(
            TestData(
                "Name this logo",
                R.drawable.linkedin,
                "LinkedIn",
                "Google",
                "Wikipedia",
                "Pinterest",
                "LinkedIn"
            )
        )
        list_logo.add(
            TestData(
                "Name this logo",
                R.drawable.github,
                "Youtube",
                "Github",
                "Wikipedia",
                "Twitch",
                "Github"
            )
        )
        list_logo.add(
            TestData(
                "Name this logo",
                R.drawable.stackoverflow,
                "StackOverFlow",
                "Youtube",
                "Wikipedia",
                "Pinterest",
                "StackOverFlow"
            )
        )
        list_logo.add(
            TestData(
                "Name this logo",
                R.drawable.spotify,
                "Youtube",
                "Facebook",
                "Wikipedia",
                "Spotify",
                "Spotify"
            )
        )
        list_logo.add(
            TestData(
                "Name this logo",
                R.drawable.vimeo,
                "Facebook",
                "Google",
                "Vimeo",
                "Vine",
                "Vimeo"
            )
        )
        list_logo.shuffle()
    }

    private fun shuffleListAnimal() {
        list_animal.add(
            TestData(
                "Name this animal",
                R.drawable.bear,
                "Bear",
                "Fox",
                "Bull",
                "Rabbit",
                "Bear"
            )
        )
        list_animal.add(
            TestData(
                "Name this animal",
                R.drawable.lion,
                "Bear",
                "Lion",
                "Bull",
                "Rabbit",
                "Lion"
            )
        )
        list_animal.add(
            TestData(
                "Name this animal",
                R.drawable.surikat,
                "Bear",
                "Fox",
                "Suricata",
                "Wolf",
                "Suricata"
            )
        )
        list_animal.add(
            TestData(
                "Name this animal",
                R.drawable.koala,
                "Lion",
                "Fox",
                "Bull",
                "Koala",
                "Koala"
            )
        )
        list_animal.add(
            TestData(
                "Name this animal",
                R.drawable.owl,
                "Bear",
                "Owl",
                "Bull",
                "Rabbit",
                "Owl"
            )
        )
        list_animal.add(
            TestData(
                "Name this animal",
                R.drawable.elephant,
                "Monkey",
                "Fox",
                "Bull",
                "Elephant",
                "Elephant"
            )
        )
        list_animal.add(
            TestData(
                "Name this animal",
                R.drawable.squirrel,
                "Squirrel",
                "Fox",
                "Bear",
                "Rabbit",
                "Squirrel"
            )
        )
        list_animal.add(
            TestData(
                "Name this animal",
                R.drawable.monkey,
                "Bear",
                "Wolf",
                "Monkey",
                "Bull",
                "Monkey"
            )
        )
        list_animal.add(
            TestData(
                "Name this animal",
                R.drawable.bull,
                "Bear",
                "Fox",
                "Bull",
                "Rabbit",
                "Bull"
            )
        )
        list_animal.add(
            TestData(
                "Name this animal",
                R.drawable.rabbit,
                "Bear",
                "Wolf",
                "Bull",
                "Rabbit",
                "Rabbit"
            )
        )
        list_animal.shuffle()
    }

    private fun shuffleListFood() {
        list_food.add(
            TestData(
                "Name this food",
                R.drawable.cake,
                "Cake",
                "Burger",
                "Cheese",
                "Pizza",
                "Cake"
            )
        )
        list_food.add(
            TestData(
                "Name this food",
                R.drawable.sausage,
                "Cake",
                "Sausage",
                "Cheese",
                "Norin",
                "Sausage"
            )
        )
        list_food.add(
            TestData(
                "Name this food",
                R.drawable.cheese,
                "Ice Cream",
                "Burger",
                "Cheese",
                "Pizza",
                "Cheese"
            )
        )
        list_food.add(
            TestData(
                "Name this food",
                R.drawable.egg,
                "Cake",
                "Burger",
                "Cheese",
                "Egg",
                "Egg"
            )
        )
        list_food.add(
            TestData(
                "Name this food",
                R.drawable.kebab,
                "Kebab",
                "Burger",
                "Lavash",
                "Pizza",
                "Kebab"
            )
        )
        list_food.add(
            TestData(
                "Name this food",
                R.drawable.stake,
                "Egg",
                "Burger",
                "Stake",
                "Pizza",
                "Stake"
            )
        )
        list_food.add(
            TestData(
                "Name this food",
                R.drawable.palov,
                "Cake",
                "Palov",
                "Cheese",
                "Milk",
                "Palov"
            )
        )
        list_food.add(
            TestData(
                "Name this food",
                R.drawable.pizza,
                "Egg",
                "Burger",
                "Cheese",
                "Pizza",
                "Pizza"
            )
        )
        list_food.add(
            TestData(
                "Name this food",
                R.drawable.milk,
                "Cake",
                "Burger",
                "Milk",
                "Stake",
                "Milk"
            )
        )
        list_food.add(
            TestData(
                "Name this food",
                R.drawable.ice_cream,
                "Cake",
                "Ice Cream",
                "Cheese",
                "Pizza",
                "Ice Cream"
            )
        )
        list_food.shuffle()
    }

    private fun shuffleListFruit() {
        list_fruit.add(
            TestData(
                "Name this fruit",
                R.drawable.raspberry,
                "Raspberry",
                "Grape",
                "Pineapple",
                "Cherry",
                "Raspberry"
            )
        )
        list_fruit.add(
            TestData(
                "Name this fruit",
                R.drawable.strawberry,
                "Raspberry",
                "Strawberry",
                "Pineapple",
                "Cherry",
                "Strawberry"
            )
        )
        list_fruit.add(
            TestData(
                "Name this fruit",
                R.drawable.watermelon,
                "Raspberry",
                "Grape",
                "Watermelon",
                "Cherry",
                "Watermelon"
            )
        )
        list_fruit.add(
            TestData(
                "Name this fruit",
                R.drawable.grape,
                "Raspberry",
                "Grape",
                "Apple",
                "Cherry",
                "Grape"
            )
        )
        list_fruit.add(
            TestData(
                "Name this fruit",
                R.drawable.apple,
                "Apple",
                "Grape",
                "Pineapple",
                "Cherry",
                "Apple"
            )
        )
        list_fruit.add(
            TestData(
                "Name this fruit",
                R.drawable.cherry,
                "Watermelon",
                "Grape",
                "Pineapple",
                "Cherry",
                "Cherry"
            )
        )
        list_fruit.add(
            TestData(
                "Name this fruit",
                R.drawable.pineapple,
                "Raspberry",
                "Grape",
                "Pineapple",
                "Raspberry",
                "Pineapple"
            )
        )
        list_fruit.add(
            TestData(
                "Name this fruit",
                R.drawable.orange,
                "Apple",
                "Grape",
                "Orange",
                "Cherry",
                "Orange"
            )
        )
        list_fruit.add(
            TestData(
                "Name this fruit",
                R.drawable.fig,
                "Raspberry",
                "Grape",
                "Fig",
                "Strawberry",
                "Fig"
            )
        )
        list_fruit.add(
            TestData(
                "Name this fruit",
                R.drawable.pear,
                "Raspberry",
                "Pear",
                "Pineapple",
                "Cherry",
                "Pear"
            )
        )
        list_fruit.shuffle()
    }

    private fun shuffleListVegetable() {
        list_vegetable.add(
            TestData(
                "Name this vegetable",
                R.drawable.potato,
                "Potato",
                "Pepper",
                "Tomato",
                "Garlic",
                "Potato"
            )
        )
        list_vegetable.add(
            TestData(
                "Name this vegetable",
                R.drawable.cabbage,
                "Pepper",
                "Potato",
                "Cabbage",
                "Garlic",
                "Cabbage"
            )
        )
        list_vegetable.add(
            TestData(
                "Name this vegetable",
                R.drawable.onion,
                "Potato",
                "Onion",
                "Cabbage",
                "Garlic",
                "Onion"
            )
        )
        list_vegetable.add(
            TestData(
                "Name this vegetable",
                R.drawable.garlic,
                "Cabbage",
                "Pepper",
                "Tomato",
                "Garlic",
                "Garlic"
            )
        )
        list_vegetable.add(
            TestData(
                "Name this vegetable",
                R.drawable.cucumber,
                "Potato",
                "Pepper",
                "Cucumber",
                "Eggplant",
                "Cucumber"
            )
        )
        list_vegetable.add(
            TestData(
                "Name this vegetable",
                R.drawable.tomato,
                "Carrot",
                "Pepper",
                "Tomato",
                "Garlic",
                "Tomato"
            )
        )
        list_vegetable.add(
            TestData(
                "Name this vegetable",
                R.drawable.carrot,
                "Potato",
                "Carrot",
                "Cucumber",
                "Garlic",
                "Carrot"
            )
        )
        list_vegetable.add(
            TestData(
                "Name this vegetable",
                R.drawable.eggplant,
                "Potato",
                "Eggplant",
                "Tomato",
                "Pepper",
                "Eggplant"
            )
        )
        list_vegetable.add(
            TestData(
                "Name this vegetable",
                R.drawable.pepper,
                "Potato",
                "Pepper",
                "Tomato",
                "Garlic",
                "Pepper"
            )
        )
        list_vegetable.add(
            TestData(
                "Name this vegetable",
                R.drawable.cauiflower,
                "Potato",
                "Cauiflower",
                "Cabbage",
                "Cucumber",
                "Cauiflower"
            )
        )
        list_vegetable.shuffle()
    }
}