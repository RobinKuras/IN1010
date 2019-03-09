class Lenkeliste<T> implements Liste<T> {
    protected int iBruk;
    protected Node hode;
    protected Node hale;

    public Lenkeliste() {
        iBruk = 0;
    }

    public int stoerrelse() {
        return iBruk;
    }

    public void leggTil(int pos, T x) {
        if(pos < 0 || pos > iBruk){
            throw new UgyldigListeIndeks(pos);
        }

        Node nodePos = hode;
        Node nyNode = new Node(x);

        if(pos == 0) {
            if(iBruk == 0) hale = hode = nyNode;
            hode.forrige = nyNode;
            nyNode.neste = hode;
            hode = nyNode;


        } else if(pos == iBruk) {
            hale.neste = nyNode;
            nyNode.forrige = hale;
            hale = nyNode;


        } else {
            for(int i = 0; i < pos; i++) nodePos = nodePos.neste;
            Node q = nodePos.forrige;
            nyNode.neste = nodePos;
            nyNode.forrige = q;
            q.neste = nyNode;
            nodePos.forrige = nyNode;
        }

        iBruk++;
    }

    public void leggTil(T x) {
        Node nyNode = new Node(x);

        if(hode == null) {
            hode = nyNode;
            hale = nyNode;
            iBruk++;
            return;
        }

        hale.neste = nyNode;
        nyNode.forrige = hale;
        hale = nyNode;
        iBruk++;

    }

    public void sett(int pos, T x) {
        if(pos < 0 || pos > iBruk - 1|| iBruk == 0){
            throw new UgyldigListeIndeks(pos);
        }

        Node nyNode = new Node(x);

        if(pos == 0){
            hode.data = x;

        } else if(pos == iBruk) {
            hale.data = x;

        } else {
            Node nodePos = hode;
            for(int i = 0; i < pos; i++) {
                nodePos = nodePos.neste;
            }

            nodePos.data = x;
        }
    }

    public T hent(int pos) {
        if(pos < 0 || pos > iBruk -1){
            throw new UgyldigListeIndeks(pos);
        }

        T temp = null;

        if(pos == 0) {
            temp = hode.data;
        }

        else if(pos == iBruk) {
            temp = hale.data;
        }

        else {
            Node nodePos = hode;
            for(int i = 0; i < pos; i++){
                nodePos = nodePos.neste;
            }
            temp = nodePos.data;
        }
        return temp;
    }

    public T fjern(int pos) {
        if(pos < 0 || pos > iBruk - 1 || iBruk == 0){
            throw new UgyldigListeIndeks(pos);
        }

        T temp = null;
        Node nodePos = hode;
        temp = hode.data;

        if(iBruk == 0) return null;

        else if(pos == 0) {
            if(iBruk == 1){
                hode = hale = null;
                iBruk--;
                return temp;
            }

            hode = hode.neste;
            hode.forrige = null;
        }

        else if(pos == iBruk - 1){
            temp = hale.data;
            hale = hale.forrige;
            hale.neste = null;
            iBruk--;
        }

        else{
            for(int i = 0; i < pos; i++) nodePos = nodePos.neste;
            temp = nodePos.data;
            Node q = nodePos.forrige;
            Node r = nodePos.neste;

            q.neste = r;
            r.forrige = q;
            iBruk--;

        }
        return temp;
    }

    public T fjern() {
        T temp;

        if(iBruk == 0) {
            throw new UgyldigListeIndeks(0);
        }


        else if(iBruk == 1) {
            temp = hode.data;
            hode = null;
            hale = null;
            iBruk--;
            return temp;
        }


        else{
            temp = hode.data;
            hode.neste.forrige = null;
            hode = hode.neste;
            iBruk--;
            return temp;
        }
    }

    public String toString() {

        StringBuilder s = new StringBuilder();

            s.append('[');
            System.out.println(iBruk);
            if(!(iBruk == 0)){
                Node p = hode;
                s.append(p.data);

                p = p.neste;



                while (p!=null){
                    s.append(',').append(' ').append(p.data);
                    p = p.neste;
                }
            }
            s.append(']');


            return s.toString();
    }

    protected class Node {
        Node neste;
        Node forrige;
        T data;

        Node(T t) {
            data = t;
        }
    }
}
