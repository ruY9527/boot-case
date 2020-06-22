package com.iyang.bootbasicio.bio;

import com.iyang.bootbasicio.utils.TimeFormatUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-19
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class BioManyServers {

    public static void main(String[] args) {

        new BioManyServers().initBioManyServer(8888);

    }

    public void initBioManyServer(int port){

        ServerSocket serverSocket = null;
        Socket socket = null;
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ServerClientThread serverClientThread = null;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(1000);
            System.out.println(TimeFormatUtils.nowTimeToString() + " : serverSocket started");
            while (true){

                try {
                    socket = serverSocket.accept();
                }catch (SocketException se) {
                    System.out.println("now time is" + TimeFormatUtils.nowTimeToString());
                    continue;
                }

                System.out.println(TimeFormatUtils.nowTimeToString() + " :id为" + socket.hashCode() + "的Clientsocket connected");
                serverClientThread = new ServerClientThread(socket);
                cachedThreadPool.execute(serverClientThread);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    public class ServerClientThread extends Thread {

        public Socket socket;

        public ServerClientThread(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            BufferedReader reader = null;
            String inputContent;
            int count = 0;

            try {
                socket.setSoTimeout(1000);
            } catch (SocketException e) {
                e.printStackTrace();
            }

            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (true){

                    try {
                        while ((inputContent = reader.readLine()) != null) {
                            System.out.println("收到ID 为" + socket.hashCode() + " " + inputContent);
                            count ++;
                        }
                    } catch (Exception e){
                        System.out.println("Not Read Data : " + TimeFormatUtils.nowTimeToString());
                        continue;
                    }
                    System.out.println("ID为 " + socket.hashCode() + "的ClientSocket " + TimeFormatUtils.nowTimeToString() + "读取结束");
                    Thread.sleep(1000);
                }
            } catch (IOException ioe){
                ioe.printStackTrace();
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {

                try {
                    reader.close();
                    socket.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

        }
    }

}
