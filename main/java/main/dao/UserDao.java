package main.dao;

import main.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

    /**
     * Created by magenta9 on 2017/2/10.
     */
    @Component
    public interface UserDao extends Dao<User> {
        int add(User user);
        int del(User user);
        int update(User user);
        User findOneById(Serializable Id);
        List<User> findAll();
        void updateLoginSession(@Param("sessionId") String sessionId, @Param("loginId") String loginId);
        void addSessionId(String id);
    }
