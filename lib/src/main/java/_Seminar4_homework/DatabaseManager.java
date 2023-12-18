package _Seminar4_homework;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DatabaseManager {
	private SessionFactory sessionFactory;

	public DatabaseManager() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public void insertCourse(Courses courses) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			session.save(courses);

			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public Courses getCourse(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Courses courses = null;

		try {
			transaction = session.beginTransaction();

			courses = session.get(Courses.class, id);

			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return courses;
	}

	public void printAllData() {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			List<Courses> courses = session.createQuery("FROM Courses", Courses.class).list();

			for (Courses course : courses) {
				System.out.println(course);
			}

			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void updateCourse(int courseId, String newName, int duration) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			Courses course = session.get(Courses.class, courseId);

			if (course != null) {
				course.setTitle(newName);
				course.setDuration(duration);
				session.update(course);
				System.out.println("Данные курса с ID " + courseId + " успешно обновлены.");
			} else {
				System.out.println("Курс с ID " + courseId + " не найден.");
			}

			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void printCourseById(int courseId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			Courses course = session.get(Courses.class, courseId);

			if (course != null) {
				System.out.println(course);
			} else {
				System.out.println("Курс с ID " + courseId + " не найден.");
			}

			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void deleteCourse(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			Courses course = session.get(Courses.class, id);

			if (course != null) {
				session.delete(course);
				System.out.println("Курс удален: " + course.getTitle());
			} else {
				System.out.println("Курс с ID " + id + " не найден.");
			}

			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
