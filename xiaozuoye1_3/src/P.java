//不符合面向对象编程风格，原因如下：
//
//
//违反了Liskov替换原则：子类对象应该能够替换父类对象而不引起程序错误，但这种实现使得不同子类可能被视为相等，破坏了类型系统的完整性
//高耦合：每个子类需要知道所有其他子类的存在和实现细节
//扩展性差：添加新子类时需要修改所有现有子类的equals方法
//违反对称性：如果C1和C2的实现不一致，可能导致a.equals(b)为true而b.equals(a)为false
//代码维护困难：当类层次结构变化时，需要更新所有子类的equals方法

public class P {
    protected int p;

    public P(int p) {
        this.p = p;
    }

    public int getP() {
        return p;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        P other = (P) obj;
        return this.p == other.p;
    }


}