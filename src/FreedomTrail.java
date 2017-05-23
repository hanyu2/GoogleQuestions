
public class FreedomTrail {
	public static int findRotateSteps(String ring, String key) {
        if(ring.length()==0 || key.length()==0) return 0;
        return findShortest(ring.toCharArray(), 0, key.toCharArray(), 0, new int[ring.length()][key.length()]);
    }
    private static int findShortest(char[] arr, int p,  char[] key, int idx, int[][] mem) {
        if(idx==key.length) return 0;
        if(mem[p][idx]>0) return mem[p][idx];
        int c1 = 0, c2=0,i=p, j=p;
        for(; arr[i]!=key[idx]; c1++) {
            i=(i+1)%arr.length;
        }
        for(; arr[j]!=key[idx];c2++) {
            j=(j-1+arr.length)%arr.length;
        }
        if(i==j) { //rotate to same location then use the less count one
            mem[p][idx]= Math.min(c1,c2)+1 + findShortest(arr, i, key, idx+1, mem);
        } else {
            int r1 = findShortest(arr, i, key, idx+1, mem) + c1 + 1;
            int r2 = findShortest(arr, j, key, idx+1, mem) + c2 + 1;
            mem[p][idx] = Math.min(r1,r2);
        }
        return mem[p][idx];
    }
	public static void main(String[] args) {
		System.out.println(findRotateSteps("godding", "gd"));
	}
}
