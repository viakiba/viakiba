package org.viakiba.jcommander;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "= ")
public class CommandBean {

    @Parameter(names = {"-p", "-port", "--port"}, required = true,
            description = "run mode. The agent/monitor modes are available.")
    public int port;

    @Parameter(names = {"-c", "-contexts", "--contexts"}, required = true,
            description = "run mode. The agent/monitor modes are available.")
    public String contexts;

    @Parameter(names = {"-d", "-diy", "--diy"}, required = true,
            description = "run mode. The agent/monitor modes are available.")
    public String diy;

    public CommandBean() {
    }

    public CommandBean(int port, String contexts, String diy) {
        this.port = port;
        this.contexts = contexts;
        this.diy = diy;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getContexts() {
        return contexts;
    }

    public void setContexts(String contexts) {
        this.contexts = contexts;
    }

    public String getDiy() {
        return diy;
    }

    public void setDiy(String diy) {
        this.diy = diy;
    }

    @Override
    public String toString() {
        return "CommandBean{" +
                "port=" + port +
                ", contexts='" + contexts + '\'' +
                ", diy='" + diy + '\'' +
                '}';
    }

}
