public class Merge{

public static void mergesort(int[] data){
  if(data.length <= 1){return;}
  mergesort(data,0,data.length-1);
}

public static void insertionSort(int[] ary, int lo, int hi) {
  for(int i = lo; i < hi+1; i++) {
    int current = ary[i];
    int place = i;
    while(place != 0 && ary[place - 1] > current) {
      ary[place] = ary[place - 1];
      ary[place - 1] = current;
      place--;
    }
  }
}

public static void mergesort(int[] data, int lo, int hi){
  if(hi - lo <= 50){
    insertionSort(data,lo,hi);
    return;
  }
  int point = (hi+1)/2;
  int[] LSort = new int[point];
  int limit1 = LSort.length-1;
  for(int i = 0; i <= limit1; i++){
    LSort[i] = data[i];
  }
  int[] RSort = new int[hi+1-point];
  int limit2 = RSort.length-1;
  for(int i = 0; i <= limit2; i++){
    RSort[i] = data[point+i];
  }
  mergesort(LSort,0,limit1);
  mergesort(RSort,0,limit2);
  merge(data,LSort,RSort);
}

public static void merge(int[] orig, int[] data1, int[] data2){
  for(int index = 0, i = 0, j = 0; index < orig.length; index++){
    if(data1.length <= i){
      orig[index] = data2[j];
      j++;
    }
    else if(data2.length <= j){
      orig[index] = data1[i];
      i++;
    }
    else if(data2[j] >= data1[i]){
      orig[index] = data1[i];
      i++;
    }
    else{
      orig[index] = data2[j];
      j++;
    }
  }
}

public static void exchange(int num1, int num2, int[] data){ // these are indices
  int temp = data[num1];
  data[num1] = data[num2];
  data[num2] = temp;
}

public static String printArray(int[] ary) {
String result = "[";
for (int i = 0; i < ary.length ; i++) {
result += " " + ary[i];
if (i != ary.length - 1) {
  result += ",";
}
}
return result + "]";
}

public static void main(String[] args){
  int[] data = new int[] {3,3,1,1,2,2};
  int[] data2 = new int[] {2,6,8,9,3,21,32,12,9,6,7,4,8};
  System.out.println(printArray(data2));
  mergesort(data2);
  System.out.println(printArray(data2));

}



}
