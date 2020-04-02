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

}
