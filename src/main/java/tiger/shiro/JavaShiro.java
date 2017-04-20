package tiger.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

/**
 * Created by admin on 2017/4/17.
 */
public class JavaShiro {

//    public static void main(String[] args){
//        // 通过配置文件进行认证
////        iniAuthority();
//
//        // 通过数据库中的用户名和密码进行验证
//        jdbcAuthority();
//
//        // 验证用户是否拥有某个角色
////        roleAuthority();
//
////        rolePermission();
//    }



    /**
     * 通过配置文件设置角色权限
     *
     * */
    private static void rolePermission(){
        IniSecurityManagerFactory factory=getFactory("ini/shiro_permission.ini");
        SecurityManager manager=factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
        Subject currentUser =SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("liuhailong","liuhailong");
        try {
            currentUser.login(token);
            System.out.println("认证成功。");
        }catch (Exception e){
            System.out.println("认证失败。");
        }
        System.out.println(currentUser.isPermitted("add"));
        System.out.println(currentUser.isPermitted("create"));
        System.out.println(currentUser.isPermitted("role4"));

    }


    /**
     * 通过配置文件设置角色
     *
     * */
    private static void roleAuthority(){
        // 初始化SecurityManager
        IniSecurityManagerFactory factory=getFactory("ini/shiro_roles.ini");
        SecurityManager manager=factory.getInstance();
        SecurityUtils.setSecurityManager(manager);

        Subject currentUser =SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("liuhailong","liuhailong");
        try {
            currentUser.login(token);
            System.out.println("认证成功。");
        }catch (Exception e){
            System.out.println("认证失败。");
        }
        System.out.println(currentUser.hasRole("role1"));
        System.out.println(currentUser.hasRole("role3"));
        System.out.println(currentUser.hasRole("role4"));
        boolean[] result=currentUser.hasRoles(Arrays.asList("role","role1","role2"));
        for(boolean b:result) {
            System.out.print(b+"\t");
        }
    }


    /**
     * jdbc 认证方式
     * 当使用该方式时注意表明一定要是users，并且配置datasource,
     * */
    private static void jdbcAuthority(){
        IniSecurityManagerFactory factory=getFactory("ini/jdbc_realm.ini");
        SecurityManager manager=factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
        Subject currentUser =SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("liuhailong","liuhailong");
        try {
            currentUser.login(token);
            System.out.println("认证成功。");
        }catch (Exception e){
            System.out.println("认证失败。");
        }
    }



    /**
     * ini 文件认证方式
     * 注意配置ini文件的时候首先要配置 [users]
     * liuhailong=liuhailong    是用户名和密码的键值对
     * */
    private static void iniAuthority(){
        IniSecurityManagerFactory factory=getFactory("ini/shiro.ini");
        SecurityManager manager=factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
        Subject currentUser =SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("liuhailong","liuhailong");
        try {
            currentUser.login(token);
            System.out.println("认证成功。");
        }catch (Exception e){
            System.out.println("认证失败。");
        }
    }

    /**
     * 通过文件名获取IniSecurityManagerFactory
     * */
    private static  IniSecurityManagerFactory getFactory(String fileName){
        IniSecurityManagerFactory factory=new IniSecurityManagerFactory("classpath:"+fileName);
        return factory;
    }

}
