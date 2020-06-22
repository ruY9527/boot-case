package com.iyang.bootbasicio.bio;

import com.iyang.bootbasicio.utils.TimeFormatUtils;

import java.io.*;
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
public class BioClient {

    public void initBioClient(String host,int port){

        BufferedReader reader = null;
        BufferedWriter writer = null;
        Socket socket = null;
        String inputContent;
        int count = 0;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            socket = new Socket(host,port);
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("clientSocket started " + TimeFormatUtils.nowTimeToString());

            while ((inputContent = reader.readLine()) != null && count < 2){
                inputContent = TimeFormatUtils.nowTimeToString() + " : 第" + count + "消息," + inputContent + "\n";
                writer.write(inputContent);
                writer.flush();
                count ++;
            }
        }catch (IOException e){
            e.printStackTrace();
        } finally {

            try {
                /** 先关闭 socket的通信连接 */
                socket.close();
                reader.close();
                writer.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }

    }


    public static void main(String[] args) {

        new BioClient().initBioClient("127.0.0.1",8899);

    }

}
