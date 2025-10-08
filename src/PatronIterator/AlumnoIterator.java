package PatronIterator;

import java.util.ArrayList;
import java.util.List;

public class AlumnoIterator {
    private String nombre;
    private List<CursoIterador> cursos = new ArrayList<>();

    public AlumnoIterator(String nombre) {
        this.nombre = nombre;
    }

    public void inscribirCurso(CursoIterador curso) {
        cursos.add(curso);
    }

    public CursoIterator iterator() {
        return new IteradorCurso(cursos);
    }

    public String getNombre() {
        return nombre;
    }

    private static class IteradorCurso implements CursoIterator {
        private List<CursoIterador> cursos;
        private int posicion = 0;

        public IteradorCurso(List<CursoIterador> cursos) {
            this.cursos = cursos;
        }

        @Override
        public boolean hasNext() {
            return posicion < cursos.size();
        }

        @Override
        public CursoIterador next() {
            return cursos.get(posicion++);
        }
    }
}
