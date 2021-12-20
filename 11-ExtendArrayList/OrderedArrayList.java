public class OrderedArrayList<T extends Comparable<T>> extends NoNullArrayList<T>{
  public OrderedArrayList(){
    super();
  }
  public OrderedArrayList(int cap){
    super(cap);
  }
  public boolean add(T t){
    helper(t);
    return true;
  }
  public void add(int index, T t){
		helper(t);
  }
  public T set(int index, T t){
    T a = super.get(index);
    super.remove(index);
    helper(t);
    return(a);
  }
  private void helper(T value){
    if (value == null) throw new IllegalArgumentException("plz no null");
    int a = 0;
    for (int i = super.size()-1;i>=0 && super.get(i).compareTo(value)>0;i--){
      a = i;
    }
    if (super.size()==0){
      super.add(value);
    }else if (super.get(super.size()-1).compareTo(value)<=0){
      super.add(value);
    }else{super.add(a,value);}
  }
}
