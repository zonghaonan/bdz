package com.example.bdz.security;

import com.example.bdz.pojo.GwUser;
import com.example.bdz.service.GwUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhn
 * @Date 2021/9/5 15:23
 * @Version 1.0
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    GwUserService gwUserService;
    @Autowired
    LoginFailureHandler failureHandler;
    @Override
    public UserDetails loadUserByUsername(String username) {
        GwUser gwUser=gwUserService.getByUsername(username);
        if (gwUser==null){
            //System.out.println("用户名或密码错误");
            throw new UsernameNotFoundException("用户名不存在");
        }
        return new AccountUser(gwUser.getUserId(),gwUser.getUsername(),gwUser.getPassword(),getUserAuthority(gwUser.getUserId()));
    }
    //获取用户权限信息（角色权限）
    public List<GrantedAuthority> getUserAuthority(Long userId){
        //角色（ROLE_admin）、权限（gw:user:list）
        String authority=gwUserService.getUserAuthorityInfo(userId);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(authority);
    }
}
