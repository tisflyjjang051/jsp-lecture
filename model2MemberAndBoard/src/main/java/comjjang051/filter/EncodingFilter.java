package comjjang051.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter(filterName = "UTF8EncodingFilter", urlPatterns = { "/*" })
public class EncodingFilter extends HttpFilter implements Filter {
       
    public EncodingFilter() {
        super();
    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("UTF8EncodingFilter 동작중 모든 요청에 앞서서 얘가 먼저 가로챔");
		if(request.getCharacterEncoding()==null) {
			request.setCharacterEncoding("UTF-8");
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
