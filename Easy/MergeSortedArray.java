class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] data = new int[m+n];
        int index1=0;
        int index2=0;

        for(int i = 0 ; i<m+n ; i++){
            if(index1<m && index2<n){
                if(nums1[index1]<=nums2[index2]){
                    data[i]=nums1[index1];
                    index1++;
                }else{
                    data[i]=nums2[index2];
                    index2++;
                }
            }else if(index1<m && index2>=n){
                data[i]=nums1[index1];
                index1++;
            }else{
                data[i]=nums2[index2];
                index2++;
            }
        }

        for(int i = 0 ; i<m+n ; i++){
            nums1[i]=data[i];
        }
    }
}
