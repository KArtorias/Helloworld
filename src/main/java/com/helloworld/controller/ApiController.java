package com.helloworld.controller;

import com.helloworld.projo.User;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/user")
    public User getUser(){
        User u = new User(100, "张三","男", 18);
        return u;
    }

    @GetMapping("/user_by_id")
    public User getUserByIdAndName(@RequestParam(value = "id", required = false, defaultValue = "def_id") int id,
                                   @RequestParam(value = "name",required = false, defaultValue = "def_name") String name){
        User u = new User(id, name,"男", 18);

        System.out.println("user: "+u.toString());

        return u;
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        System.out.println("user: "+user.toString());
        return user;
    }

    @PutMapping("/user")
    public User putUser(@RequestBody User user) {
        System.out.println("user: "+user.toString());
        return user;
    }

    @DeleteMapping("/user")
    public User deleteUser(@RequestBody User user) {
        System.out.println("user: "+user.toString());
        return user;
    }

    @PostMapping("/upload/files")
    public String postFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws FileNotFoundException {
        String uploadPath = ResourceUtils.getURL("classpath:").getPath() + "upload_files/";
        System.out.println("file name uploadPath: " + uploadPath);
        File folder = new File(uploadPath);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString()
                + oldName.substring(oldName.lastIndexOf("."), oldName.length());

        if(!file.isEmpty()){
            try {
                file.transferTo(new File(folder, newName));
                String filePath = request.getScheme() + "://" + request.getServerName()
                        + ":" + request.getServerPort() + request.getContextPath() + "/" + newName;
                return filePath;
            }catch (Exception e) {
                return e.toString();
            }
        }
        return "success";
    }

    @GetMapping("/view/files")
    public void postFile(HttpServletResponse response) {
        try {
            response.sendRedirect("http://localhost:8080/1e8f6607-b980-4e66-a81f-6796568c39f5.mp4");
        }catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
