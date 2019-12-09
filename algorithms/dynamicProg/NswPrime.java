package dynamicProg;

/**
 * Newman–Shanks–Williams prime (NSW prime) is a prime number p which can be written in the form:
 * S(2m+1) = ((1 + sqrt(2))^(2m + 1) + (1 - sqrt(2))^(2m + 1)) / 2
 * <p>
 * S0 = 1
 * S1 = 1
 * Sn = 2 * S(n-1) + S(n-2)
 * <p>
 * First few terms of the sequence are 1,1,3,7,17,41,99,...
 */
public class NswPrime {

    public static int getNthNSWPrime(int n) {
        int n1 = 1;
        int n2 = 1;
        int num = 0;
        for (int i = 2; i <= n; i++) {
            num = 2 * n1 + n2;
            n2 = n1;
            n1 = num;
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println("NSW(4) = " + NswPrime.getNthNSWPrime(4));
    }
}
