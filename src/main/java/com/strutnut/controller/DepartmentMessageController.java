package com.strutnut.controller;

import com.alibaba.fastjson.JSON;
import com.strutnut.pojo.Department;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/bmx")
public class DepartmentMessageController {

    @RequestMapping(path = "/list",produces = "text/html;charset=UTF-8")
    public String getDepartmentMessageList()
    {
        System.out.println("OK");
        Department d1 = new Department("1", "俞塘交通局");
        Department d2 = new Department("2", "俞塘外交部");
        Department d3 = new Department("3", "俞塘摸鱼部");
        ArrayList<Department> departments = new ArrayList<>();
        departments.add(d1);
        departments.add(d2);
        departments.add(d3);
        String jsonDepartment= JSON.toJSONString(departments);
        return jsonDepartment;
    }

    @RequestMapping(path = "/listPage/{currentPage}",produces = "text/html;charset=UTF-8")
    public String getListPage(@PathVariable int currentPage)
    {
        return "ok";
    }
}
