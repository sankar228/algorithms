package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CouponFinder {
    public static void main(String[] args) {
        CouponFinder obj = new CouponFinder();
        List<String> couponCode = new ArrayList<>();
        couponCode.add("a a");
        couponCode.add("b 0 b");

        List<String> shoppingCartItems = new ArrayList<>();
        shoppingCartItems.add("a");
        shoppingCartItems.add("a");
        shoppingCartItems.add("b");
        shoppingCartItems.add("c");
        shoppingCartItems.add("b");
        shoppingCartItems.add("a");

        System.out.println(obj.isCouponValidCart(couponCode, shoppingCartItems));
    }

    public boolean isCouponValidCart(List<String> couponCode, List<String> shoppingCartItems){

        for(int c=0; c < couponCode.size();) {
            List<String> couponGroup = Arrays.asList(couponCode.get(c).split(" "));
            for (int sc = 0; sc < shoppingCartItems.size();) {

                if(shoppingCartItems.size() < couponCode.size()){
                    return false;
                }
                if(c == couponCode.size()){
                    return true;
                }

                for(int cg=0; cg < couponGroup.size(); cg++) {
                    if (! (shoppingCartItems.get(sc).equals(couponGroup.get(cg)))
                            || "0".equals(couponGroup.get(cg))) {
                        sc ++;
                        break;
                    }else{
                        if(cg + 1 == couponGroup.size() && c+1 < couponCode.size()){
                            couponGroup = Arrays.asList(couponCode.get(++c).split(" "));
                            cg = -1;
                        }
                        sc ++;
                    }
                }
            }
        }
        return false;
    }
}
