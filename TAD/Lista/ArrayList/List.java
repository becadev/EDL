package Lista.ArrayList;

public interface List {
    public int size();
    public Boolean isEmpty();
    public boolean isFirst(Object o);
    public boolean isLast(Object o);
    public Object Last();
    public Object First();
    public Object before(int p);
    public Object after(int p);
    public void replaceElement(int n, Object o);
    public void swapElements(int n, int q);
    public void insertBefore(int n, Object o);
    public void insertAfter(int n, Object o);
    public void insertFirst(Object o);
    public void insertLast(Object o);
    public void remove(int n);
}
