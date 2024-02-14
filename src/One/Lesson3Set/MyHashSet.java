package One.Lesson3Set;

public class MyHashSet<E> implements MySet<E>{
    private int size = 0;
    private int arrayLength = 1;
    private Node<E>[] array_linked = new Node[arrayLength];

    @Override
    public boolean add(E e) {
        if(!contains(e)){
            size++;
            if(size == arrayLength) resize();
            Node<E> nodeInput = new Node<>(e.hashCode(), e, null);

            if(array_linked[getIndex(nodeInput)] == null){
                array_linked[getIndex(nodeInput)] = nodeInput;
                return true;
            }

            Node<E> node = array_linked[getIndex(nodeInput)];
            while (node.next != null) node = node.next;
            node.next = nodeInput;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> node = array_linked[getIndex(o)];
        while (node != null){
            if (node.value.equals(o)) return true;
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if(array_linked[getIndex(o)] == null) return false;
        Node<E> node = array_linked[getIndex(o)];
        if(node.value.equals(o)){
            array_linked[getIndex(o)] = null;
            return true;
        }
        while (node.next != null){
            if(node.next.value.equals(o)){
                array_linked[getIndex(o)] = null;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public int size(){
        return size;
    }

    private int getIndex(Node<E> node) {
        return node.hashCode() % arrayLength;
    }

    private int getIndex(Object o) {
        return o.hashCode() % arrayLength;
    }

    private void resize(){
        Node<E>[] buffer = array_linked;
        arrayLength *= 2;
        array_linked = new Node[arrayLength];

        for (int i = 0; i < buffer.length; i++){
            Node node = buffer[i];
            while (node != null){
                add((E) node.value);
                node = node.next;
            }
        }
    }

    private static class Node<E>{
        private final int hash;
        private E value;
        private Node<E> next;

        public Node(int hash, E value, Node<E> next) {
            this.hash = hash;
            this.value = value;
            this.next = next;
        }

        public int hashCode() {
            return hash;
        }
    }
}
