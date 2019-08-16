package com.qfedu.hr.servlet;

import com.qfedu.hr.pojo.*;
import com.qfedu.hr.service.*;
import com.qfedu.hr.service.impl.*;
import com.qfedu.hr.utils.BaseServlet;
import com.qfedu.hr.utils.MessageRequest;
import com.qfedu.hr.utils.MyBeanUtils;
import com.qfedu.hr.vo.VoUserList;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-03
 * Time:    16:31
 */
@WebServlet("/action.do")
public class ActionServlet extends BaseServlet {
    private static UserService userService = new UserServiceImpl();
    private static ApplicantService applicantService = new ApplicantServiceImpl();
    private static TrainService trainService = new TrainServiceImpl();
    private static SalaryService salaryService = new SalaryServiceImpl();


    /**
     * 添加用户，只有管理员有权限操作
     * @param request
     * @param response
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws SQLException
     * @throws IOException
     */
    public void add(HttpServletRequest request, HttpServletResponse response)
            throws InvocationTargetException, IllegalAccessException, SQLException, IOException {
        // 获取所有参数的 Map 双边对象 参数的名字是Key，参数的值是value
        Map<String, String[]> parameterMap = request.getParameterMap();

        // 创建一个没有任何数据的对象，实体
        User user = new User();

        // 使用BeanUtils 方法populate 需要的参数是 符合JavaBean规范的类对象和对应的Map双边队列
        MyBeanUtils.populate(user, parameterMap);

        // 调用 EmployeeDao 添加数据到数据库
        userService.addUser(user);

        // 使用重定向，操作连接到 listAll
        response.sendRedirect("action.do?method=listAll");

    }

    /**
     * 应聘者注册功能
     * @param request
     * @param response
     * @throws SQLException
     * @throws ServletException
     * @throws IOException
     */
    public void addApplicant(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Applicant applicant = new Applicant();
        MyBeanUtils.populate(applicant,parameterMap);

        userService.applicantRegister(applicant);
        MessageRequest.messageRequestDispatcher(request,response,"恭喜你成为我们的一员","applicantLogin.jsp");


    }

