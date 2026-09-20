//Модель заметки: имя и текст
data class Note(
    //Название заметки
    val name: String,
    //Текст (содержимое) заметки
    val text: String
)

//Модель архива: имя и список заметок внутри
data class Archive(
    //Название архива
    val name: String,
    //Изменяемый список заметок, чтобы можно было добавлять новые
    val notes: MutableList<Note> = mutableListOf()
)