package tiger.service;


import tiger.dataobject.Users;

/**
 * Created by admin on 2017/4/11.
 */
public interface UsersService {

    /**
     * 通过userName 获取users
     * @param userName
     * */
    Users login(String userName,String password);


}
