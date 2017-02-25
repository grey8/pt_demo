package main.service;

import main.domain.User;
import main.exception.*;

/**
 * Created by magenta9 on 2017/2/10.
 */
public interface UserService extends BaseService<User> {
    void add(User user) throws Exception, UserCanNotBeNullException, UserNameCanNotBeNullException, UserPwdCanNotBeNullException, UserAireadyExistException, OtherThingsException;
    User findUser(User user) throws Exception;
}
