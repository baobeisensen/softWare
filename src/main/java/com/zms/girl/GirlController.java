package com.zms.girl;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

@RestController
public class GirlController {
    private final String FILE_PATH ="C://Users//zms//Desktop//img";
    @Autowired
    private GirlService girlService;
    @GetMapping(value = "/getList")
    public List<Girldb> getList(){

        return girlService.findAll();
    }
    @GetMapping(value = "/upload")
    public void upload(MultipartHttpServletRequest req) throws Exception{
        try{
            //long modelId = Long.parseLong(req.getParameter("id"));
            // 读取流
            StringBuffer strBuff = new StringBuffer();
            InputStream in = req.getFile("file").getInputStream();
            Reader in2 = new InputStreamReader(in);
            BufferedReader reader = new BufferedReader(in2);
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuff.append(line);
            }
            String ldbstr = strBuff.toString();
            in.close();
            System.out.println(ldbstr);

            // 创建文件保存路径
            File file =new File(FILE_PATH);
            //如果文件夹不存在则创建
            if  (!file .exists()  && !file .isDirectory())
            {
                System.out.println("//不存在");
                file .mkdir();
            } else
            {
                System.out.println("//目录存在");
            }
            String filePath = FILE_PATH+"\\2.xml";
            File fileName=new File(filePath);
            if(!file.exists())   {
                fileName.createNewFile();
            }
            // 写入到文件中
            OutputStream os = new FileOutputStream(fileName);
            os.write(ldbstr.getBytes());
            os.flush();
            os.close();

            // 修改数据库中版本类型对应的模板文件地址
//            DeviceType type =  deviceTypeService.findOne(id);
//            type.setTemplateFilePath(filePath);
//            deviceTypeService.update(type);
//            return filePath;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
