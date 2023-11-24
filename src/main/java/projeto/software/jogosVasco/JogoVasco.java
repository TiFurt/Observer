package projeto.software.jogosVasco;

import java.util.Observable;

public class JogoVasco extends Observable {
    private String data;
    private String local;
    private String adversario;

    public JogoVasco(String adversario) {
        this.adversario = adversario;
    }

    public void agendarJogo(String data, String local) {
        this.data = data;
        this.local = local;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "JogoVasco{" +
                "data=" + data +
                ", local='" + local + '\'' +
                ", adversario='" + adversario + '\'' +
                '}';
    }
}
