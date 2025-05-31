// 自定义异常类，继承自Exception
public class MyException extends Exception {
    // 无参构造函数
    public MyException() {
        super("年龄不合法");
    }

    //其他异常消息
    public MyException(String message) {
        super(message);
    }


}