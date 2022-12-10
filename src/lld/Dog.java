package lld;

public class Dog implements Pet{
    public Dog(){}
    @Override
    public void speak() {
        System.out.println("bark");
    }
}
