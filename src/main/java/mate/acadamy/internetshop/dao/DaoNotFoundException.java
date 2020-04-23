package mate.acadamy.internetshop.dao;

public class DaoNotFoundException extends Throwable {
    public DaoNotFoundException() {
        System.out.println("@Dao not found");
    }
}
