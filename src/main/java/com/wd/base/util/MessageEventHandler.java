package com.wd.base.util;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.wd.base.entity.MessageDto;
import io.socket.client.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageEventHandler {

    private final SocketIOServer server;

    private static final Logger logger = LoggerFactory.getLogger(MessageEventHandler.class);

    @Autowired
    public MessageEventHandler(SocketIOServer server) {
        this.server = server;
    }

    //添加connect事件，当客户端发起连接时调用
    @OnConnect
    public void onConnect(SocketIOClient client) {
        if (client != null) {
            String user = client.getHandshakeData().getSingleUrlParam("user");
            String message = client.getHandshakeData().getSingleUrlParam("message");
            String applicationId = "chat1";
            logger.info("连接成功, applicationId=" + applicationId + ", user=" + user +
                    ", sessionId=" + client.getSessionId().toString() );
            client.joinRoom(applicationId);
            //
            MessageDto param = new MessageDto();
            param.setName(user);
            param.setMessage(message);
        } else {
            logger.error("客户端为空");
        }
    }

    //添加@OnDisconnect事件，客户端断开连接时调用，刷新客户端信息
    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        String user = client.getHandshakeData().getSingleUrlParam("user");
        logger.info("客户端断开连接, user=" + user + ", sessionId=" + client.getSessionId().toString());
        MessageDto param = new MessageDto();
        param.setName(user);
        client.disconnect();
    }

    // 消息接收入口
    @OnEvent(value = Socket.EVENT_MESSAGE)
    public void onEvent(SocketIOClient client, AckRequest ackRequest, Object data) {
        logger.info("接收到客户端消息");
        server.getBroadcastOperations().sendEvent("message", data);
        logger.info("广播消息成功");
//        if (ackRequest.isAckRequested()) {
//            // send ack response with data to client
//            ackRequest.sendAckData("服务器回答Socket.EVENT_MESSAGE", "好的");
//        }
    }

    // 广播消息接收入口
    @OnEvent(value = "broadcast")
    public void onBroadcast(SocketIOClient client, AckRequest ackRequest, ChatObject data) {
        logger.info("接收到广播消息");
        // 房间广播消息
        String room = client.getHandshakeData().getSingleUrlParam("char1");
        server.getRoomOperations(room).sendEvent("broadcast", data);
    }

    /**
     * 报告地址接口
     * @param client 客户端
     * @param ackRequest 回执消息
     * @param param 报告地址参数
     */
    @OnEvent(value = "doReport")
    public void onDoReport(SocketIOClient client, AckRequest ackRequest, ChatObject param) {
        logger.info("报告地址接口 start....");
        ackRequest.sendAckData(param);
    }



}
