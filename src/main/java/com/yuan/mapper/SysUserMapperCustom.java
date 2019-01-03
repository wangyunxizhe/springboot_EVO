package com.yuan.mapper;

import com.yuan.entity.SysUser;

import java.util.List;

/**
 * Created by wangy on 2018/11/19.
 * <p>
 * 自定义mapper类，对应的xml是SysUserMapperCustom.xml
 */
public interface SysUserMapperCustom {

    List<SysUser> queryUserSimplyInfoById(String id);

}
