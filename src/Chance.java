//Understands the occurences of events.
public class Chance {
    private static final int MAXIMUM = 1;
    private double probability;
    public Chance(double probability) {
        this.probability=probability;
    }

    @Override
    public boolean equals(Object obj){
        if(obj==this){
            return true;
    }
        if ((obj == null) || (obj.getClass() != this.getClass())){
            return false;
        }
        Chance other=(Chance) obj;
        return (probability==other.probability);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long bits=Double.doubleToLongBits(probability);
        int varCode=(int)(bits^(bits>>>32));
        result=result*prime+varCode;
        return result;
    }

    public Chance not() {
        return new Chance(MAXIMUM -probability);
    }

    public Chance and(Chance other) {
        return new Chance(this.probability*other.probability);
    }

    public Chance or(Chance other) {
        Chance notA=this.not();
        Chance notB=other.not();
        Chance notANotB= notA.and(notB);

        return notANotB.not();
    }
}

