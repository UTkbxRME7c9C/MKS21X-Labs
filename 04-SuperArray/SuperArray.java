public class SuperArray{
  private String[] data;
  private int size;

  public SuperArray(){
    data = new String[10];
    size = 0;
  }

  public int size(){
    return size;
  }
  public String[] data(){
    return data;
  }

  public String toString(){
    String start = "[";
    for (int i = 0; i < size;i++){
        start += data[i];
        if (i != size-1)
            start += ", ";
    }
    return start + "]";
  }

  public String toStringDebug(){
    String start = "[";
    for (int i = 0; i<data.length;i++){
      start += data[i];
      if (i != data.length-1)
        start += ", ";
    }
    return start + "]";
  }

  public boolean add(String me){
    if ( size == data.length)
      resize();
    data[size] = me;
    size++;
    return true;
  }

//phase 2

  public String get(int index){
    if (index < 0 || index >= size){
      System.out.println("ERROR: Index is out of range");
      return "null";
    }
    return data[index];
  }

  public String set(int index, String element){
    String orig = "";
    if (index < 0 || index >= size){
        System.out.println("ERROR: Index is out of range");
        return "null";
    }
    orig = data[index];
    data[index] = element;
    return orig;
  }

// warmup methods

  public int indexOf(String target){
    for (int i= 0;i<size; i++){
      if (data[i].equals(target)){
        return i;
      }
    }
    return -1;
  }

  public int lastIndexOf(String target){
    for(int i = size-1; i >= 0; i--){
      if (data[i].equals(target)){
        return i;
      }
    }
    return -1;
  }

  public void add (int index, String value){
    if ( size == data.length)
      resize();
    if (index < 0 || index > size){
      throw new ArrayIndexOutOfBoundsException("ERROR: Index is out of range");
    }else{
      for (int i = size; i > index; i--){
        data[i] = data[i-1];
      }
      data[index] = value;
      size++;
    }
  }

  public String remove(int index){
    if (index < 0 || index >= size){
      System.out.println("ERROR: Index is out of range");
      return "null";
    }
    String old = data[index];
    for (int i = index; i < size-1; i++){
      data[i] = data[i+1];
    }
    data[size-1] = null;
    size--;
    return old;
  }

  public boolean remove(String target){
    for (int i = 0;i<size;i++){
      if (data[i] == target){
        for (int j = i;j<size-1;j++){
          data[j] = data[j+1];
        }
        data[size-1]=null;
        size--;
        return true;
      }
    }
    return false;
  }

//phase 3

  public SuperArray(int initialCapacity){
    data = new String[initialCapacity];
    size = 0;
  }

  private void resize(){
    int newlen = (2*data.length)+1;
    String[] newary = new String[newlen];
    for (int i = 0;i<size;i++){
      newary[i] = data[i];
    }
    data = newary;
  }
}
