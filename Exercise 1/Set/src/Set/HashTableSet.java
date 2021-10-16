package Set;

public class HashTableSet extends Set{
    private int capacity = 100000;
    private HashNode[] hashTable = new HashNode[capacity];
    private int nodeSize = 0;

    private int getHashIndex(String s){
        int index = Math.abs(s.hashCode() % capacity);
        return index;
    }

    @Override
    public boolean add(String word){
        if(nodeSize >= capacity){
            resize();
        }
        //1, get the hash table index
        int idx = getHashIndex(word);

        //2, check if contains the word.
        // if not, add to list;
        if(!contains(word)){
            HashNode node = new HashNode(word);
            //if the key's value is empty, add as the head
            if(hashTable[idx] == null){
                hashTable[idx] = node;

            }else{
                //add to the front.
                node.next = hashTable[idx];
                hashTable[idx] = node;

            }
            nodeSize++;
            return true;
        }
        //else return false;
        return false;
    }


    @Override
    public boolean contains(String word){

        int idx = getHashIndex(word);
        if(hashTable[idx] == null){
            return false;
        }

        HashNode curr = hashTable[idx];
        while(curr != null){
            if(curr.str.equals(word)){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }


    public int size(){
        return nodeSize;
    }

    public void resize(){
        capacity += capacity;
        HashNode[] oldTable = hashTable;
        hashTable = new HashNode[capacity];
        for(int i = 0; i < oldTable.length; i++){
            hashTable[i] = oldTable[i];
        }
    }

    public void print(){
        for(int i = 0; i < capacity; i++){
            System.out.print("hashTable[" + i + "]: ");
            if(hashTable[i] == null){
                System.out.print("null \n");

            }else{
                HashNode curr = hashTable[i];

                while(curr != null){
                    System.out.print(curr.str + " ");
                    curr = curr.next;
                }
                System.out.println();
            }
        }
        System.out.print("hashTable capacity: " + this.capacity);
    }
}

class HashNode{
    String str;
    HashNode next;

    HashNode(String str){
        this.str = str;
        this.next = null;
    }

}
