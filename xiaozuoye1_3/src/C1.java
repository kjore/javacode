public class C1 extends P {
    protected int c;

    public C1(int p, int c) {
        super(p);
        this.c = c;
    }

    public int getC() {
        return c;
    }
//instanceof：允许父子类之间比较，适合宽松判断。
//getClass()：类型必须完全一致，适合严格判断。
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        C1 other = (C1) obj;
        return this.c == other.c;
    }
/*// 以C1类为例，C2类同理
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (!(obj instanceof P)) return false;

    // 首先确保是P的实例并且p值相等
    P other = (P) obj;
    if (this.p != other.p) return false;

    // 如果对方也是某个子类，则比较c值
    if (obj instanceof C1) {
        return this.c == ((C1) obj).c;
    } else if (obj instanceof C2) {
        return this.c == ((C2) obj).c;
    }


    // 如果只是P类实例，则只比较p值，已经在上面完成
    return true;
}*/

}