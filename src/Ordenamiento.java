import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ordenamiento {

    public static int busquedaSecuencialNombre(String nombre, ArrayList<Plato> platos) {
        for (int i = 0; i < platos.size(); i++) {
            Plato plato = platos.get(i);
            if (plato.getNombre().equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public static void ordenarPorNombre(ArrayList<Plato> platos) {
        int n = platos.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (platos.get(j).getNombre().compareTo(platos.get(j+1).getNombre()) > 0) {
                    Plato temp = platos.get(j);
                    platos.set(j, platos.get(j+1));
                    platos.set(j+1, temp);
                }
            }
        }
    }

    public static void ordenarPorPrecio(ArrayList<Plato> platos) {
        int n = platos.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (platos.get(j).getPrecio() > platos.get(j+1).getPrecio()) {
                    Plato temp = platos.get(j);
                    platos.set(j, platos.get(j+1));
                    platos.set(j+1, temp);
                }
            }
        }
    }

    public static void ordenarPorCalorias(ArrayList<Plato> platos) {
        int n = platos.size();
        for (int i = 1; i < n; ++i) {
            Plato key = platos.get(i);
            int j = i - 1;

            while (j >= 0 && platos.get(j).getCalorias() > key.getCalorias()) {
                platos.set(j + 1, platos.get(j));
                j = j - 1;
            }
            platos.set(j + 1, key);
        }
    }

    public static void ordenarPorTiempoPreparacion(ArrayList<Plato> platos) {
        int n = platos.size();
        for (int i = 1; i < n; ++i) {
            Plato key = platos.get(i);
            int j = i - 1;

            while (j >= 0 && platos.get(j).getTiempoPreparacion() > key.getTiempoPreparacion()) {
                platos.set(j + 1, platos.get(j));
                j = j - 1;
            }
            platos.set(j + 1, key);
        }
    }

    //Busquedas binarias
    public static Plato busquedaBinariaPorNombre(String nombre, ArrayList<Plato> platos) {
        int left = 0, right = platos.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = nombre.compareTo(platos.get(mid).getNombre());

            if (res == 0)
                return platos.get(mid);

            if (res > 0)
                left = mid + 1;

            else
                right = mid - 1;
        }

        return null;
    }


    public static Plato busquedaBinariaPorPrecio(double precio, ArrayList<Plato> platos) {
        int left = 0, right = platos.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (platos.get(mid).getPrecio() == precio)
                return platos.get(mid);

            if (platos.get(mid).getPrecio() < precio)
                left = mid + 1;

            else
                right = mid - 1;
        }

        return null;
    }

    public static Plato busquedaBinariaPorCalorias(double calorias, ArrayList<Plato> platos) {
        int left = 0, right = platos.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (platos.get(mid).getCalorias() == calorias)
                return platos.get(mid);

            if (platos.get(mid).getCalorias() < calorias)
                left = mid + 1;

            else
                right = mid - 1;
        }

        return null;
    }

    public static Plato busquedaBinariaPorTiempoPreparacion(int tiempoPreparacion, ArrayList<Plato> platos) {
        int left = 0, right = platos.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (platos.get(mid).getTiempoPreparacion() == tiempoPreparacion)
                return platos.get(mid);

            if (platos.get(mid).getTiempoPreparacion() < tiempoPreparacion)
                left = mid + 1;

            else
                right = mid - 1;
        }

        return null;
    }


}
