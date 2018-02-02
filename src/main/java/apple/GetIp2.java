package apple;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetIp2 extends HttpServlet {
	@Override
	protected long getLastModified(HttpServletRequest req) {
		return new Date().getTime()-30000;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ip=getIPAddress(request);
		request.setAttribute("ip", ip);
		Enumeration enu=request.getHeaderNames();
		PrintWriter out = response.getWriter();
	     while(enu.hasMoreElements()){
	         String headerName=(String)enu.nextElement();
	       	 String headerValue=request.getHeader(headerName);
	       	 out.println(headerName+": "+headerValue);
	     }
		Cookie cookie = new Cookie("cookiename","cookievalue");
		cookie.setMaxAge(86400);
		cookie.setPath("/");
		response.addCookie(cookie);
	    Cookie[] cookies = request.getCookies();
	    Cookie cookie1 = null;
	    if (cookies!=null) {
	    	for (int i = 0; i < cookies.length; i++) {
	    		cookie1=cookies[i];
	    	}
		}
		out.println(ip+": "+getIPAddress(request));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	public static String getIPAddress(HttpServletRequest request) {
	    String ip = null;
	    String ipAddresses = request.getHeader("X-Forwarded-For");
	    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        ipAddresses = request.getHeader("Proxy-Client-IP");
	    }
	    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        ipAddresses = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        ipAddresses = request.getHeader("HTTP_CLIENT_IP");
	    }
	    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        ipAddresses = request.getHeader("X-Real-IP");
	    }
	    if (ipAddresses != null && ipAddresses.length() != 0) {
	        ip = ipAddresses.split(",")[0];
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        ip = request.getRemoteAddr();
	    }
	    return ip;
	}

}