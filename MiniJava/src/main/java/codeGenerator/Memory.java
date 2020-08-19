package codeGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohammad hosein on 6/27/2015.
 */
public class Memory {
    private List<ThreeAddressCode> codeBlock;
    private int lastTempIndex;
    private int lastDataAddress;
    private final int stratTempMemoryAddress = 500;
    private final int stratDataMemoryAddress = 200;
    private final int dataSize = 4;
    private final int tempSize = 4;

    public Memory() {
        codeBlock = new ArrayList<ThreeAddressCode>();
        lastTempIndex = stratTempMemoryAddress;
        lastDataAddress = stratDataMemoryAddress;
    }

    public int getTemp() {
        lastTempIndex += tempSize;
        return lastTempIndex - tempSize;
    }
    public  int getDateAddress(){
        lastDataAddress += dataSize;
        return lastDataAddress-dataSize;
    }
    public int saveMemory() {
        codeBlock.add(new ThreeAddressCode());
        return codeBlock.size() - 1;
    }

    public void add3AddressCode(Operation op, Address opr1, Address opr2, Address opr3) {
        codeBlock.add(new ThreeAddressCode(op,opr1,opr2,opr3));
    }

    public void add3AddressCode(int i, Operation op, Address opr1, Address opr2, Address opr3) {
        codeBlock.remove(i);
        codeBlock.add(i, new ThreeAddressCode(op, opr1, opr2,opr3));
    }


    public int getCurrentCodeBlockAddress() {
        return codeBlock.size();
    }

    public void pintCodeBlock() {
        System.out.println("Code Block");
        for (int i = 0; i < codeBlock.size(); i++) {
            System.out.println(i + " : " + codeBlock.get(i).toString());
        }
    }
}

class ThreeAddressCode {
    private Operation operation;
    private Address Operand1;
    private Address Operand2;
    private Address Operand3;


    public ThreeAddressCode() {

    }

    public Address getOperand1() {
        return Operand1;
    }

    public Address getOperand2() {
        return Operand2;
    }

    public Address getOperand3() {
        return Operand3;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperand1(Address operand1) {
        Operand1 = operand1;
    }

    public void setOperand2(Address operand2) {
        Operand2 = operand2;
    }

    public void setOperand3(Address operand3) {
        Operand3 = operand3;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public ThreeAddressCode(Operation op, Address opr1, Address opr2, Address opr3) {
        operation = op;
        Operand1 = opr1;
        Operand2 = opr2;
        Operand3 = opr3;
    }

    public String toString()
    {
        if(operation == null) {
            return "";
        }
        StringBuffer res = new StringBuffer("(");
        res.append(operation.toString()).append(",");
        if(Operand1 != null){
            res.append(Operand1.toString());
        }
        res.append(",");
        if(Operand2 != null){
            res.append(Operand2.toString());
        }
        res.append(",");
        if(Operand3 != null){
            res.append(Operand3.toString());
        }
        res.append(")");

        return res.toString();
    }
}
