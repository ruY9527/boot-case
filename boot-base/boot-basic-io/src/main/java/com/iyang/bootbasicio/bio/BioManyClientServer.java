package com.iyang.bootbasicio.bio;

import com.iyang.bootbasicio.utils.TimeFormatUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
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
public class BioManyClientServer {


    private void initBioManyServer(int port){

        ServerSocket serverSocket = null;
        Socket socket = null;
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ClientSocketThread clientSocketThread = null;

        try {
            serverSocket = new ServerSocket();
            serverSocket.setSoTimeout(1000);
            System.out.println(TimeFormatUtils.nowTimeToString() + ": serverSocket started");
            while (true){
                try {
                    socket = serverSocket.accept();
                }catch (SocketTimeoutException ste){
                    ste.printStackTrace();
                    System.out.println("now time is : " + TimeFormatUtils.nowTimeToString());
                }

                System.out.println(TimeFormatUtils.nowTimeToString() + ": id为" + socket.hashCode() + "的Clientsocket connected");
                clientSocketThread = new ClientSocketThread(socket);
                cachedThreadPool.execute(clientSocketThread);
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }


    class ClientSocketThread extends Thread {

        private Socket socket;

        public ClientSocketThread(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {

            BufferedReader  reader = null;
            String inputContent ;
            int count = 0 ;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while ((inputContent = reader.readLine()) != null){
                    System.out.println("收到id为 " + socket.hashCode() + "  " + inputContent);
                    count ++;
                }

                System.out.println("id为" + socket.hashCode() + "的clientCode" + TimeFormatUtils.nowTimeToString() + "读取结束");
            } catch (IOException ioe){
                ioe.printStackTrace();
            } finally {
                try {
                    reader.close();
                    socket.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        new BioManyClientServer().initBioManyServer(8889);

    }
}
