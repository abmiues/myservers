package com.mscreen.filter;
import javax.servlet.Filter; 
import javax.servlet.FilterChain; 
import javax.servlet.FilterConfig; 
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;


public class EncodingFilter
implements Filter
{
	/* 23 */@SuppressWarnings("unused")
	private static String USER_KEY_FILE = null;

	
	public void init(FilterConfig conf)
	{
		}

	
	@SuppressWarnings("unused")
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain)
	{
		try
		{
			/* 54 */HttpServletRequest req = (HttpServletRequest) request;
			/* 55 */HttpServletResponse res = (HttpServletResponse) response;
			/* 56 */HttpSession session = req.getSession();
			/* 58 */req.setCharacterEncoding("utf-8");
			/* 59 */res.setCharacterEncoding("utf-8");
			chain.doFilter(req, res);
			/* 80 */
			}
		catch (Exception e) {
			/* 84 */e.printStackTrace();
			}
		}

	
	public void destroy()
	{
		}
	
	
}