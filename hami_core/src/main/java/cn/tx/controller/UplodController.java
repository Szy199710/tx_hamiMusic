package cn.tx.controller;

import cn.tx.util.PropUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import com.sun.jersey.api.client.Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
@PropertySource(value ="classpath:/sys.properties",encoding = "UTF-8" )
public class UplodController {

    @Value("${filePath}")
    private String filePath;


    @RequestMapping("/uploadFile")
    public void uploadFile(HttpServletRequest request, HttpServletResponse response,String fileType,String lastImg) throws IOException {

        //转换request
        MultipartHttpServletRequest mr=(MultipartHttpServletRequest) request;
        //获得存储文件的map
        Map<String, MultipartFile> fileMap = mr.getFileMap();
        //获得文件
        MultipartFile pic = fileMap.get("picFile");
        //获得文件的字节流
        byte[] bytes = pic.getBytes();


        //为了上传名字不重复  处理文件名
        //获得原始文件名
        String originalFilename = pic.getOriginalFilename();
        //获得后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //定义一个文件命名规则
        String fileName = UUID.randomUUID().toString();
        fileName=fileName+suffix;


        //获得文件服务器的路径
        //String filePath = PropUtil.read("filePath");
        //利用springboot优化




        //文件的上传的绝对路径
        String realPath=filePath+"/"+fileType+"/"+fileName;
        //文件的上传的相对路径
        String relativePath="/"+fileType+"/"+fileName;
        //创建jersey客户端
        Client client=Client.create();

        if(lastImg!=null && !"".equals(lastImg)){
            com.sun.jersey.api.client.WebResource resource1 = client.resource(lastImg);
            resource1.delete();
        }


        //获得web资源路径对象
        com.sun.jersey.api.client.WebResource resource = client.resource(realPath);
        //把文件字节上传到资源路径对象
        resource.put(bytes);

        //jsonobj返回
        JSONObject jo=new JSONObject();
        jo.put("realPath",realPath);
        jo.put("relativePath",relativePath);

        response.getWriter().write(jo.toString());
    }

    @RequestMapping("/uploadFileMp3")
    public void uploadFileMp3(HttpServletRequest request, HttpServletResponse response,String fileType,String lastMp3) throws IOException {

        //转换request
        MultipartHttpServletRequest mr=(MultipartHttpServletRequest) request;
        //获得存储文件的map
        Map<String, MultipartFile> fileMap = mr.getFileMap();
        //获得文件
        MultipartFile pic = fileMap.get("mp3file");
        //获得文件的字节流
        byte[] bytes = pic.getBytes();


        //为了上传名字不重复  处理文件名
        //获得原始文件名
        String originalFilename = pic.getOriginalFilename();
        //获得后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //定义一个文件命名规则
        String fileName = UUID.randomUUID().toString();
        fileName=fileName+suffix;


        //获得文件服务器的路径
       // String filePath = PropUtil.read("filePath");
        //利用springboot优化

        //文件的上传的绝对路径
        String realPath=filePath+"/"+fileType+"/"+fileName;
        //文件的上传的相对路径
        String relativePath="/"+fileType+"/"+fileName;
        //创建jersey客户端
        Client client=Client.create();

        if(lastMp3!=null && !"".equals(lastMp3)){
            com.sun.jersey.api.client.WebResource resource1 = client.resource(lastMp3);
            resource1.delete();
        }


        //获得web资源路径对象
        com.sun.jersey.api.client.WebResource resource = client.resource(realPath);
        //把文件字节上传到资源路径对象
        resource.put(bytes);

        //jsonobj返回
        JSONObject jo=new JSONObject();
        jo.put("realPath",realPath);
        jo.put("relativePath",relativePath);

        response.getWriter().write(jo.toString());
    }
}
