package com.mine.six.client;

import com.mine.six.server.GameStatus;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


/**
 * 每次发送包的时候判断与接收的包是否一致，一致说明没改变游戏状态不发送数据
 * @author xiaoyouming
 */
public class TestClient {

    private GameStatus gameStatus;
    private int sessionid;
    private DatagramPacket datagramPacket;
    private DatagramSocket datagramSocket;

    public TestClient(){

    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public int getSessionid() {
        return sessionid;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setSessionid(int sessionid) {
        this.sessionid = sessionid;
    }
    public void Receive(int port, InetAddress ip){
        try {
            datagramSocket=new DatagramSocket(port,ip);
           // datagramPacket=new DatagramPacket(datagramSocket);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
