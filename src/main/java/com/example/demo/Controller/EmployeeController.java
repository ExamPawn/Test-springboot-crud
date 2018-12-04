package com.example.demo.Controller;


import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @GetMapping("/emps")
        public String list(Map<String,Object>map){
        Collection<Employee> emp = employeeDao.getAll();
        map.put("emps",emp);
            //tymeleaf默认拼串
                return "emp/list";
        }
        @GetMapping("/emp")
        public  String add(Map<String,Object>map){
            Collection<Department> departments = departmentDao.getDepartments();
            map.put("depts",departments);
            return "emp/add";
        }
        @PostMapping ("/emp")
        public String add(Employee employee){//POJO  添加页面的form表单的name属性要和实体类的属性对应，不区分大小写
        employeeDao.save(employee);
        return "redirect:/emps";
        }
        @GetMapping("/emp/{id}")
        public String update(@PathVariable("id") Integer id ,Model model) {
            Employee employee = employeeDao.get(id);
            model.addAttribute("emp",employee);
            Collection<Department> departments = departmentDao.getDepartments();
            model.addAttribute("depts",departments);
            //添加和更新都是同一个页面，那么就要进行判断（添加页面只传入了depts）而这个更新页面传入了emp，所以在页面进行判断$[emp!=null]
            return "emp/update";
        }

       @PutMapping("/emp")
        public  String  updateEmp(Employee employee){
        employeeDao.save(employee);
        return  "redirect:/emps";
        }
        @DeleteMapping("/emp/{id}")
        public String deleteEmp(@PathVariable("id") Integer id){
            employeeDao.delete(id);
        return "redirect:/emps";
        }


}
