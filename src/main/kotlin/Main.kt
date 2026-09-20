
fun main() {
    //Хранилище всех архивов в памяти на время работы программы
    val archives: MutableList<Archive> = mutableListOf()
    //Запускаем главный экран выбора архива
    archiveMenu(archives)
}