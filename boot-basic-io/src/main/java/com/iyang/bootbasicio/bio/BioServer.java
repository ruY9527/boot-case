package com.iyang.bootbasicio.bio;

import com.iyang.bootbasicio.utils.TimeFormatUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

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
public class BioServer {

    public void initBioServer(int port){
        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedReader reader = null;
        String inputContent;
        int count = 0;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println(TimeFormatUtils.nowTimeToString() + " : serverSocket started");

            while (true){
                socket = serverSocket.accept();
                System.out.println(TimeFormatUtils.nowTimeToString() + " : id为" + socket.hashCode() + "的ClientSocket connected");
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while ((inputContent = reader.readLine()) != null){
                    System.out.println("收到id为 " + socket.hashCode() + "  " + inputContent);
                    count ++;
                }
                System.out.println("id为 " + socket.hashCode() + "的ClientSocket" + TimeFormatUtils.nowTimeToString() + "读取结果");
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        } catch (SecurityException se){
            se.printStackTrace();
        } finally {
            try {
                reader.close();
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        new BioServer().initBioServer(8899);

    }


}
