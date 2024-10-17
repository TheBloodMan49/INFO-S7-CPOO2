package functionalBuilder;

public class CheneBuilder extends ArbreBuilder{
    private boolean feuilles;

    public CheneBuilder() {
        super();
        feuilles = false;
    }

    public CheneBuilder setFeuilles(boolean feuilles) {
        this.feuilles = feuilles;
        return this;
    }
    @Override
    public CheneBuilder setAge(int age) {
        super.setAge(age);
        return this;
    }
    @Override
    public CheneBuilder setTaille(int taille) {
        super.setTaille(taille);
        return this;
    }

    public Chene build() {
        return new Chene(age, taille, feuilles);
    }
}
