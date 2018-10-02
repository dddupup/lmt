package Controller;

import Pojo.Poi;
import Utils.CreateExcel;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by shaohao on 2018/9/30.
 */
@Controller
public class PoiController {
    @RequestMapping(value = "/hik/poi")
    public String poi(){
        return "poi";
    }
    @RequestMapping(value = "/hik/download",method = RequestMethod.POST)
    public void download(Poi poi, HttpServletRequest request, HttpServletResponse response) throws IOException {
        poi.setCustom(request.getParameter("protocol"));
        System.out.println(poi.getCustom());
        CreateExcel excel = new CreateExcel();
        try {
            excel.createExcel(poi);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置文件名
        String name=(poi.getIpc().replace("10.192.","")+"-"+poi.getNum()+".xlsx");
        String filename=new String(name.getBytes("UTF-8"),"iso-8859-1");
        //设置content-disposition响应头控制浏览器以下载的形式打开文件
        response.setHeader("content-disposition", "attachment;filename="+filename);
        //获取要下载的文件输入流
        InputStream in=new FileInputStream(CreateExcel.path);
        int len=0;
        //创建数据缓冲区
        byte[] buffer=new byte[1024];
        //通过response对象获取OutputStrem流
        OutputStream out=response.getOutputStream();
        //将FileInputStream流写入到buffer缓冲区
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer,0,len);//将缓冲区的数据输出到客户端浏览器
        }
        in.close();
        excel.deleteFile();

    }
}
