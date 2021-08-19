package designpatterns;

public class BuildAccountTest {
    BuildAccount obj = new BuildAccount.AccountBuilder().
            withName("sankar").build();
}
