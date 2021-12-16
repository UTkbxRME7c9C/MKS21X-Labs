import java.util.ArrayList;

public class NoNullArrayList<T> extends ArrayList<T> {
    private NoNullArrayList<T> alist;
    private void isNull(T t){
        if (t.equals(null))
            throw new IllegalArgumentException("plz no null");
    }
    public boolean add(T t){
        isNull(t);
        return true;
    }
    public void add(int index, T t){
        isNull(t);
    }
    public T set(int index, T t){
        isNull(t);
        return t;
    }
}