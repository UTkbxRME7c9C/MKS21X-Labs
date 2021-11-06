public class SuperArray{
    private String[] data;
    private int size;

    public SuperArray(){
        data = new String[]{ null, null, null, null, null, null, null, null, null, null };
        size = 0;
    }

    public int size(){
        return size;
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
    public String get(int index){
        if (index < 0 || index >= size)
          return "";
        return data[index];
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

}
