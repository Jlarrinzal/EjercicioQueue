public class QueueImpl<E> implements Queue<E> {

        E[] data;
        int size;

        public QueueImpl(int capacidad) {
                this.data = (E[]) new Object[capacidad];
                this.size = 0;
        }

        public void push(E e) throws FullQueueException {
                if (size == data.length) {
                        throw new FullQueueException("La cola está llena.");
                }
                data[size++]=e;
        }

        public E pop() throws EmptyQueueException {
                if (size == 0) {
                        throw new EmptyQueueException("La cola está vacía.");
                }
                E e = data[0];
                BajarPosiciones(data);
                size--;
                return e;
        }

        private void BajarPosiciones(E[] data) {
                for (int i=0; i < size-1; i++){
                        data[i]=data[i+1];
                }
        }

        public int size() {
                return size;
        }
}






