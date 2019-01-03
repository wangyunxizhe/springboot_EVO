package com.yuan.service.impl;

import com.github.pagehelper.PageHelper;
import com.yuan.entity.SysUser;
import com.yuan.mapper.SysUserMapper;
import com.yuan.mapper.SysUserMapperCustom;
import com.yuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by wangy on 2018/11/19.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysUserMapperCustom userMapperCustom;

    //REQUIRED事务的隔离级别，一般用于增/改/删
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(SysUser user) throws Exception {
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        userMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(SysUser user) {
        //如果在属性没有填满的情况下，此方法也什么都不会填
        userMapper.updateByPrimaryKeySelective(user);
        //如果在属性没有填满的情况下，调用此方法，会自动给没填的字段填null。为避免不必要的麻烦，推荐上面的方法
//        userMapper.updateByPrimaryKey(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(String userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    //SUPPORTS事务的隔离级别，一般用于查
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public SysUser queryUserById(String userId) {
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<SysUser> queryUserList(SysUser user) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmptyOrWhitespace(user.getUsername())) {
//			criteria.andEqualTo("username", user.getUsername());
            criteria.andLike("username", "%" + user.getUsername() + "%");
        }
        if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
            criteria.andLike("nickname", "%" + user.getNickname() + "%");
        }
        List<SysUser> userList = userMapper.selectByExample(example);
        return userList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize) {
        // 开始分页
        PageHelper.startPage(page, pageSize);
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
            criteria.andLike("nickname", "%" + user.getNickname() + "%");
        }
        example.orderBy("registTime").desc();
        List<SysUser> userList = userMapper.selectByExample(example);
        return userList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public SysUser queryUserByIdCustom(String userId) {
        List<SysUser> userList = userMapperCustom.queryUserSimplyInfoById(userId);
        if (userList != null && !userList.isEmpty()) {
            return (SysUser) userList.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUserTransactional(SysUser user) {
        userMapper.insert(user);
        int a = 1 / 0;
        user.setIsDelete(1);
        userMapper.updateByPrimaryKeySelective(user);
    }

}
