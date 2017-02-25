package main.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by magenta9 on 2017/2/10.
 * @param <T> 泛型用于解耦，避免重复写代码
 */
public interface Dao<T extends Serializable> {
    /**
     * add a object
     * @param t object would be added
     * @return effect rows
     */
    int add(T t);

    /**
     * 删除数据，实际中不做物理删除，只是加字段进行控制
     * @param t 删除对象
     * @return 影响行数
     */
    int del(T t);

    /**
     * 更新对象
     * @param t 更新的对象
     * @return 影响行数
     */
    int update(T t);

    /**
     * 通过ID查询对象
     * @param Id 待查询ID
     * @return 对应对象
     */
    T findOneById(Serializable Id);

    /**
     * 查询的对象集合
     * @return 对象集合
     */
    List<T> findAll();
}
