// 通知类
class Inform implements Display {
    private String content;

    public Inform(String content) {
        this.content = content;
    }

    @Override
    public void display() {
        System.out.println("通知内容：" + content);
    }
}