    /**
     * 删除指定id的用户信息
     *
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     */
    public void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        userService.deleteById(id);
        response.sendRedirect("action.do?method=listAll");
    }

    /**
     * 删除指定id的应聘者信息
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     */
    public void deleteApplicant(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        applicantService.deleteApplicant(id);
        response.sendRedirect("action.do?method=listAllApplicant");
    }

    /**
     * 修改用户信息
     *
     * @param request
     * @param response
     * @throws SQLException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IOException
     * @throws ParseException
     */
    public void modify(HttpServletRequest request, HttpServletResponse response) throws SQLException, InvocationTargetException, IllegalAccessException, IOException, ParseException {
        Map<String, String[]> parameterMap = request.getParameterMap();

         User user = new User();
         MyBeanUtils.populate(user,parameterMap);

        // BeanUtils.populate(user,parameterMap);

        int i = userService.modifyUserInfo(user);
        response.sendRedirect("action.do?method=pageLimit");

    }

    /**
     * 应聘者-修改指定id信息
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     */
    public void modifyById(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
         Integer id = Integer.valueOf(request.getParameter("id"));

        Applicant Applicant = userService.findByApplicantId(id);

        applicantService.addToUser(Applicant);
        applicantService.midifyById(id);

        response.sendRedirect("action.do?method=listAllApplicant");


    }

    /**
     * 管理员获取要修改的普通用户信息
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     * @throws ServletException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        // 根据ID 找出对应的Employee对象 ，保存到Request域对象中
        Integer id = Integer.valueOf(request.getParameter("id"));
        User user = userService.findById(id);

        if (null == user) {
            request.setAttribute("msg", "对应员工不存在");
            request.getRequestDispatcher("action.do?method=listAll").forward(request, response);
        } else {
            request.setAttribute("users", user);
            request.getRequestDispatcher("modify.jsp").forward(request, response);
        }
    }

    /**
     * 普通用户通过findOne2查询个人信息
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     * @throws ServletException
     */
    public void findOne2(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        // 根据ID 找出对应的Employee对象 ，保存到Request域对象中
        Integer id = Integer.valueOf(request.getParameter("id"));
        User user = userService.findById(id);

        if (null == user) {
            request.setAttribute("msg", "对应员工不存在");
            request.getRequestDispatcher("action.do?method=listAll").forward(request, response);
        } else {
            request.setAttribute("users", user);
            request.getRequestDispatcher("modify2.jsp").forward(request, response);
        }
    }


    /**
     * 修改个人信息后重新刷新主页
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     * @throws ServletException
     */
    public void findOne4(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        // 根据ID 找出对应的Employee对象 ，保存到Request域对象中
        Integer id = Integer.valueOf(request.getParameter("id"));
        User user = userService.findById(id);

        if (null == user) {
            request.setAttribute("msg", "对应员工不存在");
            request.getRequestDispatcher("action.do?method=listAll").forward(request, response);
        } else {
           /* request.setAttribute("users", user);
            request.getRequestDispatcher("homePage2.jsp").forward(request, response);*/
           request.getSession().setAttribute("users",user);
           response.sendRedirect("homePage2.jsp");
        }
    }

    /**
     * 应聘者通过findOne3查询个人信息
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     * @throws ServletException
     */
    public void findOne3(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        // 根据ID 找出对应的Applicant对象 ，保存到Request域对象中
        Integer id = Integer.valueOf(request.getParameter("id"));
        Applicant Applicant = userService.findByApplicantId(id);

        if (null == Applicant) {
            request.setAttribute("msg", "对应信息不存在");
            request.getRequestDispatcher("action.do?method=listAll").forward(request, response);
        } else {
            request.setAttribute("Applicant", Applicant);
            request.getRequestDispatcher("modify3.jsp").forward(request, response);
        }
    }

    /**
     * 查询普通用户所有信息
     * @param request
     * @param response
     * @throws SQLException
     * @throws ServletException
     * @throws IOException
     */
    public void listAll(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        // 查询数据库，获取到 List<VoUserList>集合
        List<VoUserList> users = userService.ListInfo();

        // 在request 域对象中，保存 员工信息对象 List 集合
        request.setAttribute("users", users);

        // 转发到 list.jsp页面中
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }

    /**
     * 查询应聘者所有信息
     * @param request
     * @param response
     * @throws SQLException
     */
    public void listAllApplicant(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Applicant> applicants = applicantService.listAllApplicant();
        request.getSession().setAttribute("applicant",applicants);
        request.getRequestDispatcher("applicantList.jsp").forward(request,response);

    }

    /**
     * 用户登录功能
     *
     * @param request
     * @param response
     * @throws SQLException
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        //获取用户输入的验证码
        String verifycode = request.getParameter("verifycode");
        //验证码校验
        HttpSession session  = request.getSession();
        String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
        //确保验证码一次性
        session.removeAttribute("CHECKCODE_SERVER");
        if (!checkcode_server.equalsIgnoreCase(verifycode)) {
        //    提示验证码错误
            MessageRequest.messageRequestDispatcher(request,response,"验证码错误","login.jsp");
            return;
        }
        // 获取前端输入的用户名和密码
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = userService.login(username, password);

        if (user == null) {
            MessageRequest.messageRequestDispatcher(request, response, "输入错误或无权限", "login.jsp");
        } else {

            if (user.getRoleId() == 1) {
                request.getSession().setAttribute("user", user);
                // 管理员用户进入index.jsp，可以查看所有用户信息
                response.sendRedirect("adminManage.jsp");
                // request.getRequestDispatcher("adminManage.jsp").forward(request, response);
            } else if (user.getRoleId() == 0) {
                int i = userService.signCount();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String date = simpleDateFormat.format(new Date());
                int i1 = userService.signCountByDate(date);
                // if (i1 > 0) {
                //
                // }
                Sign sign = userService.signInfoByDate(username,date);

                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("sign",sign);



                // signService.addUserSign(user);
//            非管理员进入个人页面，只能查看个人信息
//                 response.sendRedirect("homePage.jsp");
                request.getRequestDispatcher("homePage2.jsp").forward(request, response);
            }

        }

    }

    /**
     * 应聘者登录
     * @param request
     * @param response
     * @throws SQLException
     * @throws ServletException
     * @throws IOException
     */
    public void applicantLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        // 获取前端输入的用户名和密码
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        Applicant applicant = userService.applicantLog(name, tel);

        if (applicant == null) {
            MessageRequest.messageRequestDispatcher(request, response, "输入错误", "applicantLogin.jsp");
        } else {
            request.getSession().setAttribute("applicants",applicant);
           request.getRequestDispatcher("applicantIndex.jsp").forward(request,response);

        }

    }

    /**
     * 用户注册功能
     * @param request
     * @param response
     * @throws SQLException
     * @throws ServletException
     * @throws IOException
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();

        User user = new User();

        MyBeanUtils.populate(user,parameterMap);

        userService.register(user);
        MessageRequest.messageRequestDispatcher(request,response,"恭喜你成为我们的一员","login.jsp");

        // request.getRequestDispatcher("login.jsp").forward(request,response);

    }

    /**
     * 用户登出
     * @param request
     * @param response
     * @throws SQLException
     * @throws ServletException
     * @throws IOException
     */
    public void userLogout(HttpServletRequest request,HttpServletResponse response) throws SQLException,ServletException,IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.invalidate();

            response.sendRedirect("homePage.jsp");
    }

    /**
     * 添加培训信息
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     */
    public void addTrain(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Train train = new Train();
        MyBeanUtils.populate(train,parameterMap);
        trainService.addTrain(train);
        request.getSession().setAttribute("train",train);
        MessageRequest.messageRequestDispatcher(request,response,"添加成功","addTrain.jsp");
    }

    /**
     * 查询所有培训信息
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     * @throws ServletException
     */
    public void listAllTrainInfo(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Train> trains = trainService.listAllTrainInfo();
        request.getSession().setAttribute("train",trains);

        request.getRequestDispatcher("listAllTrainInfo.jsp").forward(request,response);

    }

    /**
     * 根据id删除培训信息
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     */
    public void deleteByTrainId(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        trainService.deleteByTrainId(id);

        response.sendRedirect("action.do?method=listAllTrainInfo");
    }

    /**
     * 查询所有员工工资信息
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     * @throws ServletException
     */
    public void listAllSalary(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Salary> salaries = salaryService.listAllSalary();
        request.getSession().setAttribute("salary",salaries);

        request.getRequestDispatcher("listAllSalary.jsp").forward(request,response);


    }

    /**
     * 添加员工工资信息
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     * @throws ServletException
     */
    public void addSalary(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException {
        Map<String, String[]> parameterMap = request.getParameterMap();

        Salary salary = new Salary();

        MyBeanUtils.populate(salary,parameterMap);

        salaryService.addSalary(salary);
        request.getSession().setAttribute("salary",salary);

       // MessageRequest.messageRequestDispatcher(request,response,"添加成功","index.jsp");
        request.setAttribute("msg","添加成功");
        request.getRequestDispatcher("addSalary.jsp").forward(request,response);

    }


    /**
     * 删除选中的编号用户信息
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     */
    public void deleteSalaryById(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        salaryService.deleteSalaryById(id);

       /* PrintWriter out = response.getWriter();
        out.print("<script>alert('确定要删除吗？'); window.location='action.do?method=listAllSalary' </script>");
        out.flush();
        out.close();*/

        response.sendRedirect("action.do?method=listAllSalary");

    }

    /**
     * 删除父选框的用户信息
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     */
    public void delSelectUser(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException {
    //    获取所有id
        String[] uids = request.getParameterValues("uid");
    //    调用service方法
        userService.deleteSelected(uids);

    //    跳转查询方法
        response.sendRedirect("action.do?method=pageLimit");
    }


    /**
     * 实现分页查询
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     * @throws ServletException
     */
    /*public void pageLimit(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException {
        //    获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示的条数

        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }
        // //获取条件查询参数
        // Map<String, String[]> condition = request.getParameterMap();


        //    调用service
        PageBean<VoUserList> pageBean = userService.findUserByPage(currentPage,rows);
        //    将pageBean存入request中
       request.getSession().setAttribute("pb",pageBean);
        request.getRequestDispatcher("user.jsp").forward(request,response);
    }*/

    public void pageLimit(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException {

        //    获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示的条数

        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }
        // //获取条件查询参数
        // Map<String, String[]> condition = request.getParameterMap();

        Map<String, String[]> condition = request.getParameterMap();


        //    调用service
        PageBean<VoUserList> pageBean = userService.findUserByPage(currentPage,rows,condition);
        //    将pageBean存入request中
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.getSession().setAttribute("pb",pageBean);
        request.setAttribute("condition",condition);
        request.getRequestDispatcher("user.jsp").forward(request,response);
    }

    /**
     * 根据id修改工资信息
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     * @throws ServletException
     */
    public void findOneSalary(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
    //    调用service方法
        Salary salary = salaryService.findOneSalaryById(id);
    //    保存到session
        request.getSession().setAttribute("salary",salary);
    //    跳转到修改界面
        request.getRequestDispatcher("modifySalary.jsp").forward(request,response);
    }

    /**
     * 通过id修改工资信息
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     */
    public void midifySalaryById(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException {
    //    获取参数id和数据
        String id = request.getParameter("id");
        int sid = Integer.parseInt(id);
        Map<String, String[]> parameterMap = request.getParameterMap();
        Salary salary = new Salary();
        MyBeanUtils.populate(salary,parameterMap);
        //    调用service方法
        salaryService.midifySalaryById(salary,sid);
    //    重定向查询所有方法
        response.sendRedirect("action.do?method=listAllSalary");
    }

    /**
     * 实现用户请假功能
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     * @throws ServletException
     */
    public void adkForLeave(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Qingjia qingjia = new Qingjia();
        MyBeanUtils.populate(qingjia,parameterMap);

        userService.adkForLeave(qingjia);
        response.sendRedirect("action.do?method=findOneQingjia&userName="+qingjia.getUserName());
    }

    /**
     * 实现根据id查看用户请假内容
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     * @throws ServletException
     */
    public void findOneQingjia(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException {
        String name = request.getParameter("userName");

        List<Qingjia> oneQingjia = userService.findOneQingjia(name);

        request.getSession().setAttribute("qj",oneQingjia);
        request.getRequestDispatcher("listOneQingjia.jsp").forward(request,response);
    }

    /**
     * 查看所有请假信息
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     * @throws ServletException
     */
    public void listAllQingjia(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Qingjia> qingjias = userService.listAllQingjia();
        request.getSession().setAttribute("qj",qingjias);
        request.getRequestDispatcher("listAllQj.jsp").forward(request,response);
    }

    /**
     * 删除指定id的用户请假内容
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     */
    public void deleteQjById(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteQjById(id);
        response.sendRedirect("action.do?method=listAllQingjia");
    }

    /**
     * 根据id查询用户请假信息
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     * @throws ServletException
     */
    public void findOneQjById(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Qingjia qjById = userService.findOneQjById(id);
        request.getSession().setAttribute("qj",qjById);
        request.getRequestDispatcher("modifyOneQjById.jsp").forward(request,response);
    }

    /**
     * 根据id修改指定用户的请假信息
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void modifyOneQjById(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, InvocationTargetException, IllegalAccessException {
        int id = Integer.parseInt(request.getParameter("id"));
        Map<String, String[]> parameterMap = request.getParameterMap();
        Qingjia qingjia = new Qingjia();
        // MyBeanUtils.populate(qingjia,parameterMap);
        BeanUtils.populate(qingjia,parameterMap);
        userService.modifyOneQjById(qingjia,id);
        response.sendRedirect("action.do?method=listAllQingjia");
    }

    /**
     * 实现用户添加打卡信息
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     * @throws ServletException
     */
    public void userSign(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException {
      String name = request.getParameter("userName");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new Date());
        userService.addSignByName(name);
        Sign sign = userService.signInfoByDate(name,date);
        request.getSession().setAttribute("sign",sign);
        /*signService.userSign(id,user.getUserName());*/
        // request.setAttribute("user",user);
        // request.getRequestDispatcher("addSign.jsp").forward(request,response);
       /* Sign signByName = signService.findSignByName(name);
        request.setAttribute("signIfno",signByName);*/
        // request.getRequestDispatcher("userSign.jsp").forward(request,response);
        response.sendRedirect("homePage2.jsp");


    }

    /**
     * 获取打卡记录的用户人员
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     */
    public void listHalfUsers(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException {
        //    获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示的条数

        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }

        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();

        //    调用service
        PageBean<VoUserList> pageBean = userService.findUserByPage(currentPage,rows, condition);
        //    将pageBean存入request中
        request.getSession().setAttribute("pb",pageBean);


       /* List<VoUserList> voUserLists = userService.ListInfo();*/
        request.setAttribute("pb",pageBean);
        request.getRequestDispatcher("listHalfUsers.jsp").forward(request,response);
    }


    /**
     * 查询一个用户的所有打卡记录
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     * @throws ServletException
     */
    public void findOneAllSigns(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException {
        String name = request.getParameter("userName");
        List<Sign> allSigns = userService.findOneAllSigns(name);
        request.getSession().setAttribute("allSign",allSigns);
        request.getRequestDispatcher("listOneUserSigns.jsp").forward(request,response);
    }

    /**
     * 根据id删除用户打卡信息
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     */
    public void deleteOneSignById(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException {
        String name = request.getParameter("userName");
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteOneSignById(id);
        response.sendRedirect("action.do?method=findOneAllSigns&userName="+name);
    }











}
