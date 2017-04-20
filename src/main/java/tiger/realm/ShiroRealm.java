package tiger.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import tiger.dataobject.Users;
import tiger.service.UsersService;

/**
 * Created by admin on 2017/4/19.
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UsersService usersService;
    /**
     * 登录之后的角色和权限授权管理
     * @param principalCollection
     *
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登录授权
     * @param authenticationToken
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String userName=(String)authenticationToken.getPrincipal();
        System.out.print(authenticationToken.getCredentials());
        String password=new String((char[]) authenticationToken.getCredentials());
        Users users=usersService.login(userName,password);
        if(users!=null){
            AuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(authenticationToken.getPrincipal(),authenticationToken.getCredentials(),getName());
            return authenticationInfo;
        }
        return null;
    }
}
