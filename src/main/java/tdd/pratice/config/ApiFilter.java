package tdd.pratice.config;

import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Component
public class ApiFilter implements Filter {
    public static final Logger LOGGER = LoggerFactory.getLogger(ApiFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 注入日志id，方便问题追钟
        String logId = request.getParameter("traceId");
        if (StringUtils.isEmpty(logId)) {
            logId = UUID.randomUUID().toString();
        }
        ThreadContext.put("logId", logId);
        LOGGER.info("welcome to the filter!!");
        String apiKey = ((HttpServletRequest) request).getHeader("api_key");
//        if (apiKey == null || apiKey == "" || apiKey == " ") {
////            鉴权逻辑
//            HttpServletResponse re = (HttpServletResponse) response;
//            re.setStatus(401);
//            re.setHeader("customerKey","content");
//            return;
//        }
        LOGGER.info(apiKey);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
