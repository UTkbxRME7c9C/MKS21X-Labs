public class OrderedArrayList<T extends Comparable<T>> extends NoNullArrayList<T>{
  public OrderedArrayList(){
      super();
  }
  public OrderedArrayList(int cap){
      super(cap);
  }
  public boolean add(T t){
      return super.add(t);
  }
  // public void add(int index, T t){
  //     isNull(t);
  //     super.add(index, t);
  // }
  // public T set(int index, T t){
  //     isNull(t);
  //     return(super.set(index, t));
  // }

  // private void insertionSort(int[] ary){
  // for(int i = 1;i < ary.length; i++){
  //   if (ary[i] < ary[i-1]){
  //     int tmp = ary[i];
  //     int jt = 0;
  //     for(int j = i-1;j >=0 && ary[j] > tmp;j--){
  //       ary[j+1]=ary[j];
  //       jt = j;
  //     }
  //     ary[jt] = tmp;
  //   }
  // }
}
