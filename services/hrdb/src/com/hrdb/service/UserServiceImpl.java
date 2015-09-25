/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/

package com.hrdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.*;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.hrdb.*;


/**
 * ServiceImpl object for domain model class User.
 * @see com.hrdb.User
 */
@Service("hrdb.UserService")
public class UserServiceImpl implements UserService {


    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    @Qualifier("hrdb.UserDao")
    private WMGenericDao<User, Integer> wmGenericDao;
    public void setWMGenericDao(WMGenericDao<User, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "hrdbTransactionManager")
     public Page<User> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "hrdbTransactionManager")
    @Override
    public User create(User user) {
        LOGGER.debug("Creating a new user with information: {}" , user);
        return this.wmGenericDao.create(user);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "hrdbTransactionManager")
    @Override
    public User delete(Integer userId) throws EntityNotFoundException {
        LOGGER.debug("Deleting user with id: {}" , userId);
        User deleted = this.wmGenericDao.findById(userId);
        if (deleted == null) {
            LOGGER.debug("No user found with id: {}" , userId);
            throw new EntityNotFoundException(String.valueOf(userId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "hrdbTransactionManager")
    @Override
    public Page<User> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all users");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "hrdbTransactionManager")
    @Override
    public Page<User> findAll(Pageable pageable) {
        LOGGER.debug("Finding all users");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "hrdbTransactionManager")
    @Override
    public User findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding user by id: {}" , id);
        User user=this.wmGenericDao.findById(id);
        if(user==null){
            LOGGER.debug("No user found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return user;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "hrdbTransactionManager")
    @Override
    public User update(User updated) throws EntityNotFoundException {
        LOGGER.debug("Updating user with information: {}" , updated);
        this.wmGenericDao.update(updated);
        return this.wmGenericDao.findById((Integer)updated.getUserid());
    }

    @Transactional(readOnly = true, value = "hrdbTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


