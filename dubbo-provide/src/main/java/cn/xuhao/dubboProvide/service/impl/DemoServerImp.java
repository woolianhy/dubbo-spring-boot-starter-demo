package cn.xuhao.dubboProvide.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.xuhao.dubbo.api.DemoService;
import cn.xuhao.dubbo.api.TestService;

@com.alibaba.dubbo.config.annotation.Service(interfaceClass = DemoService.class)
@Service
public class DemoServerImp implements DemoService {


	@Reference(check=false)//启动消费者不检查服务者是否存在
    public TestService testService;
	
    @Override
    public String sayHello(String s) {
    	String test = "调用失败";
		try {
			test = testService.testService(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "provide服务提供方0:你好，"+s+"! \t\t " + test;
    }
}

