//package cn.tx.service.realm;
//
//import cn.tx.mapper.UserMapper;
//import cn.tx.pojo.User;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authc.credential.CredentialsMatcher;
//import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * 用户认证的realm
// */
//public class ShiroUserRealm extends AuthorizingRealm {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    /**
//     * 此方法负责获取并封装授权信息
//     * @param principalCollection
//     * @return
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//
//        return null;
//    }
//
//    /**
//     * 此方法负责获取并封装认证信息
//     * @param authenticationToken
//     * @return
//     * @throws AuthenticationException
//       @Override
//     */
//    protected AuthenticationInfo doGetAuthenticationInfo(
//            AuthenticationToken authenticationToken) throws AuthenticationException {
//        //1,获取用户提交的认证用户信息
//        UsernamePasswordToken upToken= (UsernamePasswordToken) authenticationToken;
//        String username = upToken.getUsername();
//        //2,基于用户名查询从数据库插用户信息
//        User User = userMapper.findUserByUsername(username);
//        //3,判断用户是否存在
//        if(User==null)throw new UnknownAccountException();//账号不存在
//        //4,判断用户是否被禁用
//        //if(User.getValid()==0)throw new LockedAccountException();
//        //5,封装认证信息并返回
//        //ByteSource credentialsSalt=
//        //        ByteSource.Util.bytes(sysUser.getSalt());
//        SimpleAuthenticationInfo info=
//                new SimpleAuthenticationInfo(
//                        User,//传入的用户身份
//                        User.getPassword(),
//                        //credentialsSalt,
//                        getName()
//                        );
//        return info;
//    }
//    //对密码进行加密
//    @Override
//    public CredentialsMatcher getCredentialsMatcher() {
//        HashedCredentialsMatcher matcher=new HashedCredentialsMatcher();
//        matcher.setHashAlgorithmName("MD5");
//        matcher.setHashIterations(1);
//        return matcher;
//    }
//}
