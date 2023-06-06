import java.util.Arrays;

public class MyMiniList <T> implements MiniList<T> {
    T[] objectStore = (T[]) new Object[10];
    int objSize = 0;



    @Override
    public void add(T element) {
        if(objectStore[objectStore.length-1] != null){
            objectStore = Arrays.copyOf(objectStore, objectStore.length*2);
            objectStore[objSize] = element;
        }else{
            objectStore[objSize] = element;
        }
        objSize++;


    }

    @Override
    public T get(int index) {
        if(index >= 0 && index < objectStore.length-1){
            return objectStore[index];
        }
        return null;
    }

    @Override
    public int getIndex(T element) {
        for(int i = 0; i < objectStore.length - 1; i++){
            if(objectStore[i] == element){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void set(int index, T element) {
        if(index >= 0 && index < (objectStore.length-1)){
            objectStore[index] = element;
        }
    }

    @Override
    public int size() {
        return objSize;
    }

    @Override
    public T remove(int index) {

        if(index >= 0 && index < objectStore.length - 1){
            T holder  = objectStore[index];
            for(int i = index; i < objectStore.length; i++){
                objectStore[i] = objectStore[i+1];
                if(objectStore[i] == null){
                    break;
                }
            }
            objSize--;
            return holder;
        }


        return null;
    }

    @Override
    public boolean remove(T element) {
        try{
            for(int j = getIndex(element); j < objectStore.length -1; j++){
                objectStore[j] = objectStore[j+1];
                if(objectStore[j] == null){
                    break;
                }
            }
            objSize--;
            return true;
        }catch (IndexOutOfBoundsException e){
            return false;
        }

    }

    @Override
    public void clear() {
        Arrays.fill(objectStore, null);
        objSize = 0;
    }
}
