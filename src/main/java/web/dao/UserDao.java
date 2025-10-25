package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    User save(User user);
    User update(User user);
    void delete(Long id);

    List<User> findAll(); //Получение всех пользователей из базы данных
    User findById(Long id);//оиск пользователя по уникальному идентификатору

}
