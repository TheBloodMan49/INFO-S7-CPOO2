package functionalBuilder;

public class ArbreBuilder {
    protected int age;
    protected int taille;

    public ArbreBuilder() {
        age = 1;
        taille = 1;
    }

    public ArbreBuilder setAge(int age) {
        this.age = age;
        return this;
    }
    public ArbreBuilder setTaille(int taille) {
        this.taille = taille;
        return this;
    }

    public Arbre build() {
        return new Arbre(age, taille);
    }
}
