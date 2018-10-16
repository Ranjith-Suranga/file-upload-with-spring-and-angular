package lk.ijse.absd.util;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;

/**
 * By default CommonsMultipartResolver supports only HTTP POST method
 * If you want to use other methods as well, then you need to create a sub class
 * extending CommonsMultipartResolver and then override isMultipart method
 */
public class CustomMutlipartResolver extends CommonsMultipartResolver {

    @Override
    public boolean isMultipart(HttpServletRequest request) {

        if (request.getMethod().equals("PUT") || request.getMethod().equals("POST")){
            return true;
        }else {
            return super.isMultipart(request);
        }

    }
}
