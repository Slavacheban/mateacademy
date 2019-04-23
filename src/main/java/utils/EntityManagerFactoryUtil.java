package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryUtil {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SERVLET");
}
