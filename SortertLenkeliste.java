class SortertLenkeliste<T extends Comparable<T> > extends Lenkeliste<T> {
    public SortertLenkeliste(){
        super();
    }

    @Override
    public void leggTil(T x) {
        Node nyNode = new Node(x);
        Node nodePos = hode;
        int i = 0;

        if(iBruk == 0) {
            super.leggTil(x);
        }
        else {
        while(nodePos != null && (nyNode.data.compareTo(nodePos.data) > 0)){
            i++;
            nodePos = nodePos.neste;
            }
        super.leggTil(i, x);
        }
    }

    @Override
    public T fjern() {
        return fjern(iBruk-1);
    }

    @Override
    public void sett(int pos, T x) {
        throw new UnsupportedOperationException("Du kan ikke sette inn noe her din løk!");
    }

    @Override
    public void leggTil(int pos, T x) {
        throw new UnsupportedOperationException("Du kan ikke sette inn noe her din løk!");
    }
}
