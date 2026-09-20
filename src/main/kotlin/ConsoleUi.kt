//Универсальный пункт меню: описание для пользователя и действие при выборе
class MenuItem(
    //Текст пункта, который видит пользователь
    val title: String,
    //Действие, выполняемое при выборе этого пункта
    val action: () -> Unit
)

//Универсальная функция показа меню.
//Возвращает false, если пользователь выбрал выход, и true при любом другом выборе.
//Позволяет одному и тому же коду обслуживать все экраны приложения.
fun showMenu(
    //Заголовок меню, выводимый перед списком пунктов
    title: String,
    //Список пунктов меню
    items: List<MenuItem>
): Boolean {
    //Выводим заголовок и пункты меню с нумерацией
    println()
    println(title)
    items.forEachIndexed { index, item ->
        println("${index + 1}. ${item.title}")
    }
    println("0. Назад/Выход")

    //Запрашиваем ввод до тех пор, пока пользователь не введёт корректный номер
    while (true) {
        print("Выберите пункт: ")
        //Считываем строку; если поток закрыт — выходим из программы
        val input = readlnOrNull() ?: return false
        //Пытаемся преобразовать ввод в число
        val choice = input.trim().toIntOrNull()
        //Обрабатываем некорректный ввод
        if (choice == null || choice < 0 || choice > items.size) {
            println("Ошибка: введите число от 0 до ${items.size}.")
            continue
        }
        //Выбор 0 — сигнал выйти с текущего экрана
        if (choice == 0) return false
        //Вызываем действие выбранного пункта и продолжаем цикл экрана
        items[choice - 1].action()
        return true
    }
}

//Универсальное чтение непустой строки.
//Переиспользуется при создании архива, заметки и текста заметки.
fun readNonEmpty(
    //Приглашение к вводу
    prompt: String,
    //Сообщение об ошибке при пустом вводе
    errorMessage: String
): String {
    while (true) {
        print(prompt)
        val value = readlnOrNull()?.trim() ?: ""
        //Не позволяем создать объект с пустым именем/текстом
        if (value.isEmpty()) {
            println(errorMessage)
            continue
        }
        return value
    }
}