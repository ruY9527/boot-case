package com.ruy9527;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/***
 * @author: yang_bao
 * @date: 2023/9/10
 * @desc:
 ***/


@RequestMapping(value = "/files")
@RestController
public class FileTestController {

    @GetMapping(value = "/down")
    public void downFile(HttpServletResponse response) throws Exception {

        InputStream fis = null;
        ServletOutputStream sos = null;
        try {
            String fileName = "1-2 CPU缓存架构&缓存一致性协议详解.pdf";
            //设置响应头
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            String path = "/" +  fileName;
            fis = new ClassPathResource(path).getInputStream();
            sos = response.getOutputStream();
            IOUtils.copy(fis, sos);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("模板下载失败！");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (sos != null) {
                    sos.flush();
                    sos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
