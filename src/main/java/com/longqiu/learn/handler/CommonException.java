package com.longqiu.learn.handler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by QIUJ003 on 2017/12/18.
 */
@ControllerAdvice
public class CommonException {
    private static final Logger logger =  LoggerFactory.getLogger(CommonException.class);

    /**
     * 统一异常处理
     *
     * @param exception
     *            exception
     * @return
     */
    @ExceptionHandler({ RuntimeException.class })
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(RuntimeException exception) {
        logger.info("自定义异常处理-RuntimeException");
        logger.error(exception.getMessage());
        ModelAndView m = new ModelAndView();
        m.addObject("longqiuException", exception.getMessage());
        m.setViewName("/error/501.html");
        return m;
    }

    /**
     * 统一异常处理
     *
     * @param exception
     *            exception
     * @return
     */
    @ExceptionHandler({ Exception.class })
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(Exception exception) {
        logger.info("自定义异常处理-Exception");
        logger.error(exception.getMessage());
        ModelAndView m = new ModelAndView();
        m.addObject("longqiuException", exception.getMessage());
        m.setViewName("/error/500.html");
        return m;
    }
}
