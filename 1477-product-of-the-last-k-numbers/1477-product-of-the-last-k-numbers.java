import java.util.*;

class ProductOfNumbers {
    private List<Integer> prefixProduct;
    private int lastZeroIndex;

    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        prefixProduct.add(1);  // Base case for multiplication
        lastZeroIndex = -1;  // Tracks the last zero index
    }

    public void add(int num) {
        if (num == 0) {
            prefixProduct.clear();
            prefixProduct.add(1);
            lastZeroIndex = prefixProduct.size() - 1;  // Mark the reset point
        } else {
            prefixProduct.add(prefixProduct.get(prefixProduct.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int size = prefixProduct.size();
        if (size - k - 1 < lastZeroIndex) {
            return 0;  // If the requested range includes a zero, return 0
        }
        return prefixProduct.get(size - 1) / prefixProduct.get(size - k - 1);
    }
}

/**
 * Example usage:
 * ProductOfNumbers productOfNumbers = new ProductOfNumbers();
 * productOfNumbers.add(3);
 * productOfNumbers.add(0);
 * productOfNumbers.add(2);
 * productOfNumbers.add(5);
 * productOfNumbers.add(4);
 * System.out.println(productOfNumbers.getProduct(2)); // Output: 20
 * System.out.println(productOfNumbers.getProduct(3)); // Output: 40
 * System.out.println(productOfNumbers.getProduct(4)); // Output: 0
 * productOfNumbers.add(8);
 * System.out.println(productOfNumbers.getProduct(2)); // Output: 32
 */