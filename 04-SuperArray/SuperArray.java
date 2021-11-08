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
        data[size] = me;
        size++;
        return true;
    }

//phase 2

    public String get(int index){ //how would you print an error and return something at the same time
        if (index < 0 || index >= size){
            System.out.println("ERROR: Index is out of range");
            return "null" ;
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
    }

    public int lastIndexOf(String target){
      for(int i = size-1; i >= 0; i--){
        if (data[i].equals(target)){
          return i;
        }
      }
    }

    public void add (int index, String value){
      if (index < 0 || index > size)
          System.out.println("ERROR: Index is out of range");
      for (int i = size; i > index; i--){
        
      }
    }

    public String remove(int index){
      return "";
    }

    public boolean remove(String target){
      return true;
    }
}
