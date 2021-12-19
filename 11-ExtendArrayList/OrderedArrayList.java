public class OrderedArrayList<T extends Comparable<T>> extends NoNullArrayList<T>{
  public OrderedArrayList(){
    super();
  }
  public OrderedArrayList(int cap){
    super(cap);
  }
  public boolean add(T t){
    whereToPlace(t);
    return true;
  }
  public void add(int index, T t){
		whereToPlace(t);
  }
  public T set(int index, T t){
    T a = super.get(index);
    super.remove(index);
    whereToPlace(t);
    return(a);
  }
  private void whereToPlace(T value){
    int a = 0;
    for (int i = super.size()-1;i>=0 && super.get(i).compareTo(value)>0;i--){
      a = i;
    }
    if (super.get(super.size()-1).compareTo(value)<=0)
      super.add(value);
    super.add(a,value);
  }
}
