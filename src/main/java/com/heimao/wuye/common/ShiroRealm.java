package com.heimao.wuye.common;



import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.heimao.wuye.entity.Resources;
import com.heimao.wuye.entity.User;
import com.heimao.wuye.entity.Users;
import com.heimao.wuye.service.ResourcesService;
import com.heimao.wuye.service.UserService;
import com.heimao.wuye.service.UsersService;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

public class ShiroRealm extends AuthorizingRealm{

//    @Autowired
//    private UsersService userService;
//
//
//
//    //验证授权信息
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        Users user = (Users) principalCollection.getPrimaryPrincipal();
//        String roles = user.getDescription();
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        if(null != roles && roles.length() > 0) {
//            simpleAuthorizationInfo.addRoles(Arrays.asList(roles.split(",")));
//        }
//
//        return simpleAuthorizationInfo;
//    }
//
//
//
//    //验证用户登录信息
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
//        String name = usernamePasswordToken.getUsername();
//        String password = usernamePasswordToken.getPassword() != null ? new String(usernamePasswordToken.getPassword()) : null;
//        Users user = userService.isExist(name, password);
//
//        if (null == user) {
//            return null;
//        }
//
//        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
//    }
	
	    @Resource
	    private UserService userService;

	    @Resource
	    private ResourcesService resourcesService;

	    //授权
	    @Override
	    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
	        User user= (User) SecurityUtils.getSubject().getPrincipal();//User{id=1, username='admin', password='3ef7164d1f6167cb9f2658c07d3c2f0a', enable=1}
	        Map<String,Object> map = new HashMap<String,Object>();
	        map.put("userid",user.getId());
	        List<Resources> resourcesList = resourcesService.loadUserResources(map);
	        // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
	        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
	        for(Resources resources: resourcesList){
	            info.addStringPermission(resources.getResurl());
	        }
	        return info;
	    }

	    //认证
	    @Override
	    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
	        //获取用户的输入的账号.
	        String username = (String)token.getPrincipal();
	        User user = userService.selectByUsername(username);
	        if(user==null) throw new UnknownAccountException();
	        if (0==user.getEnable()) {
	            throw new LockedAccountException(); // 帐号锁定
	        }
	        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
	                user, //用户
	                user.getPassword(), //密码
	                ByteSource.Util.bytes(username),
	                getName()  //realm name
	        );
	        // 当验证都通过后，把用户信息放在session里
	        Session session = SecurityUtils.getSubject().getSession();
	        session.setAttribute("userSession", user);
	        session.setAttribute("userSessionId", user.getId());
	        return authenticationInfo;
	    }
}
