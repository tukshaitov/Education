package edu.pattern.gof.iterator;

import java.util.Iterator;

/**
 * Created by Eldar on 11/8/2015.
 */
public class Order implements Iterable<Furniture> {
    private volatile Sofa sofa;
    private volatile Cupboard cupboard;
    private volatile Bed bed;

    public Order(Sofa sofa, Cupboard cupboard, Bed bed) {
        this.sofa = sofa;
        this.cupboard = cupboard;
        this.bed = bed;
    }

    public void setSofa(Sofa sofa) {
        this.sofa = sofa;
    }

    public void setCupboard(Cupboard cupboard) {
        this.cupboard = cupboard;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    @Override
    public Iterator<Furniture> iterator() {
        return new FurnitureIterator();
    }

    private class FurnitureIterator implements Iterator<Furniture> {

        private int position;

        @Override
        public boolean hasNext() {
            switch (position) {
                case 0:
                    if (sofa != null) return true;
                case 1:
                    if (cupboard != null) return true;
                case 2:
                    if (bed != null) return true;
                default:
                    return false;
            }
        }

        @Override
        public Furniture next() {
            Furniture furniture = null;
            switch (position) {
                case 0:
                    if (sofa != null) {
                        furniture = sofa;
                        position = 1;
                        break;
                    }
                case 1:
                    if (cupboard != null) {
                        furniture = cupboard;
                        position = 2;
                        break;
                    }
                case 2:
                    if (bed != null) {
                        furniture = bed;
                        position = 3;
                        break;
                    }
                default:
                    furniture = null;
            }
            return furniture;
        }
    }
}
