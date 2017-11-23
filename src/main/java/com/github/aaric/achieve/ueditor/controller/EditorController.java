package com.github.aaric.achieve.ueditor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * UEditor控制器
 *
 * @author Aaric, created on 2017-11-23T11:19.
 * @since 1.0-SNAPSHOT
 */
@RestController
@RequestMapping("/api/editor")
public class EditorController {

    /**
     * /getObject
     *
     * @return
     */
    @RequestMapping(value = "/getObject", method = RequestMethod.GET)
    public Object getObject() {
        Map<String, Object> mapData = new HashMap<>();
        mapData.put("status", "sucess");
        mapData.put("time", Calendar.getInstance().getTime());
        return mapData;
    }
}
