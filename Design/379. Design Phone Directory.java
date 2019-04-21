
/*

Design a Phone Directory which supports the following operations:
get: Provide a number which is not assigned to anyone.
check: Check if a number is available or not.
release: Recycle or release a number.

Example:
// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
PhoneDirectory directory = new PhoneDirectory(3);

// It can return any available phone number. Here we assume it returns 0.
directory.get();

// Assume it returns 1.
directory.get();

// The number 2 is available, so return true.
directory.check(2);

// It returns 2, the only number that is left.
directory.get();

// The number 2 is no longer available, so return false.
directory.check(2);

// Release number 2 back to the pool.
directory.release(2);

// Number 2 is available again, return true.
directory.check(2);

*/

/*

O(n),O(n)

*/

class PhoneDirectory {
    
    private int[] dict;
    private List<Integer> cache;
    private Random rand;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        this.dict = new int[maxNumbers];
        this.cache = new LinkedList<>();
        this.rand = new Random();
        for (int i = 0; i < maxNumbers; ++i) {
            dict[i] = i;
            cache.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (cache.size() == 0) return -1;
        int index = rand.nextInt(cache.size());
        int ans = cache.get(index);
        cache.remove(index);
        dict[ans] = -1;
        return ans;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return dict[number] != -1;
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (dict[number] != -1) return;
        dict[number] = number;
        cache.add(number);
    }
}




