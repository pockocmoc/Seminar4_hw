package _Seminar4_homework;

public class Main {

	public static void main(String[] args) {
		DatabaseManager databaseManager = new DatabaseManager();

//	    // Вставка данных
		Courses courses1 = new Courses("Политология", 90);
		databaseManager.insertCourse(courses1);

		Courses courses2 = new Courses("Программирование", 90);
		databaseManager.insertCourse(courses2);

		Courses courses3 = new Courses("Сопромат", 180);
		databaseManager.insertCourse(courses3);

		Courses courses4 = new Courses("Экономика", 45);
		databaseManager.insertCourse(courses4);

//		// Обновление данных
//		databaseManager.updateCourse(3, "Высшая математика", 45);
		// Удаление данных
//		databaseManager.deleteCourse(3);

//	     Чтение данных
//		databaseManager.printCourseById(2);
		databaseManager.printAllData();
	}

}
