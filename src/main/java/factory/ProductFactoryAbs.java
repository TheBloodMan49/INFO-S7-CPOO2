package factory;

import java.util.List;

public interface ProductFactoryAbs {
    public Product createP1();
    public Product createP2();
    public List<P1> createNP1(final int nb);
}
