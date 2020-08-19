package codeGenerator;

/**
 * Created by mohammad hosein on 6/28/2015.
 */
public class Address {
    private int num;
    private TypeAddress Type;
    private VarType varType;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public TypeAddress getType() {
        return Type;
    }

    public void setType(TypeAddress type) {
        Type = type;
    }

    public VarType getVarType() {
        return varType;
    }

    public void setVarType(VarType varType) {
        this.varType = varType;
    }

    public Address(int num, VarType varType, TypeAddress Type) {
        this.num = num;
        this.Type = Type;
        this.varType = varType;
    }

    public Address(int num,VarType varType) {
        this.num = num;
        this.Type = TypeAddress.Direct;
        this.varType = varType;
    }
    public String toString(){
        ToString toString;

        if (Type.equals(TypeAddress.Direct)){
            toString = new DirectAddToString();
            return toString.toString(num);
        }else if (Type.equals(TypeAddress.Indirect)){
            toString = new IndirectAddToString();
            return toString.toString(num);
        }else if (Type.equals(TypeAddress.Imidiate)){
            toString = new ImidiateToString();
            return toString.toString(num);
        }else {
            toString = new OtherToString();
            return toString.toString(num);
        }

    }
}
