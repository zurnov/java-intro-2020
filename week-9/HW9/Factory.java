import java.util.Random;

public class Factory {
    public static void main( String [] args){
        Random random = new Random();

        Engine[] HeatManager = new Engine[random.nextInt(10)+1];
        for(int i = 0; i < HeatManager.length;i++){
            HeatManager[i] = new Engine(random.nextInt(100));
        }
        HighestToLowestEngine(HeatManager);
        PrintingEngines(HeatManager);
        System.out.println();
        Machines(random.nextInt(10)+1);

    }
    public static void HighestToLowestEngine(Engine[] array){
        for(int i = 0; i < array.length-1; i++){
            for(int j = 0; j < array.length-i-1;j++){
                if(array[j].getPower() < array[j+1].getPower()){
                    Engine temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    public static void PrintingEngines(Engine[] array){
        for (Engine element : array ){
            System.out.println(element.getPower());
        }

    }
    private static void Machines(int size){
        Random random = new Random();
        Machine[] machines = new Machine[size];
        int i = 0;
        while(i < size){
            machines[i] = new Machine();
            machines[i].setPower(random.nextInt(100));
            machines[i].setPower(random.nextInt(10));
            machines[i].setColor("Black");
            i++;
        }
        for(int j = 0; j < size;j++){
           System.out.println(machines[j].getPower());
        }
    }
}
