class Solution {
    public int numberOfMatches(int n) {
        
        int matches = 0; 
        
        for(int i=n; i>=2; i--){
            if(n % 2 == 0){
            matches += n/2;
            n = n /2;
            }else{
                matches += (n-1)/2;
                n = (n-1)/2 + 1;
            }
        }
        return matches;
    }
}