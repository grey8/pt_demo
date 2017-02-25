package main.service;

import main.exception.*;

/**
 * Created by magenta9 on 2017/2/10.
 */
public interface BaseService<T> {
    void add(T t) throws Exception, UserCanNotBeNullException, UserNameCanNotBeNullException, UserPwdCanNotBeNullException, OtherThingsException, UserAireadyExistException;
}
