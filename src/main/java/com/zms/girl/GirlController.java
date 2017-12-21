package com.zms.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.*;
import java.util.Calendar;
import java.util.List;

@RestController
public class GirlController {
    //private final String FILE_PATH="C://Users//zms//Desktop//img";
    private final String FILE_PATH = "D://img";
    @Autowired
    private GirlService girlService;

    /**
     * 查询所有的列表
     *
     * @return
     */
    @GetMapping(value = "/getList")
    public List<Girldb> getList() {
        return girlService.findAll();
    }

    /**
     * 添加一个
     *
     * @param cupSize
     * @param age
     * @return 添加的字段
     */
    @PostMapping(value = "addGirl")
    public Girldb addGirl(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age) {
        Girldb db = new Girldb();
        db.setAge(age);
        db.setCupSize(cupSize);
        Girldb deresult = girlService.save(db);
        return deresult;

    }

    /**
     * 根据id查询一条数据
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/findByid/{id}")
    public Girldb findByid(@PathVariable("id") Integer id) {
        return girlService.findOne(id);
    }

    /**
     * 根据id修改
     *
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/findByid/{id}")
    public Girldb update(@PathVariable("id") Integer id,
                         @RequestParam("cupSize") String cupSize,
                         @RequestParam("age") Integer age) {
        Girldb db = new Girldb();
        db.setAge(age);
        db.setCupSize(cupSize);
        db.setId(id);
        return girlService.save(db);
    }

    /**
     * 根据id删除一条数据
     *
     * @param id
     */
    @DeleteMapping(value = "/deleteByid/{id}")
    public void deleteByid(@PathVariable("id") Integer id) {
        girlService.delete(id);
    }

    @GetMapping(value = "/listByAge/{age}")
    public List<Girldb> findByAge(@PathVariable("age") Integer age) {
        return girlService.findByAge(age);
    }

    @PostMapping(value = "/upload")
    public void upload(MultipartFile multipartFile) throws Exception {
        String fileName = multipartFile.getOriginalFilename();
        File file = new File(FILE_PATH + "/" + fileName);
        multipartFile.transferTo(file);
    }

}
