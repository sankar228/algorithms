package designpatterns;

public class BuildAccount {
    private String name;
    private int id;
    private String dept;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDept() {
        return dept;
    }

    private BuildAccount(AccountBuilder builder){
        this.name = builder.name;
        this.id = builder.id;
        this.dept = builder.dept;
    }


    public static class AccountBuilder{
        private String name;
        private int id;
        private String dept;

        public AccountBuilder(){

        }
        public AccountBuilder(String name, int id){
            this.name = name;
            this.id = id;
        }

        public AccountBuilder withName(String name){
            this.name = name;
            return this;
        }

        public AccountBuilder withId(int id){
            this.id = id;
            return this;
        }

        public AccountBuilder withDept(String dept){
            this.dept = dept;
            return this;
        }

        public BuildAccount build(){
            return new BuildAccount(this);
        }
    }
}
