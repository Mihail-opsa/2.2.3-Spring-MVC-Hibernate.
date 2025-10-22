package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
@Service
@Transactional

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User save(User user) {
        return  userDao.save(user);
    }

    @Override
    public User update(User user) {
        return   userDao.update(user);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public List<User> findAll() {
        return  userDao.findAll();
    }

    @Override
    public User findById(Long id) {
        return   userDao.findById(id);
    }
}
