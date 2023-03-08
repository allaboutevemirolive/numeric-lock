package Experiment;
public class A {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        E experiment = new E();
        experiment.solve(0);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("\nDuration: " + duration + " ms");
    }
    
}
