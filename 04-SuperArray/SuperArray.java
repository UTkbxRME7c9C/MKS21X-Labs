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
    
    public String toStringDebug(){
        return Arrays.toString(data);
    }

    public void add(String me){
        data[size] = me;
        size++;
    }

}
