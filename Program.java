public class Program {
    
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        toyStore.AddToy(new Toy(1, "Самолетик", 20, 10));
        toyStore.AddToy(new Toy(2, "Машинка", 10, 15));
        toyStore.AddToy(new Toy(3, "Мишка", 15, 10));

        toyStore.updateFrequency(3, 3); 

        toyStore.organizePrizeDraw();

        Toy prizeToy = toyStore.getPrizeToy();
        System.out.println(" Ваш приз " + prizeToy.getName());
    }
}
