package com.evtimov.landlordapp.backend.repositories;

import com.evtimov.landlordapp.backend.models.User;
import com.evtimov.landlordapp.backend.repositories.base.UserRepository;
import com.evtimov.landlordapp.backend.utils.Constants;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final
    SessionFactory sessionFactory;

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public User registerUser(User entity) {

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
        return entity;
    }


    @Override
    public List<User> findAllTenants() {
        List<User> users;

        users = getAll().stream().filter(u -> !u.getIsLandlord()).collect(Collectors.toList());

        return users;
    }

    @Override
    public List<User> findAllLandlords() {
        List<User> users;

        users = getAll().stream().filter(User::getIsLandlord).collect(Collectors.toList());

        return users;
    }


    @Override
    public User updateUserOnlineStatus(int userId, User model) {

        User userToChange;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            userToChange = session.get(User.class, userId);

            userToChange.setIsOnline(model.getIsOnline());

            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
        return userToChange;
    }

    @Override
    public List<User> getUserByUsername(String pattern) {
        List<User> users;
        String statement = "from User where username = :pattern ";

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter(Constants.PATTERN, pattern);
            users = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public List<User> getUserHashAndSaltByUsername(String username) {
        List<User> users;
        String statement = "from User where username = :pattern ";

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter(Constants.PATTERN, username);
            users = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return users;
    }


    @Override
    public List<User> checkUsername(String pattern) {
        List<User> users;
        String statement = "from User where username = :pattern ";

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter(Constants.PATTERN, pattern);
            users = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public List<User> checkEmail(String pattern) {
        List<User> users;
        String statement = "from User where email = :pattern ";

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Query query = session.createQuery(statement);
            query.setParameter(Constants.PATTERN, pattern);
            users = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public User getUserById(int userId) {
        User user;

        try(
                Session session = sessionFactory.openSession();
        ){
            session.beginTransaction();
            user = session.get(User.class, userId);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return user;
    }

    private List<User> getAll() {
        List<User> users;

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            users = session.createQuery("from User").list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
        return users;
    }

}