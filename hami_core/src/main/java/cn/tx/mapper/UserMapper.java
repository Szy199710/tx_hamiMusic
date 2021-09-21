package cn.tx.mapper;

import cn.tx.pojo.User;

public interface UserMapper {

    User findUserByUsername(String username);
}
