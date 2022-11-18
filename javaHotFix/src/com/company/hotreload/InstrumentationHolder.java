package com.company.hotreload;

import java.lang.instrument.Instrumentation;

public class InstrumentationHolder {
	
	protected static Instrumentation inst;
	
	public static void premain(String agentArgs, Instrumentation inst) {
		InstrumentationHolder.inst = inst;
	}

	public static Instrumentation getInstrumentation() {
		if (inst == null) {
			throw new RuntimeException("Instrumentation Not instantiate!");
		}
		return inst;
	}
	
	public static void agentmain(String args, Instrumentation inst) throws Exception {
        	System.out.println("agent 动态挂载 "+args);
		// args 可以传递 class文件的bytes数据（base64）,也可以传递 class 的路径  
        }

}

// 随便一个新的java 可执行文件 执行如下代码即可动态挂载
/**

import com.sun.tools.attach.*;
import com.sun.tools.attach.spi.AttachProvider;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        List<VirtualMachineDescriptor> list = VirtualMachine.list();
        AtomicReference<VirtualMachineDescriptor> virtualMachineDescriptorAtomic = new AtomicReference<>();
        list.stream().forEach(x -> {
            System.out.println(x.displayName());
            if (x.displayName().contains("目标执行类的名字")){
                virtualMachineDescriptorAtomic.set(x);
            }
        });
        VirtualMachineDescriptor virtualMachineDescriptor = virtualMachineDescriptorAtomic.get();
        if (virtualMachineDescriptor == null){
            System.out.println("没有获取到");
        }
        System.out.println(virtualMachineDescriptor.displayName());

        AttachProvider provider = virtualMachineDescriptor.provider();
        VirtualMachine virtualMachine = provider.attachVirtualMachine(virtualMachineDescriptor.id());

        virtualMachine.loadAgent("MANIFEST.MF 包含 Agent-Class 对应的执行class 的 jar全路径","自定义参数");
        Properties agentProperties = virtualMachine.getAgentProperties();
        System.out.println(agentProperties);
        virtualMachine.detach();
    }
}

*/
