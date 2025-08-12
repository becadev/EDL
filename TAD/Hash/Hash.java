package Hash;

public interface Hash {
    public  int findeElement(int k);  // k é o elemento que será procurado
    public void insertItem(int k, int o);
    public void removeElement(int k);
    public int size();
    public boolean isEmpty();
    public int[] keys();
    public int[] Elements();

}
