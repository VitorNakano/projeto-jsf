package bean.application;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static java.util.Arrays.asList;

@Named
@ApplicationScoped
public class TesteApplicationBean implements Serializable {
    private List<String> categoriaList;

    @PostConstruct
    public void init() {
        System.out.println("Entrando no PostConstruct do ApplicationScoped");
        categoriaList = asList("RPG", "Sci-Fi", "Terror");
    }

    public void mudarLista() {
        categoriaList = asList("RPG", "Sci-Fi", "Terror", "Comédia");
    }

    public List<String> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<String> categoriaList) {
        this.categoriaList = categoriaList;
    }
}
