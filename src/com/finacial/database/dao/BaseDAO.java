package com.finacial.database.dao;

import org.hibernate.criterion.Order;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * @author joseph
 * @since 11/15/12  3:51 PM
 */
public interface BaseDAO<E, PK extends Serializable> {
    /**
     * 按主键查找实体
     *
     * @param id 主键值
     * @return E
     */
    E find(PK id);
    /**
     * 从缓存中延迟加载，效率较高
     * @param id 主键
     * @return E
     */
    E load(PK id);

    /**
     * 按照某一列属性查找
     * @param key 列名 ,为实体中的属性名字，比如UserInfo中的cUserInfoId
     * @param value 对应值
     */
    List<E> findByProperty(String key, Object value);

    /**
     * 按照多个属性值来查找
     * @param properties
     * @return
     */
    List<E> findByProperties(Map<String, Object> properties);

    /**
     * 按照 example里面给定的属性值查找，查找条件为“等于example中的属性值”
     * @param example
     */
    List<E> findByExample(E example);
    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    Pager<E> findPageByMap(int pageNo, int pageSize, Map map);
    Pager<E> findPageByExample(int pageNo, int pageSize, E example);  
    List<E> findAll();

    /**
     * 保存记录
     * @param entity
     * @return 生成的主键值
     */
    PK save(E entity);

    /**
     * 批量保存
     * @param entities
     * @return 所有的主键值
     */
    List<PK> save(List<E> entities);

    void saveOrUpdate(E entity);

    void saveOrUpdate(List<E> entities);

    /**
     * 删除记录，entity中必须含有主键值
     * @param entity
     */
    void delete(E entity);

    /**
     * 批量删除，entities中的每一个实体都必须含有主键值
     * @param entities
     */
    void delete(List<E> entities);

    /**
     * 按照一个属性值來刪除
     * @param key ,为实体中的属性名字，比如UserInfo中的cUserInfoId
     * @param value
     * @see com.chance.database.models.UserInfo
     */
    void deleteByProperty(String key,Object value);

    /**
     * 按照多个属性值来删除
     * @param properties 为map
     */
    void deleteByProperties(Map<String,Object> properties) ;

    /**
     * 按照entity中的主键值来更新其他属性
     * @param entity
     */
    void update(E entity);

    /**
     * 按照entities中的每个实体的主键值来更新其他属性
     * @param entities
     */
    void update(List<E> entities);


    void updateProperties(Map<String,Object> properties, Map<String,Object> whereClause);

    /**
     * 运行更新或删除语句
     * @param queryString  Hibernate Sql,用类名代替表名。<br/>
     *                     例如删除用户id为1的語句 "<b><em>delete from  User where cUserId =1<em/><b/>"
     * @return 更新或删除的记录数量
     * @see com.chance.database.models.User
     */
    int executeUpdate(String queryString);

    /**
     * 执行查询语句
     * @param queryString  Hibernate SQL <br/>
     *                     例如查詢用户id为1的語句 "<b><em> from  User where cUserId =1<em/><b/>"
     * @return 查询结果
     * @see com.chance.database.models.User
     */

    List<E> executeFind(String queryString);
    
    void setOrder(Order order);
}
