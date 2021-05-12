package com.gongsunfusu.service;

import com.gongsunfusu.dao.userMapper;
import com.gongsunfusu.pojo.user;
import com.gongsunfusu.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

@Service
public class IndexService {
    @Autowired
    private userMapper userMapper;

    /**
     * 查询所有用户
     * @return
     */
    public List<user> selectUserList(){
        return userMapper.selectUserList();
    }

    /**
     * 登录用户
     * @param user
     * @return
     */
    public user loginUser(user user){
        if (user.getName() != null){
            user oldUser = userMapper.selectUser(user);
            //判断密码是否正确
            String newPassword = null;
            try {
                newPassword = MD5Util.passwordToMD5(user.getPassword(),oldUser.getSalt());
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if(oldUser.getPassword().equals(newPassword)){
                //如果正确返回用户信息
                return oldUser;
            }
            return null;
        }
        return null;
    }

    /**
     * 注册
     * @return
     */
    public Boolean registerUser(user user){
        user oldUser = userMapper.selectUser(user);
        if (oldUser != null){
            return false;
        }
        user.setSalt(UUID.randomUUID().toString());
        try {
            user.setPassword(MD5Util.passwordToMD5(user.getPassword(),user.getSalt()));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
        userMapper.insertUser(user);
        return true;
    }
}
