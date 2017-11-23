package com.github.aaric.achieve.ueditor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * HTML控制器
 *
 * @author Aaric, created on 2017-11-23T11:43.
 * @since 1.0-SNAPSHOT
 */
@Controller
@RequestMapping("/html")
public class HtmlController {

    /**
     * /hello
     *
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView("hello");
        return modelAndView;
    }
}
