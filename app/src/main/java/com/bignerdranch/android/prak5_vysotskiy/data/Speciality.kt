package com.bignerdranch.android.prak5_vysotskiy.data

data class Specialty(
    val id: Int,
    val title: String,
    val description: String,
    val code: String
)

object SpecialtyRepository {
    val specialties = listOf(
        Specialty(
            id = 1,
            title = "Программирование",
            description = "Разработка программного обеспечения и мобильных приложений",
            code = "09.02.07"
        ),
        Specialty(
            id = 2,
            title = "Сетевое администрирование",
            description = "Обеспечение работы сетей",
            code = "09.02.06"
        ),
        Specialty(
            id = 3,
            title = "Тестирование и качество",
            description = "Тестирование приложений, сайтов, программ на ошибки, слежка за удобством интерфейса, контроль соответствия продукта требованиям",
            code = "10.02.05"
        )
    )

    fun getSpecialtyById(id: Int): Specialty? {
        return specialties.find { it.id == id }
    }
}