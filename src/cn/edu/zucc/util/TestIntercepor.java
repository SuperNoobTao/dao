package cn.edu.zucc.util;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by shentao on 2016/5/3.
 */
public class TestIntercepor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation arg0) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("test begin");

        try{

            return arg0.invoke();
        }
        finally{

            System.out.println("test end");
        }
    }

}