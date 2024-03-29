package com.wd.base.util;

import com.corundumstudio.socketio.AuthorizationListener;
import com.corundumstudio.socketio.HandshakeData;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NettySocketConfig {

    @Bean
    public SocketIOServer socketIOServer() {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        // 设置主机名
        config.setHostname("localhost");
        //设置端口号
        config.setPort(9092);

        // 协议升级超时时间（毫秒），默认10000。HTTP握手升级为ws协议超时时间
        config.setUpgradeTimeout(10000);
        // Ping消息间隔（毫秒），默认25000。客户端向服务器发送一条心跳消息间隔
        config.setPingInterval(60000);
        // Ping消息超时时间（毫秒），默认60000，这个时间间隔内没有接收到心跳消息就会发送超时事件
        config.setPingTimeout(180000);
        // 这个版本0.9.0不能处理好namespace和query参数的问题。所以为了做认证必须使用全局默认命名空间
        config.setAuthorizationListener(new AuthorizationListener() {
            @Override
            public boolean isAuthorized(HandshakeData data) {
                // 可以使用如下代码获取用户密码信息
//                String username = data.getSingleUrlParam("username");
//                String password = data.getSingleUrlParam("password");
//                logger.info("连接参数：username=" + username + ",password=" + password);
//                ManagerInfo managerInfo = managerInfoService.findByUsername(username);
//                // MD5盐
//                String salt = managerInfo.getSalt();
//                String encodedPassword = ShiroKit.md5(password, username + salt);
//                // 如果认证不通过会返回一个Socket.EVENT_CONNECT_ERROR事件
//                return encodedPassword.equals(managerInfo.getPassword());
                return true;
            }
        });

        final SocketIOServer server = new SocketIOServer(config);

        return server;
    }

    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketIOServer) {
        return new SpringAnnotationScanner(socketIOServer);
    }
}
