package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;

import web.model.User;

import java.util.List;

@Service


public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao; // убрал жесткую привязку к классу

    @Transactional
    @Override
    public User save(User user) {
        User newUser = new User(user.getName(), user.getLastName(), user.getAge());
        return userDao.save(newUser);
    }
    @Transactional
    @Override
    public User update(User user) {
        User newUser = userDao.findById(user.getId());
        newUser.setLastName(user.getLastName());
        newUser.setAge(user.getAge());
        newUser.setName(user.getName());

        return userDao.update(newUser);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
    @Transactional(readOnly = true)// только чтение то есть доступ всех по этому и  @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Transactional(readOnly = true)// только чтение поиск по id  @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }


    @Transactional
    @Override
    public void updateUser(Long id, String name, String lastName, Byte age) {
        User user = userDao.findById(id);
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        userDao.update(user);

    }


    @Transactional
    @Override
    public void createUser(String name, String lastName, Byte age) {
    User user = new User(name, lastName, age);
    userDao.save(user);
    }
}
