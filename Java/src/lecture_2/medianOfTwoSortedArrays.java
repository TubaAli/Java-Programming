package lecture_2;

public class medianOfTwoSortedArrays {

	public static void main(String[] args) {
		int nums1[] = {1, 12, 15, 26, 38};
		int nums2[] = {2, 13, 17, 30, 45};
		//{1, 12, 15, 26, 38}  {2, 13, 17, 30, 45}
		double median = findMedianSortedArrays(nums1, nums2);
		System.out.println("The median is "+ median);
	}
	 public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        int size = nums1.length+nums2.length;
	        int nums3[] = new int[size];
	        int i = 0, j = 0, k = 0;
	        while(i<nums1.length && j<nums2.length){
	            if(nums1[i]<nums2[j]){
	                nums3[k]=nums1[i];
	                k++; i++;
	            } else {
	                nums3[k]=nums2[j];
	                k++; j++;
	            }
	        }
	        while(i<nums1.length){
	            nums3[k]=nums1[i];
	            i++; k++;
	        }
	        while(j<nums2.length){
	            nums3[k]=nums2[j];
	            j++; k++;
	        }
	        int l = 0, r = size-1;
	        int mid = (l+r)/2;
	        return (double)(nums3[mid]);
	    }
	}
