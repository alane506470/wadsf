package com.usernameagersystem.Interceptor;

import java.util.List;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.usernameagersystem.entity.ImplUser;

public class GetAllUserInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		ImplUser interUser=new ImplUser();
		List alluserList=interUser.findAllUsers();
		List alladminList=interUser.findAllAdmins();
		arg0.getInvocationContext().getSession().put("alluserList", alluserList);
		arg0.getInvocationContext().getSession().put("alladminList", alladminList);

		return arg0.invoke();
	}

}
