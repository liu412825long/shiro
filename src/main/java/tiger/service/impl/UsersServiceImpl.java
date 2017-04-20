package tiger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tiger.dataobject.Users;
import tiger.mapper.UsersMapper;
import tiger.service.UsersService;


/**
 * Created by admin on 2017/4/11.
 */
@Service
public class UsersServiceImpl implements UsersService {


    @Autowired
    private UsersMapper usersMapper;


    @Override
    public Users login(String userName,String password) {
        if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(password)){
            return null;
        }
        Users users=new Users();
        users.setUsername(userName);
        users.setPassword(password);
        return usersMapper.selectByUser(users);
    }
}
