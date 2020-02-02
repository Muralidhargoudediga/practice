import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test1 {
	private static Integer i;
	
	private MA11 a;

	public static void main(String[] args) throws FileNotFoundException {

		// BigDecimal p = new BigDecimal("1");
		// BigDecimal o = new BigDecimal("1");
		//
		// for(int i = 0; i < 23; i++) {
		// BigDecimal n = new BigDecimal(""+(365-i));
		// BigDecimal d = new BigDecimal("365");
		//
		// p = p.multiply(n.divide(d, 2, RoundingMode.HALF_DOWN));
		// System.out.println(p);
		// }
		// System.out.println("result :" + o.subtract(p));
		
		System.out.println(null instanceof String);

		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println(df.format(0.666666666));

		BigDecimal b = BigDecimal.valueOf(0.660000000).setScale(6,
				RoundingMode.HALF_UP);
		System.out.println(b.doubleValue());

		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
		// map.put(null, 1);

		// TreeMap<String, Integer> tm = new TreeMap<>();
		// tm.put(null, 1);
		int i = 1000000000;
		System.out.println(i);
		
		List<Long> l = new ArrayList<>();
		l.add(1L);
		l.add(2L);
		l.add(2L);
		l.add(4L);
		
		//System.out.println(countTriplets(l, 2));
		
		Test1 t = new Test1();
		t.test();
		System.out.println(t.a.x);
	}
	
	void test(){
		MA11 b = new MA11(12);
		a = b;
	}
	
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        // count of numbers which may form doublet if the (num * r) is identified once again.
        Map<Long, Long> map2 = new HashMap<>();
        // count of numbers which may form triplet if the (num * r) is identified once again.
        Map<Long, Long> map3 = new HashMap<>();

        long result = 0;

        for(long a : arr) {
            if(map3.containsKey(a))
                result += map3.get(a);
            
            if(map2.containsKey(a)) {
                map3.put(a * r, (map3.get(a * r) == null?0L:map3.get(a*r)) + map2.get(a));
            }

            map2.put(a * r, (map2.get(a * r) == null?0L:map2.get(a * 2)) + 1);
        }

        return result;
    }
}

class MA11 {
	int x;
	
	MA11(int x) {
		this.x = x;
	}
}

//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//int T = Integer.parseInt(br.readLine());
//
//for(int i = 0; i < T; i++) {
//    int N = Integer.parseInt(br.readLine());
//    String[] s = br.readLine().split(" ");
//    int[] a = new int[N];
//    
//    for(int k = 0; k < N; k++) {
//        a[k] = Integer.parseInt(s[k]);
//    }
//   
//   
//    printLeaders(a, N);
//}
