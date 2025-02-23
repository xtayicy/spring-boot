package harry.shiro.jwt.realm;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import harry.shiro.jwt.authentication.JWTToken;
import harry.shiro.jwt.entity.User;
import harry.shiro.jwt.util.JWTUtil;
import harry.shiro.jwt.util.SystemUtil;

public class ShiroRealm extends AuthorizingRealm{
	@Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token) {
		String username = JWTUtil.getUsername(token.toString());
        User user = SystemUtil.getUser(username);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 获取用户角色集（模拟值，实际从数据库获取）
        simpleAuthorizationInfo.setRoles(user.getRole());

        // 获取用户权限集（模拟值，实际从数据库获取）
        simpleAuthorizationInfo.setStringPermissions(user.getPermission());
        return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		// 这里的 token是从 JWTFilter 的 executeLogin 方法传递过来的，已经经过了解密
        String token = (String) authenticationToken.getCredentials();

        String username = JWTUtil.getUsername(token);

        if (StringUtils.isBlank(username))
            throw new AuthenticationException("token校验不通过");

        // 通过用户名查询用户信息
        User user = SystemUtil.getUser(username);

        if (user == null)
            throw new AuthenticationException("用户名或密码错误");
        if (!JWTUtil.verify(token, username, user.getPassword()))
            throw new AuthenticationException("token校验不通过");
        return new SimpleAuthenticationInfo(token, token, "shiro_realm");
	}

}
