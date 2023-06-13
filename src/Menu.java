import java.util.ArrayList;

public class Menu {

    private ArrayList<Plato> platos;

    public Menu() {
        this.platos = new ArrayList<>();
    }

    public ArrayList<Plato> getPlatos() {
        return platos;
    }

    public Plato ingresarPlato(String nombre, double precio, int calorias, int tiempoPreparacion){
        Plato plato = new Plato(nombre, precio, calorias, tiempoPreparacion);
        if(validarPlato(plato)){
            platos.add(plato);
            return plato;
        }
        return null;
    }

    public Plato modificarPlato(int i, double precio, int calorias, int tiempoPreparacion){
        platos.get(i).setPrecio(precio);
        platos.get(i).setCalorias(calorias);
        platos.get(i).setTiempoPreparacion(tiempoPreparacion);
        return platos.get(i);
    }

    public boolean validarPlato(Plato p){
        for (Plato plato : platos) {
            if (plato.getNombre().equals(p.getNombre())) {
                return false;
            }
        }
        return true;
    }

    public void eliminarPlato(int i){
        platos.remove(i);
    }

    //Imprime todos los platos
    public String imprimirMenu(){
        String text = "";
        for (Plato plato : platos) {
            text+=plato.toString();
        }
        return text;
    }

    public void quemarDatos(){
        ingresarPlato("Pizza", 15.0, 800, 20);
        ingresarPlato("Ensalada", 10.0, 300, 15);
        ingresarPlato("Burger", 12.0, 700, 25);
        ingresarPlato("Pasta", 14.0, 600, 22);
        ingresarPlato("Sopa", 8.0, 250,100);
    }

}
