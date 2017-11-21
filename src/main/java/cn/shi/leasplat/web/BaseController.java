package cn.shi.leasplat.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.shi.leasplat.entity.User;
import cn.shi.leasplat.util.Result;
import cn.shi.leasplat.util.LEASDateFormat;

public abstract class BaseController {
	
	@Autowired
	HttpServletRequest request;
	
	public final User getLoginUser()
	{
		return (User) request.getAttribute("login_user");
	}
	
	protected final String getIP()
    {
        String addr = request.getHeader("X-Forwarded-For");
        if (null == addr) return request.getRemoteAddr();
        if (addr.indexOf(',') == -1) return addr;
        else return addr.substring(0, addr.indexOf(',')).trim();
    }
	
	@ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleException(Exception ex)
    {
        System.err.println("Controller“Ï≥££∫" + ex.getClass().getName());
        ex.printStackTrace();
        return new Result().setError(ex);
    }
	
    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        LEASDateFormat dateFormat = new LEASDateFormat();
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
 }
