package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: YEN
 * Date: 2016/7/31
 * Time: 14:17
 */

/**
 * 字符编码过滤器
 */


//注解配置过滤器
@WebFilter(urlPatterns = {"/*"},initParams = {
        @WebInitParam(name="encoding",value = "UTF-8")
})
public class CharactorFilter implements Filter {

    String encoding=null;

    public CharactorFilter(){

    }

    //初始化方法
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding=filterConfig.getInitParameter("encoding");
    }

    //过滤器处理方法
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(null!=encoding){
            //设置请求的编码格式
            servletRequest.setCharacterEncoding(encoding);
            //设置response字符编码
            servletResponse.setContentType("text/html;charset="+encoding);
        }
        //传递给下一个过滤器
        filterChain.doFilter(servletRequest, servletResponse);
    }

    //销毁方法
    @Override
    public void destroy() {
        encoding=null;
    }

}
