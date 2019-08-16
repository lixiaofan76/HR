package com.qfedu.hr.servlet;

import com.qfedu.hr.pojo.User;
import com.qfedu.hr.service.UserService;
import com.qfedu.hr.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-10
 * Time:    22:22
 */
@WebServlet("/myFileUploadServlet.do")
public class MyFileUploadServlet extends HttpServlet {
    public static UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        /**
         * idea中保存图片位置：保存在out/artifacts/HR/upload中
         * 其中创建的upload与WEB-INF同一级别
         */
        String savePath = this.getServletContext().getRealPath("/upload");
        File file = new File(savePath);

        String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
        File temp = new File(tempPath);

        // 判断对应目录是否存在
        if (!file.exists() || !file.isDirectory()) {
            // 创建对应目录！！！
            file.mkdir();
        }

        if (!temp.exists() || !temp.isDirectory()) {
            temp.mkdir();
        }

        // 定义一个字符串，用于保存在操作过程中的异常和提示信息
        String msg = "";

        try {
            // 1. 创建 DiskFileItemFactory 工厂对象
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // 设置传入的最大的文件字节数 10MB
            //factory.setSizeThreshold(1024 * 1024 * 10);

            // 设置当前文件的保存临时目录
            factory.setRepository(temp);

            // 2. 创建一个上传文件的解析器
            ServletFileUpload upload = new ServletFileUpload(factory);

            // 3. 确定修改上传文件对应的解析器是UTF-8
            upload.setHeaderEncoding("utf-8");
            // 设置解析器能够处理的单个最大文件是 5M
            upload.setFileSizeMax(1024 * 1024 * 5);
            // 设置解析器的最大文件大小 10M
            upload.setSizeMax(1024 * 1024 * 10);

            // 4. 判断在提交数据的 form表单中，是否包含 enctype="multipart/form-data"
            if (!ServletFileUpload.isMultipartContent(request)) {
                return;
            }
            User user = new User();

            /*
             5. 解析 REQUEST请求内容
             解析之后的返回值是 List<FileItem> 保存的内容都是对应的 文件元素
            */
            List<FileItem> fileItems = upload.parseRequest(request);

            for (FileItem fileItem : fileItems) {
                /*
                考虑解析的request请求中，存在一些非文件上传请求
                判断提交的数据时普通参数，非文件上传
                */
                if (fileItem.isFormField()) {
                    String fileName = fileItem.getFieldName();
                    String value = fileItem.getString("utf-8");


                    //处理BeanUtils中日期的转换
                    //第二个参数，表示要转换的类型
                    //第一个参数表示自定义的转换器
                    ConvertUtils.register(new Converter() {

                        // 第二个参数，表示待转换的数据
                        // 第一个参数，表示要转换的类型
                        @Override
                        public Object convert(Class arg0, Object value) {
                            // TODO Auto-generated method stub
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            try {
                                return sdf.parse(value.toString());
                            } catch (ParseException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }

                            return null;
                        }
                    }, Date.class);
                    BeanUtils.copyProperty(user, fileName, value);


                } else {
                     /*
                     处理文件！！！
                     获取文件的名字
                     file=XXX.jpg
                    */
                    String name = fileItem.getName();
                    if (null == name || name.equals("")) {
                        continue;
                    }
                    String fileExName = name.substring(name.lastIndexOf(".") + 1);

                    // 判断当前获取到的文件后缀名是否符合系统要求
//                    if (!"jpg|jpeg|png|gif|bmp".contains(fileExName.toLowerCase())) {
//                        continue;
//                    }
                    // 获取UUID文件名和对应日期的保存文件夹名字
                    String fileName = makeFileName(name);
                    // String fileSavePath = makeDirName(savePath);

                    // File dir = new File(fileSavePath);

                    // if (!dir.exists() || !dir.isDirectory()) {
                    //     dir.mkdir();
                    // }
                    user.setImgPath("upload/"+fileName);

                    /*
                     操作 IO流，读取文件和写入文件
                     通过FileItem 获取上传文件的输入字节流
                     缓冲流！！！
                    */
                    BufferedInputStream bis = new BufferedInputStream(fileItem.getInputStream());

                    // 服务器读取到从浏览器提交的数据之后，保存数据到硬盘中，这里需要一个输出流
                    BufferedOutputStream bos = new BufferedOutputStream(
                            new FileOutputStream(savePath + File.separatorChar + fileName));

                    // 创建一个缓冲字节数组 4KB
                    byte[] buffer = new byte[1024 * 4];
                    int length = -1;

                    // 从浏览器读取数据，通过缓冲流写入数据到服务器指定目录中
                     while ((length = bis.read(buffer)) != -1) {
                        bos.write(buffer, 0, length);
                    }

                    // 关闭缓冲流资源
                    bos.close();
                    bis.close();

                    // fileItem 也是一个资源，需要delete
                    fileItem.delete();

                    msg = "文件上传成功";

                }
            }
            user.setId(id);
            userService.modifyUserBySelf(user);
            request.getSession().setAttribute("user",user);

            System.out.println("11");
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            msg = "单个文件超出限制异常";
            e.printStackTrace();
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("msg.jsp").forward(request, response);
            return;

        } catch (FileUploadBase.SizeLimitExceededException e) {
            msg = "文件总大小超出限制异常";
            e.printStackTrace();
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("msg.jsp").forward(request, response);
            return;

        } catch (FileUploadException e) {
            msg = "文件上传失败";
            e.printStackTrace();
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("msg.jsp").forward(request, response);
            return;

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("msg", msg);

        // request.getRequestDispatcher("msg.jsp").forward(request, response);
        response.sendRedirect("action.do?method=findOne4&id="+id);
    }

    /**
     * 使用 UUID重新编写文件的名字。UUID_原本的文件名.后缀名 XXXX-XXXXXX-XXX.jpg
     *
     * @param fileName 传入的文件名
     * @return 重新通过UUID整理之后的文件名
     */
    private String makeFileName(String fileName) {
        fileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
        return fileName.replaceAll("-", "");
    }

    /**
     * 根据传入的保存文件夹的根目录，获取对应当前日期的文件夹完整的路径，用于创建
     *
     * @param savePath 保存文件夹的根目录 /WEB-INF/upload
     * @return 当前日期保存文件的 String类型绝对路径
     */
    private String makeDirName(String savePath) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String date = format.format(new Date());

        return savePath + File.separatorChar + date;
    }

    }