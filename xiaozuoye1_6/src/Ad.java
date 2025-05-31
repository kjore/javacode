// 广告类
class Ad implements Display {
    private String message;

    public Ad(String message) {
        this.message = message;
    }

    @Override
    public void display() {
        System.out.println("广告消息：" + message);
    }
}