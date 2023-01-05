package CrossTraining;

public class CanIWin {

    public static int max(int a ,int b)
    {
        if(a>b)
            return a;
        else
            return b;
    }

    public static int min(int a,int b)
    {
        if(a<b)
            return a;
        else
            return b;
    }
    public static int find_ans(int[] nums,int i,int j)
    {
//Only one element in the array means - return that element
        if(i==j)
            return nums[i];

//If two elements are there - then retun max(two elements)
        if(i+1==j)
            return max(nums[i],nums[j]);

//If the player chooses front element i then Opponent can choose [i+1] or [j]
//If opponent choose i+1 then proceed with [i+2] and [j]
//If opponent choose j then proceed with [i+1] and [j-1]

        int x=nums[i] + min(find_ans(nums,i+2,j),find_ans(nums,i+1,j-1));

//If the player chooses rear element j then Opponent can choose [i] or [j-1]
//If opponent choose i then proceed with [i+1] and [j-1]
//If opponent choose j-1 then proceed with [i] and [j-2]


        int y=nums[j]+min(find_ans(nums,i+1,j-1),find_ans(nums,i,j-2));

        return max(x,y);

    }

    public static int canWin(int[] nums)
    {
        int size=nums.length;

        int ans=find_ans(nums,0,size-1);

        return ans;


    }

    public static void main(String[] args)
    {
        int[] arr={2,1,100,3};

        System.out.print(canWin(arr));

    }
}
