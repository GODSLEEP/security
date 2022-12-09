package hanoi_tower;

public class HanoiDemo {
    public static int hanoiCalledCount = 0;

    public static void main(String[] args) {
        hanoi(4,"A","B","C"); //n = number of the plate
        System.out.println("Total step is:"+hanoiCalledCount+" steps");
    }

    public static void hanoi(int n,String source,String target,String assist){
        if(n<=0){
            return ;
        }
        if(n==1){//When n == 1 moving plate to the target.
            System.out.printf("moving one plate from %s bar to %s bar\n",source,target);
            hanoiCalledCount++;
        }else{
            //moving n-1 plates from “source” to“assist”
            hanoi(n-1,source,assist,target);
            ////moving plate in the bottom into the "target"
            System.out.printf("moving one plate from %s bar to %s bar\n",source,target);
            hanoiCalledCount++;//计数器加一
            //moving n-1 plates from “assist” to “target”
            hanoi(n-1,assist,target,source);
        }
    }
}
