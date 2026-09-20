//Экран выбора заметки внутри конкретного архива
fun noteMenu(
    //Архив, заметки которого просматриваются
    archive: Archive
) {
    while (true) {
        //Пункты для каждой существующей заметки
        val items = archive.notes.map { note ->
            MenuItem(note.name) {
                //При выборе заметки открываем экран просмотра текста
                noteScreen(note)
            }
        }.toMutableList()

        //Пункт создания новой заметки
        items.add(MenuItem("Создать заметку") {
            //Имя заметки не должно быть пустым
            val name = readNonEmpty("Введите имя заметки: ", "Ошибка: имя заметки не может быть пустым.")
            //Текст заметки не должен быть пустым
            val text = readNonEmpty("Введите текст заметки: ", "Ошибка: текст заметки не может быть пустым.")
            archive.notes.add(Note(name, text))
            println("Заметка \"$name\" добавлена в архив \"${archive.name}\".")
        })

        //Заголовок содержит имя архива для наглядности
        val keepGoing = showMenu("=== Заметки архива \"${archive.name}\" ===", items)
        if (!keepGoing) return
    }
}