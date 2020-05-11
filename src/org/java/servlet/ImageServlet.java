package org.java.servlet;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.util.AuthCode;

/**
 * Servlet implementation class ImageServlet
 */
public class ImageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
        String authCode = AuthCode.getAuthCode();  //返回随机验证码
        
        request.getSession().setAttribute("authCode", authCode);  //将验证码保存到session中，便于以后验证  
        
        try {  
        	//发送图片  
            ImageIO.write(AuthCode.getAuthImg(authCode), "JPEG", response.getOutputStream());  
        } catch (IOException e){  
            e.printStackTrace();  
        }  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
