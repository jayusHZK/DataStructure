package test;

public abstract class father {
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    abstract void aa();

    public static void main(String[] args) {
        father f=new father() {
            @Override
            void aa() {
                System.out.println(111);
            }
        };
        System.out.println(f.aaa());
    }

    public String aaa(){
        return "aa";
    }
}
