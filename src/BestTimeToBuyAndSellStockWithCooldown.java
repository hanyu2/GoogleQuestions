
public class BestTimeToBuyAndSellStockWithCooldown {
	public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int n = prices.length;
        int[] s0 = new int[n];
        int[] s1 = new int[n];
        int[] s2 = new int[n];
        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = 0;
        for(int i = 1; i < prices.length; i++){
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            s1[i] = Math.max(s0[i - 1] - prices[i], s1[i - 1]);
            s2[i] = prices[i] + s1[i - 1];
        }
        return Math.max(s0[n - 1], s2[n - 1]);
    }
}
