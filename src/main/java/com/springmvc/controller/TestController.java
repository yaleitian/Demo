package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yalei.tian on 2018-01-16
 * @author lees
 */
@Controller
public class TestController {

    /**
     * @ResponseBody 该注解可以把map自动转换成json格式给前台
     */
    @RequestMapping(value = "/ajax",method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map ajax(HttpServletRequest request){


        Map mapJson = new HashMap();
        String person;
        String optValues = request.getParameter("opt_values");
        if ("1".equals(optValues)){
            person = "姓名：me，年龄：38，性别：男，出生地：上海";
            mapJson.put("person",person);
        }
        if ("2".equals(optValues)){
            person = "姓名：her，年龄：33，性别：女，出生地：深圳";
            mapJson.put("person",person);
        }
        if ("3".equals(optValues)){
            person = "姓名：who，年龄29，性别：男，出生地：广州";
            mapJson.put("person",person);
        }
        return mapJson;
    }
}
