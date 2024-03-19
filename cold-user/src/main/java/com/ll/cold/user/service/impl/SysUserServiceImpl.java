package com.ll.cold.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ll.cold.common.user.dao.SysUserDao;
import com.ll.cold.common.user.entity.SysUserEntity;
import com.ll.cold.user.service.SysUserService;
import org.springframework.stereotype.Service;


/**
 * 系统用户
 *
 *
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

	@Override
	public SysUserEntity queryByUserName(String username) {
		return baseMapper.queryByUserName(username);
	}

}