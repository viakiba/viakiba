package cn.viakiba.mina.pack_1;

/**
 * 这里是定义的输入命令 及其对应的数值
 * @author Administrator
 *
 */
public class Command {
	
	public static final int LOGIN = 0;

    public static final int QUIT = 1;

    public static final int BROADCAST = 2;

    private final int num;

    private Command(int num) {
        this.num = num;
    }

    public int toInt() {
        return num;
    }

    public static Command valueOf(String s) {
        s = s.toUpperCase();
        if ("LOGIN".equals(s)) {
            return new Command(LOGIN);
        }
        if ("QUIT".equals(s)) {
            return new Command(QUIT);
        }
        if ("BROADCAST".equals(s)) {
            return new Command(BROADCAST);
        }

        throw new IllegalArgumentException("Unrecognized command: " + s);
    }
}
