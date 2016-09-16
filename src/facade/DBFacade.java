package facade;

import entity.Employee;
import entity.PHDStudent;
import entity.Person;
import entity.Student;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DBFacade {

    EntityManagerFactory emf;

    public DBFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public <T> List<T> createEntities(T... entities) {
        EntityManager em = getEntityManager();
        List<T> updatedEntities = new ArrayList();

        try {
            em.getTransaction().begin();
            for (T entity : entities) {
                em.persist(entity);
                em.flush();
                updatedEntities.add(entity);
            }

            return updatedEntities;
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }

    public <T> List<T> updateEntities(T... entities) {
        EntityManager em = getEntityManager();
        List<T> updatedEntities = new ArrayList();

        try {
            em.getTransaction().begin();
            for (T entity : entities) {
                em.merge(entity);
                em.flush();
                updatedEntities.add(entity);
            }

            return updatedEntities;
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }

    public <T> void deleteEntities(T... entities) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            for (T entity : entities) {
                em.remove(entity);
                em.flush();
            }

        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }

    public List<Student> findStudents(int... ids) {
        EntityManager em = getEntityManager();
        List<Student> students = new ArrayList();

        try {
            for (int id : ids) {
                students.add(em.find(Student.class, id));
            }

            return students;
        } finally {
            em.close();
        }
    }
    
    public List<Employee> findEmployees(int... ids) {
        EntityManager em = getEntityManager();
        List<Employee> employees = new ArrayList();

        try {
            for (int id : ids) {
                employees.add(em.find(Employee.class, id));
            }

            return employees;
        } finally {
            em.close();
        }
    }
    
    public List<PHDStudent> findPHDStudents(int... ids) {
        EntityManager em = getEntityManager();
        List<PHDStudent> phdStudents = new ArrayList();

        try {
            for (int id : ids) {
                phdStudents.add(em.find(PHDStudent.class, id));
            }

            return phdStudents;
        } finally {
            em.close();
        }
    }
    
    public List<Person> findPersons(int... ids) {
        EntityManager em = getEntityManager();
        List<Person> persons = new ArrayList();

        try {
            for (int id : ids) {
                persons.add(em.find(Person.class, id));
            }

            return persons;
        } finally {
            em.close();
        }
    }

}
