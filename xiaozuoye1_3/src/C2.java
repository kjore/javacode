public class C2 extends P {
    protected int c;

    public C2(int p, int c) {
        super(p);
        this.c = c;
    }

    public int getC() {
        return c;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        C2 other = (C2) obj;
        return this.c == other.c;
    }


}