import java.util.ArrayList;

public class NoNullArrayList<T> extends ArrayList<T> {
    public NoNullArrayList(){
        super();
    }
    public NoNullArrayList(int cap){
        super(cap);
    }
    private void isNull(T t){
        if (t == null)
          throw new IllegalArgumentException("plz no null");
    }
    public boolean add(T t){
        isNull(t);
        return super.add(t);
    }
    public void add(int index, T t){
        isNull(t);
        super.add(index, t);
    }
    public T set(int index, T t){
        isNull(t);
        return(super.set(index, t));
    }
}
