import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToyStore {

    private List<Toy> toys;
    private List<Toy> prizeToys;


    public ToyStore() {
        toys = new ArrayList<>();
        prizeToys  = new ArrayList<>();
    }

    public void AddToy(Toy toy) {
        toys.add(toy);
    }

    public void updateFrequency(int toyId, double Frequency) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setFrequency(Frequency);
                break;
            }
        }
    }

    public void organizePrizeDraw() {
        for (Toy toy : toys) {
            int numPrizes = (int) (toy.getQuantity() * toy.getFrequency() / 100);
            for (int i = 0; i < numPrizes; i++) {
                prizeToys.add(toy);
            }
        }
    }

    public Toy getPrizeToy() {
        Toy prizeToy = prizeToys.remove(0);
        updateToyQuantity(prizeToy);
        savePrizeToyToFile(prizeToy);
        return prizeToy;
    }

    private void updateToyQuantity(Toy toy) {
        for (Toy t : toys) {
            if (t.getId() == toy.getId()) {
                t.setQuantity(t.getQuantity() - 1);
                break;
            }
        }
    }

    private void savePrizeToyToFile(Toy toy) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("prize_toys.txt", true));
            writer.write(toy.getName());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
