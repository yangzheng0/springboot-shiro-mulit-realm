package com.hangzhi.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.hangzhi.bean.Parent;
import com.hangzhi.service.ParentService;
/**
 * @author Adam
 * @Description:  学校管理员shiro登陆Realm
 * @Title: DeviceController
 * @ProjectName wanmo
 * @date 2018/8/17 16:51
 */
public class ParentRealm extends AuthorizingRealm {
	
	@Autowired
	private ParentService parentService;
	
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }

    /**
     * @Author Adam
     * @Description  主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确
     * @Date 14:06 2018/9/28
     * @Param [token]
     * @return org.apache.shiro.authc.AuthenticationInfo
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {

        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String account = (String)token.getPrincipal();
        Object credentials = token.getCredentials();
		System.out.println("credentials="+credentials);
        //通过username从数据库中查找对象
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
		Parent parent = parentService.getParentByAccount(account);
        System.out.println("----->>parent="+parent);
        if(parent == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
        		parent,
        		parent.getPassword(),
                getName()
        );
        return authenticationInfo;
    }

}