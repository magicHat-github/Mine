package com.mine.six.server;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaoyouming
 */
public class Server {
    /**
     * 服务器刷新次数
     */
    private int tickrate;
    /**
     * 用于保证输入相同的会话代码来实现进入同一个游戏
     */
    private ConcurrentHashMap<Integer,GameStatus> SessionMap;
    private int port;
    private String ip;
    private DatagramSocket serverSocket=null;
    private DatagramPacket datagramPacket=null;
    byte[] buffer=new byte[1024];

    public void StartServer(int port){
        try {
            serverSocket=new DatagramSocket(port);
            datagramPacket=new DatagramPacket(buffer,buffer.length);
            //循环接受数据包
            while (true){
                ByteArrayInputStream bis=new ByteArrayInputStream(datagramPacket.getData());
                ObjectInputStream ois=new ObjectInputStream(bis);
                Object bufferObject=ois.readObject();
                if (bufferObject instanceof Status){
                    SessionMap.put(((Status) bufferObject).getSessionId(),((Status) bufferObject).getGameStatus());
                }else {
                    System.out.println(bufferObject.toString());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
