package designpatterns;

public class SingleTonEntity {

    private String name;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    private SingleTonEntity(){}

    public static class SingleTonProvider{

        public static SingleTonEntity instance = new SingleTonEntity();
    }

    public static SingleTonEntity getInstance(){

        return SingleTonProvider.instance;
    }
}
