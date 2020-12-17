  
//BinaryindexedTree Or FenWickTree


  static class BIT{
        static int[] BitTree = new int[1000];
        int sum(int index){
            int s =0;
            index+=1;
            while (index>0){
                s+=BitTree[index];
                index-=(index&-index);
            }
            return s;
        }
        public static void updateBIT(int n, int index, int val) {
            index = index + 1;
            while(index <= n) {
                BitTree[index] += val;
                index += index & (-index);
            }
        }
        void constructBITree(int arr[], int n) {
            for(int i=1; i<=n; i++)
                BitTree[i] = 0;
            for(int i = 0; i < n; i++)
                updateBIT(n, i, arr[i]);
        }
    }